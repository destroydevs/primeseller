package ru.spigotmc.destroy.primeseller.locale;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import ru.spigotmc.destroy.primeseller.locale.reflect.Comment;
import ru.spigotmc.destroy.primeseller.locale.reflect.CommentType;
import ru.spigotmc.destroy.primeseller.locale.reflect.Path;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class ConfigurationCreator {

    public static void createConfig(String configName, String locale, Plugin plugin) {
        Object configObject;

        if (locale.equalsIgnoreCase("ru")) {
            if (configName.equalsIgnoreCase("menu.yml")) {
                configObject = new RussianLocale.Menu();
            } else if (configName.equalsIgnoreCase("config.yml")) {
                configObject = new RussianLocale.Config();
            } else {
                return;
            }
        } else if (locale.equalsIgnoreCase("en")) {
            if (configName.equalsIgnoreCase("menu.yml")) {
                configObject = new EnglishLocale.Menu();
            } else if (configName.equalsIgnoreCase("config.yml")) {
                configObject = new EnglishLocale.Config();
            } else {
                return;
            }
        } else {
            return;
        }

        File configFile = new File(plugin.getDataFolder(), configName);
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        try {
            processFields(configObject, configObject.getClass(), config, null);
            config.save(configFile);
        } catch (IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void processFields(Object obj, Class<?> clazz, FileConfiguration config, String currentPath) throws IllegalAccessException {
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            String fieldPath = currentPath != null ? currentPath + "." + field.getName() : field.getName();

            if (field.isAnnotationPresent(Path.class)) {
                Path path = field.getAnnotation(Path.class);
                fieldPath = path.path();
            }

            Object value = field.get(obj);
            if (value == null) {
                try {
                    value = field.getType().newInstance();
                    field.set(obj, value);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }

            if (isSimpleType(field.getType())) {
                config.set(fieldPath, value);
            } else if (field.getType().equals(List.class)) {
                config.set(fieldPath, value);
            } else {
                processFields(value, field.getType(), config, fieldPath);
            }

            if (field.isAnnotationPresent(Comment.class)) {
                Comment comment = field.getAnnotation(Comment.class);

                if (comment.type() == CommentType.ABOVE) {
                    config.setComments(fieldPath, List.of(comment.comment()));
                } else {
                    config.setInlineComments(fieldPath, List.of(comment.comment()));
                }
            }
        }
    }

    public static <T extends Class<T>> Class<T> loadConfig(String configName, Plugin plugin, T configObject) {
        File configFile = new File(plugin.getDataFolder(), configName);
        if (!configFile.exists()) {
            return null;
        }

        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        try {
            loadFields(configObject, configObject.getClass(), config, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return configObject;
    }

    private static void loadFields(Object obj, Class<?> clazz, FileConfiguration config, String currentPath) throws IllegalAccessException {
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            String fieldPath = currentPath != null ? currentPath + "." + field.getName() : field.getName();

            if (field.isAnnotationPresent(Path.class)) {
                Path path = field.getAnnotation(Path.class);
                fieldPath = path.path();
            }

            if (config.contains(fieldPath)) {
                Object value = config.get(fieldPath);
                if (isSimpleType(field.getType())) {
                    field.set(obj, value);
                } else if (field.getType().equals(List.class)) {
                    field.set(obj, value);
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
                    loadFields(nestedObj, field.getType(), config, fieldPath);
                }
            }
        }
    }

    private static boolean isSimpleType(Class<?> clazz) {
        return clazz.isPrimitive() || clazz.equals(String.class) || Number.class.isAssignableFrom(clazz) ||
                clazz.equals(Character.class) || clazz.equals(Boolean.class);
    }

}