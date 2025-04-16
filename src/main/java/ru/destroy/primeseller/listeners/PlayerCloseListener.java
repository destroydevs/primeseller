package ru.destroy.primeseller.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import ru.destroy.primeseller.PrimeSeller;
import ru.destroy.primeseller.menu.GuiMenu;

import java.util.UUID;

public class PlayerCloseListener implements Listener {

    public PlayerCloseListener(PrimeSeller main) {
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        UUID id = e.getPlayer().getUniqueId();
        if(GuiMenu.tasks.containsKey(id)) {
            GuiMenu.tasks.get(id).cancel();
            GuiMenu.tasks.remove(id);
        }
    }
}
