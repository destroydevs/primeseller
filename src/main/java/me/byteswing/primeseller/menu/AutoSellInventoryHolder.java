package me.byteswing.primeseller.menu;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class AutoSellInventoryHolder implements InventoryHolder {
    private Inventory inventory;
    private int currentPage = 0;

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int page) {
        this.currentPage = page;
    }

    public static boolean isAutoSellInventory(Inventory inventory) {
        return inventory.getHolder() instanceof AutoSellInventoryHolder;
    }
}
