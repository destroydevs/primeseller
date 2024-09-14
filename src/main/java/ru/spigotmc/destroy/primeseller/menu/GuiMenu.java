package ru.spigotmc.destroy.primeseller.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.spigotmc.destroy.primeseller.PrimeSeller;
import ru.spigotmc.destroy.primeseller.configurations.Menu;
import ru.spigotmc.destroy.primeseller.util.Chat;
import ru.spigotmc.destroy.primeseller.util.Updater;
import ru.spigotmc.destroy.primeseller.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class GuiMenu {

    public static final HashMap<UUID, Integer> tasks = new HashMap<>();

    public static void open(Player p, PrimeSeller main) {
        Inventory inv = Bukkit.createInventory(p, Menu.getConfig().getInt("size"), "§7§0"+Menu.getConfig().getString("title"));
        List<String> unlim = new ArrayList<>();
        List<String> lim = new ArrayList<>();
        List<String> countdown = new ArrayList<>();
        if(!Util.playerSellItems.containsKey(p.getUniqueId())) {
            Util.playerSellItems.put(p.getUniqueId(), 0);
        }

        try {
            Util.fillInventory(inv, countdown, unlim, lim, p);
        } catch (NullPointerException e) {
            GuiMenu.open(p, main);
            return;
        }
        if(!tasks.containsKey(p.getUniqueId())) {
            tasks.put(p.getUniqueId(), Bukkit.getScheduler().runTaskTimer(main, () -> {
                Bukkit.getScheduler().runTaskTimer(main, ()-> {
                    if (Util.update && tasks.containsKey(p.getUniqueId())) {
                        try {
                            Util.fillInventory(inv, countdown, unlim, lim, p);
                        } catch (NullPointerException e) {
                            GuiMenu.open(p, main);
                            return;
                        }
                        Util.update = false;
                    }
                },0,20);


                for (Integer i : Menu.getConfig().getIntegerList("countdown.slots")) {
                    String name = Menu.getConfig().getString("countdown.material");
                    int modelId = Menu.getConfig().getInt("countdown.model-data",0);
                    ItemStack item = new ItemStack(Material.BARRIER);
                    if(name != null) {
                        if (name.startsWith("basehead-")) {
                            String url = name.replace("basehead-", "");
                            item = Util.getSkull(url);
                        } else {
                            item = new ItemStack(Material.valueOf(name));
                        }
                    }
                    ItemMeta meta = item.getItemMeta();
                    for (String s : Menu.getConfig().getStringList("countdown.lore")) {
                        countdown.add(Chat.color(s
                                .replace("%lim-time%", Updater.getLimitedTime(2))
                                .replace("%unlim-time%", Updater.getUnLimitedTime(2))
                                .replace("%lim-time-format%", Util.limitedFormat)
                                .replace("%unlim-time-format%", Util.unlimitedFormat)));
                    }
                    meta.setLore(countdown);
                    meta.setCustomModelData(modelId);
                    name = Menu.getConfig().getString("countdown.name");
                    meta.setDisplayName(Chat.color(name));
                    item.setItemMeta(meta);
                    inv.setItem(i, item);
                    countdown.clear();
                }
            }, 0, 20).getTaskId());
        }
        p.openInventory(inv);
    }

    public static void update(Player p, Inventory inv) {
        List<String> unlim = new ArrayList<>();
        List<String> lim = new ArrayList<>();
        List<String> countdown = new ArrayList<>();
        if(!Util.playerSellItems.containsKey(p.getUniqueId())) {
            Util.playerSellItems.put(p.getUniqueId(), 0);
        }
        try {
            Util.fillInventory(inv, countdown, unlim, lim, p);
        } catch (NullPointerException e) {
            update(p, inv);
            return;
        }
        p.updateInventory();
    }
}
