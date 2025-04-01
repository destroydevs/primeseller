package ru.spigotmc.destroy.primeseller.managers;

import org.bukkit.plugin.Plugin;
import ru.spigotmc.destroy.primeseller.configurations.Config;
import ru.spigotmc.destroy.primeseller.configurations.Items;
import ru.spigotmc.destroy.primeseller.configurations.Lang;
import ru.spigotmc.destroy.primeseller.configurations.Menu;

public class ConfigManager {

    private static final Menu menu = new Menu("menu.yml");
    private static final Items items = new Items("items.yml");
    private static final Config config = new Config("config.yml");
    private static final Lang lang = new Lang("lang.yml");

    public static void loadConfigurations(Plugin plugin) {
        lang.loadYaml(plugin, "en");
        config.loadYaml(plugin, lang.getLocale());
        items.loadYaml(plugin, lang.getLocale());
        menu.loadYaml(plugin, lang.getLocale());
    }

    public static void reloadConfigurations() {
        lang.reloadConfig();
        config.reloadConfig();
        items.reloadConfig();
        menu.reloadConfig();
    }
}
