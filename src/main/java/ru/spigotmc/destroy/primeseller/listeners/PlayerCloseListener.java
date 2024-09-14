package ru.spigotmc.destroy.primeseller.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import ru.spigotmc.destroy.primeseller.PrimeSeller;
import ru.spigotmc.destroy.primeseller.menu.GuiMenu;

import java.util.UUID;

public class PlayerCloseListener implements Listener {

    public PlayerCloseListener(PrimeSeller main) {
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        UUID id = e.getPlayer().getUniqueId();
        if(GuiMenu.tasks.containsKey(id)) {
            Bukkit.getScheduler().cancelTask(GuiMenu.tasks.get(id));
            GuiMenu.tasks.remove(id);
        }
    }
}
