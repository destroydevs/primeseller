package ru.spigotmc.destroy.primeseller.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import ru.spigotmc.destroy.primeseller.PrimeSeller;
import ru.spigotmc.destroy.primeseller.configurations.Config;
import ru.spigotmc.destroy.primeseller.configurations.Items;
import ru.spigotmc.destroy.primeseller.configurations.Menu;
import ru.spigotmc.destroy.primeseller.configurations.database.MapBase;
import ru.spigotmc.destroy.primeseller.configurations.database.SellItem;
import ru.spigotmc.destroy.primeseller.menu.GuiMenu;
import ru.spigotmc.destroy.primeseller.util.Chat;
import ru.spigotmc.destroy.primeseller.util.Eco;
import ru.spigotmc.destroy.primeseller.util.Understating;
import ru.spigotmc.destroy.primeseller.util.Util;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Map;

public class SellerListener implements Listener {

    private final DecimalFormat format = new DecimalFormat("##.##");

    public SellerListener(PrimeSeller main) {
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("§7§0" + Chat.color(Menu.getConfig().getString("title")))) {
            Player player = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (e.getClickedInventory() == player.getInventory()) {
                e.setCancelled(true);
                return;
            }
            MapBase sql = new MapBase();
            ClickType clickType = e.getClick();
            player.updateInventory();
            handleSellInvSlots(e,player,sql);
            handleExitSlots(e, player);
            handleCountdownSlots(e, player);

            if (clickType == ClickType.LEFT) {
                sellAction(sql, e, player, 1);
            } else if (clickType == ClickType.RIGHT) {
                sellAction(sql, e, player, 64);
            } else if (Config.getConfig().getBoolean("middle-click-sell-all")) {
                if (clickType == ClickType.MIDDLE) {
                    sellAction(sql, e, player, Util.calc(player, sql.getSlot(e.getSlot()).getItem()));
                }
            } else {
                if (clickType == ClickType.SHIFT_LEFT) {
                    sellAction(sql, e, player, Util.calc(player, sql.getSlot(e.getSlot()).getItem()));
                }
            }
        }
    }

    private void handleExitSlots(InventoryClickEvent e, Player player) {
        for (Integer i : Menu.getConfig().getIntegerList("exit.slots")) {
            if (e.getSlot() == i) {
                for (String s : Menu.getConfig().getStringList("exit.commands")) {
                    if (s.startsWith("[cmd]")) {
                        String cmd = s.replace("[cmd]", "").replace("[cmd] ", "");
                        player.performCommand(cmd);
                    }
                    if (s.startsWith("[close]")) {
                        player.closeInventory();
                    }
                }
                e.setCancelled(true);
            }
        }
    }

    private void handleSellInvSlots(InventoryClickEvent e, Player player,MapBase sql) {
        for (Integer i : Menu.getConfig().getIntegerList("sell-inventory.slots")) {
            if (e.getSlot() == i) {
                sellAllItems(sql, e, player);
                e.setCancelled(true);
            }
        }
    }

    private void handleCountdownSlots(InventoryClickEvent e, Player player) {
        for (Integer i : Menu.getConfig().getIntegerList("countdown.slots")) {
            if (e.getSlot() == i) {
                GuiMenu.update(player, e.getClickedInventory());
                e.setCancelled(true);
            }
        }
    }

    private void sellAction(MapBase sql, InventoryClickEvent e, Player player, int count) {
        if (MapBase.database.containsKey(e.getSlot())) {
            ItemStack item = sql.getSlot(e.getSlot()).getItem().clone();
            int slot = e.getSlot();
            if (count <= 0) {
                Chat.sendMessage(player, Config.getConfig().getString("messages.amount"));
                e.setCancelled(true);
                return;
            }

            if (!player.getInventory().containsAtLeast(item, count)) {
                Chat.sendMessage(player, Config.getConfig().getString("messages.amount"));
                e.setCancelled(true);
                return;
            }

            if (sql.isLimited(slot)) {
                int selledItems = Util.playerSellItems.get(player.getUniqueId());
                int itemLimit = sql.getSlot(e.getSlot()).clone().getPlayerItemLimit(player);
                int totalLimit = Items.getConfig().getInt("limited.limit");
                int itemLimitPerItems = Items.getConfig().getInt("limited.limit-per-items");

                int availableToSell = Math.min(totalLimit - selledItems, itemLimitPerItems - itemLimit);

                if (count > availableToSell) {
                    count = availableToSell;
                }

                if (count <= 0) {
                    Chat.sendMessage(player, Config.getConfig().getString("messages.limit"));
                    e.setCancelled(true);
                    return;
                }

                Util.playerSellItems.put(player.getUniqueId(), selledItems + count);
                sql.getSlot(e.getSlot()).addItemLimit((Player) e.getWhoClicked(), count);
            }

            double price = Double.parseDouble(format.format(sql.getPrice(slot) * count).replace(",", "."));
            Understating.takePrice(slot, count);
            Chat.sendMessage(e.getWhoClicked(), Config.getConfig().getString("messages.sell")
                    .replace("%item%", item.getType().toString())
                    .replace("%price%", String.valueOf(price))
                    .replace("%amount%", "x" + count));
            item.setAmount(count);
            player.getInventory().removeItem(item);
            Eco.getEconomy().depositPlayer(player, price);
            GuiMenu.update(player, e.getClickedInventory());
            e.setCancelled(true);
        }
    }

    private void sellAllItems(MapBase sql, InventoryClickEvent e, Player player) {
        double price = 0;
        int amount = 0;

        String type = Config.getConfig().getString("inv-sell-priority", "LIMITED").toUpperCase(Locale.ENGLISH);

        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null || item.getType() == Material.AIR) {
                continue;
            }

            if (type.equals("LIMITED")) {
                Data lim = sellLimited(player,sql);
                Data unlim = sellUnLimited(player,sql);
                amount+=lim.amount+unlim.amount;
                price+=lim.price+unlim.price;
            }
            if (type.equals("UNLIMITED")) {
                Data unlim = sellUnLimited(player,sql);
                Data lim = sellLimited(player,sql);
                amount+=lim.amount+unlim.amount;
                price+=lim.price+unlim.price;
            }
        }

        Eco.getEconomy().depositPlayer(player, price);
        Chat.sendMessage(e.getWhoClicked(), Config.getConfig().getString("messages.sell-inventory")
                .replace("%price%", format.format(price).replace(",", "."))
                .replace("%amount%", "x" + amount));
    }

    private Data sellUnLimited(Player player, MapBase sql) {
        double price = 0;
        int amount = 0;
        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null || item.getType() == Material.AIR) {
                continue;
            }

            for (Map.Entry<Integer, SellItem> d : MapBase.database.entrySet()) {
                if (!d.getValue().isLimited()) {
                    ItemStack itemStack = d.getValue().getItem().clone();

                    if (item.isSimilar(itemStack)) {
                        int slot = d.getKey();
                        int count = Util.calc(player, itemStack);
                        if (count <= 0) {
                            continue;
                        }

                        amount += count;
                        price += Double.parseDouble(format.format(sql.getPrice(slot) * count).replace(",", "."));
                        itemStack.setAmount(count);
                        player.getInventory().removeItem(itemStack);
                        Understating.takePrice(slot, count);
                    }
                }
            }
        }
        return new Data(price,amount);
    }

    private Data sellLimited(Player player, MapBase sql) {
        double price = 0;
        int amount = 0;
        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null || item.getType() == Material.AIR) {
                continue;
            }

            for (Map.Entry<Integer, SellItem> d : MapBase.database.entrySet()) {
                if (d.getValue().isLimited()) {
                    ItemStack itemStack = d.getValue().getItem().clone();

                    if (item.isSimilar(itemStack)) {
                        int slot = d.getKey();
                        int count = Util.calc(player, itemStack);
                        if (count <= 0) {
                            continue;
                        }

                        int selledItems = Util.playerSellItems.get(player.getUniqueId());
                        int itemLimit = sql.getSlot(slot).clone().getPlayerItemLimit(player);
                        int totalLimit = Items.getConfig().getInt("limited.limit");
                        int itemLimitPerItems = Items.getConfig().getInt("limited.limit-per-items");

                        int availableToSell = Math.min(totalLimit - selledItems, itemLimitPerItems - itemLimit);

                        if (count > availableToSell) {
                            count = availableToSell;
                        }

                        if (count <= 0) {
                            continue;
                        }

                        Util.playerSellItems.put(player.getUniqueId(), selledItems + count);
                        sql.getSlot(slot).addItemLimit(player, count);

                        amount += count;
                        price += Double.parseDouble(format.format(sql.getPrice(slot) * count).replace(",", "."));
                        itemStack.setAmount(count);
                        player.getInventory().removeItem(itemStack);
                        Understating.takePrice(slot, count);
                    }
                }
            }
        }
        return new Data(price,amount);
    }

    public static class Data {
        double price;
        int amount;

        public Data(double price, int amount) {
            this.price = price;
            this.amount = amount;
        }
    }


}
