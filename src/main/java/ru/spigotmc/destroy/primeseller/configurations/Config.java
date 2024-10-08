package ru.spigotmc.destroy.primeseller.configurations;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import ru.spigotmc.destroy.primeseller.locale.ConfigurationCreator;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Config {

    private static File file;
    private static FileConfiguration config;

    public void loadConfigYaml(Plugin main) {
        file = new File(main.getDataFolder(), "config.yml");
        if (!file.exists()) {
            ConfigurationCreator.createConfig("config.yml",main);
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static void reloadConfig() {
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            Bukkit.getLogger().warning("Не удалось загрузить config.yml!");
        }
    }

    public static FileConfiguration getConfig() {
        return config;
    }
}
