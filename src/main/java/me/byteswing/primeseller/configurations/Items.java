package me.byteswing.primeseller.configurations;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import me.byteswing.primeseller.util.Randomizer;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class Items {
    private static Plugin plugin;
    private static final DecimalFormat format = new DecimalFormat("##.##");
    private static File file;
    private static FileConfiguration config;

    public void loadItemsYaml(Plugin main) {
        plugin = main;
        file = new File(main.getDataFolder(), "items.yml");
        if (!file.exists()) {
            main.saveResource("items.yml", true);
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static void addItem(ItemStack item, double min, double max, boolean limited) {
        String mn = format.format(min);
        String mx = format.format(max);
        item.setAmount(1);
        String random = Randomizer.randomString(9);
        if (limited) {
            config.set("limited.items." + random + ".min-price", mn);
            config.set("limited.items." + random + ".max-price", mx);
            config.set("limited.items." + random + ".item", item);
        }
        if (!limited) {
            config.set("unlimited.items." + random + ".min-price", mn);
            config.set("unlimited.items." + random + ".max-price", mx);
            config.set("unlimited.items." + random + ".item", item);
        }
        try {
            config.save(file);
        } catch (IOException e) {
            plugin.getLogger().severe("Error when saving the config: " + e.getMessage());
        }
    }

    public static void reloadConfig() {
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            plugin.getLogger().warning("Failed to upload items.yml!");
        }

    }

    public static FileConfiguration getConfig() {
        return config;
    }
}
