package ru.spigotmc.destroy.primeseller.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import ru.spigotmc.destroy.primeseller.PrimeSeller;
import ru.spigotmc.destroy.primeseller.configurations.Menu;

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
