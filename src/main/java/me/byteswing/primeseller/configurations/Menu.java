package me.byteswing.primeseller.configurations;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import me.byteswing.primeseller.locale.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

public class Menu {

    private static File file;
    private static FileConfiguration config;

    public void loadMenuYaml(Plugin main) {
        file = new File(main.getDataFolder(), "menu.yml");
        if (!file.exists()) {
            ConfigurationCreator.createConfig("menu.yml",main);
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static void reloadConfig() {
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            Bukkit.getLogger().warning("Не удалось загрузить menu.yml!");
        }
    }

    public static FileConfiguration getConfig() {
        return config;
    }
}
