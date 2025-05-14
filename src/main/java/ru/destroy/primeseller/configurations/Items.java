package ru.destroy.primeseller.configurations;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import ru.destroy.primeseller.util.Randomizer;

import java.text.DecimalFormat;

public class Items extends AbstractConfig {

    private static final DecimalFormat format = new DecimalFormat("##.##");

    public Items(String configName) {
        super(configName);
    }

    private final FileConfiguration config = getConfig();

    public void addItem(ItemStack item, double min, double max, boolean limited) {
        String mn = format.format(min);
        String mx = format.format(max);
        item.setAmount(1);
        String random = Randomizer.randomString(9);
        if(limited) {
            config.set("limited.items."+random+".min-price", mn);
            config.set("limited.items."+random+".max-price", mx);
            config.set("limited.items."+random+".item", item);
        }
        if(!limited) {
            config.set("unlimited.items."+random+".min-price", mn);
            config.set("unlimited.items."+random+".max-price", mx);
            config.set("unlimited.items."+ random +".item", item);
        }

        saveConfig(config);
    }

}
