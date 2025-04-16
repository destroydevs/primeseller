package ru.destroy.primeseller.locale;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import ru.destroy.primeseller.locale.reflect.Comment;
import ru.destroy.primeseller.locale.reflect.CommentType;
import ru.destroy.primeseller.locale.reflect.Path;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class ConfigurationCreator {

    public static void createConfig(String configName, Locales locale, Plugin plugin) {
        Object configObject = null;
        if (configName.equalsIgnoreCase("menu.yml")) {
            switch (locale) {
                case EN:
                    configObject = new EnglishLocale.Menu();
                    break;
                case RU:
                    configObject = new RussianLocale.Menu();
                    break;
             default:
                return;
            }
        } else if (configName.equalsIgnoreCase("config.yml")) {
            switch (locale) {
                case EN:
                    configObject = new EnglishLocale.Config();
                    break;
                case RU:
                    configObject = new RussianLocale.Config();
                    break;
                default:
                    return;
            }
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
        if (clazz == null) return;
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

    private static boolean isSimpleType(Class<?> clazz) {
        return clazz.isPrimitive() || clazz.equals(String.class) || Number.class.isAssignableFrom(clazz) ||
                clazz.equals(Character.class) || clazz.equals(Boolean.class);
    }

}