package ru.spigotmc.destroy.primeseller.locale;

import org.bukkit.plugin.Plugin;
import org.yaml.snakeyaml.DumperOptions;
import ru.spigotmc.destroy.primeseller.configurations.Lang;
import ru.spigotmc.destroy.primeseller.locale.reflect.Comment;
import ru.spigotmc.destroy.primeseller.locale.reflect.CommentType;
import ru.spigotmc.destroy.primeseller.locale.reflect.Path;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationCreator {

    public static void createConfig(String configName, Plugin plugin) {
        EnglishLocale.Menu menu = new EnglishLocale.Menu();
        EnglishLocale.Config config = new EnglishLocale.Config();
        RussianLocale.Menu menuRu = new RussianLocale.Menu();
        RussianLocale.Config configRu = new RussianLocale.Config();
        if (Lang.getLocale().equalsIgnoreCase("ru")) {

            try {
                String yamlOutput = generateConfig(menuRu);
                if (configName.equalsIgnoreCase("menu.yml")) {
                    saveToFile(yamlOutput, plugin.getDataFolder()+"/"+configName);
                } else if (configName.equalsIgnoreCase("config.yml")) {
                    yamlOutput = generateConfig(configRu);
                    saveToFile(yamlOutput, plugin.getDataFolder()+"/"+configName);
                }

            } catch (IllegalAccessException | IOException e) {
                e.printStackTrace();
            }
        }
        if (Lang.getLocale().equalsIgnoreCase("en")) {

            try {
                String yamlOutput = generateConfig(menu);
                if (configName.equalsIgnoreCase("menu.yml")) {
                    saveToFile(yamlOutput, plugin.getDataFolder()+"/"+configName);
                } else if (configName.equalsIgnoreCase("config.yml")) {
                    yamlOutput = generateConfig(config);
                    saveToFile(yamlOutput, plugin.getDataFolder()+"/"+configName);
                }

            } catch (IllegalAccessException | IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static String generateConfig(Object configObject) throws IllegalAccessException {
        Map<String, Object> yamlMap = new LinkedHashMap<>();
        processFields(configObject, configObject.getClass(), yamlMap, null);

        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setIndent(2);
        options.setIndicatorIndent(0);


        StringBuilder yamlOutput = new StringBuilder();
        addMapWithComments(yamlOutput, yamlMap, "");

        return yamlOutput.toString();
    }

    private static void processFields(Object obj, Class<?> clazz, Map<String, Object> yamlMap, String currentPath) throws IllegalAccessException {
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            String fieldPath = currentPath != null ? currentPath + "." + field.getName() : field.getName();

            if (field.isAnnotationPresent(Path.class)) {
                Path path = field.getAnnotation(Path.class);
                fieldPath = path.path();
            }

            if (field.isAnnotationPresent(Comment.class)) {
                Comment comment = field.getAnnotation(Comment.class);
                yamlMap.put(fieldPath + "_comment", comment.comment());
                yamlMap.put(fieldPath + "_comment_type", comment.type());
            }

            if (isSimpleType(field.getType())) {
                addToNestedMap(yamlMap, fieldPath, formatValue(field.get(obj)));
            } else if (field.getType().equals(List.class)) {
                addToNestedMap(yamlMap, fieldPath, formatList((List<?>) field.get(obj)));
            } else {
                Object nestedObj = field.get(obj);
                if (nestedObj == null) {
                    try {
                        nestedObj = field.getType().newInstance();
                        field.set(obj, nestedObj);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }

                Map<String, Object> nestedMap = new LinkedHashMap<>();
                processFields(nestedObj, field.getType(), nestedMap, fieldPath);
                addToNestedMap(yamlMap, fieldPath, nestedMap);
            }
        }
    }

    private static void addToNestedMap(Map<String, Object> map, String path, Object value) {
        String[] keys = path.split("\\.");
        Map<String, Object> currentMap = map;

        for (int i = 0; i < keys.length - 1; i++) {
            String key = keys[i];
            currentMap.computeIfAbsent(key, k -> new LinkedHashMap<>());
            currentMap = (Map<String, Object>) currentMap.get(key);
        }

        currentMap.put(keys[keys.length - 1], value);
    }

    private static void addMapWithComments(StringBuilder builder, Map<String, Object> map, String indent) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key.endsWith("_comment") || key.endsWith("_comment_type")) {
                continue;
            }

            if (value instanceof Map) {
                if (map.containsKey(key + "_comment")) {
                    CommentType commentType = (CommentType) map.get(key + "_comment_type");
                    if (CommentType.ABOVE.equals(commentType)) {
                        builder.append(indent).append("# ").append(map.get(key + "_comment")).append("\n");
                    }
                }
                builder.append(indent).append(key).append(":\n");
                addMapWithComments(builder, (Map<String, Object>) value, indent + "  ");
            } else if (value instanceof List) {
                if (map.containsKey(key + "_comment")) {
                    CommentType commentType = (CommentType) map.get(key + "_comment_type");
                    if (CommentType.ABOVE.equals(commentType)) {
                        builder.append(indent).append("# ").append(map.get(key + "_comment")).append("\n");
                    }
                }
                builder.append(indent).append(key).append(":\n");
                for (Object item : (List<?>) value) {
                    if (item instanceof Number) {
                        builder.append(indent).append("  - ").append(item).append("\n");
                    } else {
                        builder.append(indent).append("  - '").append(item).append("'\n");
                    }
                }
            } else {
                if (value instanceof Boolean || value instanceof Number) {
                    builder.append(indent).append(key).append(": ").append(value);
                } else {
                    builder.append(indent).append(key).append(": '").append(value).append("'");
                }
                if (map.containsKey(key + "_comment")) {
                    CommentType commentType = (CommentType) map.get(key + "_comment_type");
                    if (CommentType.IN_LINE.equals(commentType)) {
                        builder.append(" # ").append(map.get(key + "_comment")).append("\n");
                    } else {
                        builder.append("\n");
                    }
                    builder.append("\n");
                } else {
                    builder.append("\n");
                }
            }
        }
    }

    private static boolean isSimpleType(Class<?> clazz) {
        return clazz.isPrimitive() || clazz.equals(String.class) || Number.class.isAssignableFrom(clazz) || clazz.equals(Character.class) || clazz.equals(Boolean.class);
    }

    private static Object formatValue(Object value) {
        if (value instanceof Number) {
            if (value instanceof Integer || value instanceof Long) {
                return value;
            } else {
                return String.format("%,.2f", value).replace('.', ',');
            }
        }
        return value;
    }

    private static List<Object> formatList(List<?> list) {
        List<Object> formattedList = new java.util.ArrayList<>();
        for (Object item : list) {
            formattedList.add(formatValue(item));
        }
        return formattedList;
    }

    private static void saveToFile(String content, String filePath) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8)) {
            writer.write(content);
        }
    }
}
