package ru.spigotmc.destroy.primeseller.managers;

import org.bukkit.plugin.Plugin;
import ru.spigotmc.destroy.primeseller.configurations.Config;
import ru.spigotmc.destroy.primeseller.configurations.Items;
import ru.spigotmc.destroy.primeseller.configurations.Lang;
import ru.spigotmc.destroy.primeseller.configurations.Menu;

public class ConfigManager {

    private static final Menu m = new Menu();
    private static final Items i = new Items();
    private static final Config c = new Config();
    private static final Lang l = new Lang();

    public static void loadConfigurations(Plugin plugin) {
        l.loadYaml(plugin);
        c.loadConfigYaml(plugin);
        i.loadItemsYaml(plugin);
        m.loadMenuYaml(plugin);
    }

    public static void reloadConfigurations() {
        Lang.reloadConfig();
        Config.reloadConfig();
        Items.reloadConfig();
        Menu.reloadConfig();
    }
}
