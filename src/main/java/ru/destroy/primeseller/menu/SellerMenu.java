package ru.destroy.primeseller.menu;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import ru.destroy.primeseller.configurations.Items;
import ru.destroy.primeseller.configurations.Menu;
import ru.destroy.primeseller.configurations.data.ItemData;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class SellerMenu {

    public static double generate(double min, double max) {
        if (min < max) {
            return min;
        }
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    public static void createUnLimItems() {
        List<String> randomItems = new ArrayList<>(Items.getConfig().getConfigurationSection("unlimited.items").getKeys(false));
        List<Integer> unlimSlots = new ArrayList<>(Menu.getConfig().getIntegerList("unlim-items.slots"));

        for (Integer unlimSlot : unlimSlots) {
            if (randomItems.isEmpty()) {
                break;
            }
            int random = (int) (Math.random() * randomItems.size());
            String item = randomItems.get(random);
            double min = Double.parseDouble(Items.getConfig().getString("unlimited.items." + item + ".min-price").replace(",", "."));
            double max = Double.parseDouble(Items.getConfig().getString("unlimited.items." + item + ".max-price").replace(",", "."));
            int lim = Items.getConfig().getInt("limited.limit-per-items");
            double price = generate(min, max);
            try {
                ItemData.saveMaterial(new ItemStack(Material.valueOf(item.toUpperCase(Locale.ENGLISH))), unlimSlot, price, lim, false);
            } catch (IllegalArgumentException e) {
                ItemStack itemStack = Items.getConfig().getItemStack("unlimited.items." + item + ".item");
                ItemData.saveMaterial(itemStack, unlimSlot, price, lim, false);
            }
            randomItems.remove(random);
        }
    }

    public static void createLimItems() {
        List<String> randomItems = new ArrayList<>(Items.getConfig().getConfigurationSection("limited.items").getKeys(false));
        List<Integer> limSlots = new ArrayList<>(Menu.getConfig().getIntegerList("lim-items.slots"));

        for(int i = 0; i < limSlots.size(); i++) {
            if(randomItems.isEmpty()) {
                break;
            }
            int random = (int) (Math.random()*randomItems.size());
            String item = randomItems.get(random);
            double min = Double.parseDouble(Items.getConfig().getString("limited.items." + item + ".min-price").replace(",", "."));
            double max = Double.parseDouble(Items.getConfig().getString("limited.items." + item + ".max-price").replace(",", "."));
            int lim = Items.getConfig().getInt("limited.limit-per-items");
            double price = generate(min, max);
            try {
                ItemData.saveMaterial(new ItemStack(Material.valueOf(item)), limSlots.get(i), price, lim, true);
            } catch (IllegalArgumentException e) {
                ItemStack itemStack = Items.getConfig().getItemStack("limited.items."+item+".item");
                ItemData.saveMaterial(itemStack, limSlots.get(i), price, lim, true);
            }
            randomItems.remove(random);
            if(i == limSlots.size()) {
                limSlots.clear();
                randomItems.clear();
            }
        }
    }
}
