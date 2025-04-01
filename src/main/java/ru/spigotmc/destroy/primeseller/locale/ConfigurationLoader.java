package ru.spigotmc.destroy.primeseller.locale;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import ru.spigotmc.destroy.primeseller.locale.reflect.Path;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

public class ConfigurationLoader {

    public static void loadConfigs(Plugin plugin, Locale localeConfig) {
        loadConfigFile("menu.yml", plugin, localeConfig.menu, localeConfig.menu.getClass(), null);
        loadConfigFile("config.yml", plugin, localeConfig.config, localeConfig.config.getClass(), null);
    }

    private static void loadConfigFile(String fileName, Plugin plugin, Object obj, Class<?> clazz, String basePath) {
        File configFile = new File(plugin.getDataFolder(), fileName);
        if (!configFile.exists()) {
            plugin.getLogger().warning("Файл " + fileName + " не найден!");
            return;
        }

        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
        try {
            loadFields(obj, clazz, config, basePath);
        } catch (IllegalAccessException | InstantiationException e) {
            plugin.getLogger().severe("Ошибка загрузки " + fileName + ": " + e.getMessage());
        }
    }

    private static void loadFields(Object obj, Class<?> clazz, FileConfiguration config, String currentPath)
            throws IllegalAccessException, InstantiationException {
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldPath = currentPath != null ? currentPath + "." + field.getName() : field.getName();

            if (field.isAnnotationPresent(Path.class)) {
                fieldPath = field.getAnnotation(Path.class).path();
            }

            if (config.contains(fieldPath)) {
                Object value = config.get(fieldPath);
                if (isSimpleType(field.getType()) || field.getType().equals(List.class)) {
                    field.set(obj, value);
                } else {
                    Object nestedObj = field.get(obj);
                    if (nestedObj == null) {
                        nestedObj = field.getType().newInstance();
                        field.set(obj, nestedObj);
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
