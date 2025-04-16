package ru.destroy.primeseller.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import ru.destroy.primeseller.PrimeSeller;
import ru.destroy.primeseller.configurations.Menu;

public class PlayerOpenListener implements Listener {
    public PlayerOpenListener(PrimeSeller main) {
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onOpen(InventoryOpenEvent e) {
        if(e.getView().getTitle().equals("§7§0"+ Menu.getConfig().getString("title"))) {
            //
        }
    }
}
