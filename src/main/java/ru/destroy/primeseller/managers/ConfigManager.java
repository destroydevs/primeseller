package ru.destroy.primeseller.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import ru.destroy.primeseller.configurations.Lang;
import ru.destroy.primeseller.configurations.Locales;
import ru.destroy.primeseller.configurations.Config;
import ru.destroy.primeseller.configurations.Items;
import ru.destroy.primeseller.configurations.Menu;

public class ConfigManager {

    private static final Menu menu = new Menu("menu.yml");
    private static final Items items = new Items("items.yml");
    private static final Config config = new Config("config.yml");
    private static final Lang lang = new Lang("lang.yml");

    public static void loadConfigurations(Plugin plugin) {
        lang.loadYaml(plugin, Locales.EN);
        config.loadYaml(plugin, lang.getLocale());
        items.loadYaml(plugin, lang.getLocale());
        menu.loadYaml(plugin, lang.getLocale());
    }

    public static Config getConfig() {
        return config;
    }
    public static FileConfiguration getConfigFile() {
        return getConfig().getConfig();
    }

    public static Items getItems() {
        return items;
    }

    public static FileConfiguration getItemsFile() {
        return getItems().getConfig();
    }

    public static Lang getLang() {
        return lang;
    }

    public static Menu getMenu() {
        return menu;
    }

    public static FileConfiguration getMenuFile() {
        return getMenu().getConfig();
    }

    public static void reloadConfigurations() {
        lang.reloadConfig();
        config.reloadConfig();
        items.reloadConfig();
        menu.reloadConfig();
    }
}
