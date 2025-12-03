package me.byteswing.primeseller.managers;

import org.bukkit.plugin.Plugin;
import me.byteswing.primeseller.configurations.Config;
import me.byteswing.primeseller.configurations.Items;

public class ConfigManager {

    private static final Items i = new Items();
    private static final Config c = new Config();

    public static void loadConfigurations(Plugin plugin) {
        c.loadConfig(plugin);
        i.loadItemsYaml(plugin);
    }

    public static void reloadConfigurations() {
        Config.reloadConfig();
        Items.reloadConfig();
    }
}
