package me.byteswing.primeseller.configurations;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;


public class Config {
    private static Plugin plugin;
    private static FileConfiguration config;

    public void loadConfig(Plugin main) {
        plugin = main;
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
    }

    public static void reloadConfig() {
        plugin.reloadConfig();
        config = plugin.getConfig();
    }

    public static FileConfiguration getConfig() {
        return config;
    }

    public static ConfigurationSection getMenuConfig() {
        return config.getConfigurationSection("menu");
    }

    public static ConfigurationSection getAutoSellConfig() {
        return config.getConfigurationSection("autosell-gui");
    }

    public static String getMessage(String key) {
        return config.getString("messages." + key, "<red>message-" + key + ": not found");
    }
}
