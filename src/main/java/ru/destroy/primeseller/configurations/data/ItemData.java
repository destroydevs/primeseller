package ru.destroy.primeseller.configurations.data;

import org.bukkit.inventory.ItemStack;
import ru.destroy.primeseller.entity.Item;

import java.util.*;

public class ItemData {

    private static final LinkedHashMap<Integer, Item> data = new LinkedHashMap<>();

    public static void saveMaterial(ItemStack item,
                                    int slot,
                                    double price,
                                    int limit,
                                    boolean limited) {
        data.put(slot, new Item(
                item,
                slot,
                price,
                limit,
                limited
        ));
    }

    public Item getSlot(int slot) {
        Item item = data.get(slot);

        if (item == null) {
            throw new NoSuchElementException("No item found in slot " + slot);
        }

        return item;
    }

    public double getPrice(int slot) {
        return getSlot(slot).getPrice();
    }

    private void updatePrice(int slot, double amount, boolean isAdd) {
        Item item = getSlot(slot);
        double newPrice = isAdd ? item.getPrice() + amount : item.getPrice() - amount;
        item.setPrice(newPrice);
    }

    public void setPrice(int slot, double p) {
        Item item = getSlot(slot);
        item.setPrice(p);
    }

    public void takePrice(int slot, double p) {
        updatePrice(slot, p, false);
    }

    public void addPrice(int slot, double p) {
        updatePrice(slot, p, true);
    }

    public void clear() {
        data.clear();
    }

    public void clearLimited() {
        data.keySet().removeIf(this::isLimited);
    }

    public void clearUnLimited() {
        data.keySet().removeIf(s -> !isLimited(s));
    }

    public boolean isLimited(int slot) {
        return getSlot(slot).isLimited();
    }

}
