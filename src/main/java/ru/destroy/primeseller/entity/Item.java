package ru.destroy.primeseller.entity;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class Item implements Cloneable {
    private static int limit;
    private final ItemStack item;
    private final int slot;
    private double price;
    private HashMap<UUID, Integer> hashItemLimit = new HashMap<>();
    private final int itemLimit;
    private final boolean isLimited;

    public Item(ItemStack item, int slot, double price, int itemLimit, boolean isLimited) {
        this.item = item;
        this.slot = slot;
        this.price = price;
        this.itemLimit = itemLimit;
        this.isLimited = isLimited;
    }

    public static int getLimit() {
        return limit;
    }

    public ItemStack getItem() {
        return item;
    }

    public int getSlot() {
        return slot;
    }

    public double getPrice() {
        return price;
    }

    public int getItemLimit() {
        return itemLimit;
    }

    public int getPlayerItemLimit(Player p) {
        hashItemLimit.putIfAbsent(p.getUniqueId(),0);
        return hashItemLimit.getOrDefault(p.getUniqueId(),0);
    }

    public boolean isLimited() {
        return isLimited;
    }

    public static void setLimit(int limit) {
        Item.limit = limit;
    }
    public void addItemLimit(Player p,int count) {
        setItemLimit(p,getPlayerItemLimit(p)+count);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setItemLimit(Player p, int itemLimit) {
        hashItemLimit.put(p.getUniqueId(),itemLimit);
    }

    @Override
    public Item clone() {
        try {
            Item clone = (Item) super.clone();
            clone.hashItemLimit = new HashMap<>();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
