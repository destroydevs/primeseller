package me.byteswing.primeseller.menu;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class SellerInventoryHolder implements InventoryHolder {
    private final Inventory inventory;

    public SellerInventoryHolder(Inventory inventory) {
        this.inventory = inventory;
    }

    @NotNull
    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public static boolean isSellerInventory(Inventory inventory) {
        return inventory.getHolder() instanceof SellerInventoryHolder;
    }
}
