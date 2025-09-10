package me.byteswing.primeseller.configurations;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Lang {
    private static File file;
    private static FileConfiguration config;

    public void loadYaml(Plugin main) {
        file = new File(main.getDataFolder(), "lang.yml");
        if (!file.exists()) {
            main.saveResource("lang.yml", true);
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static void reloadConfig() {
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            Bukkit.getLogger().warning("Не удалось загрузить lang.yml!");
        }
    }

    public static String getLocale() {
        return config.getString("language");
    }
}
