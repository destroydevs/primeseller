package ru.spigotmc.destroy.primeseller.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.spigotmc.destroy.primeseller.PrimeSeller;
import ru.spigotmc.destroy.primeseller.util.Util;

public class PlayerJoinListener implements Listener {

    public PlayerJoinListener(PrimeSeller main) {
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(!Util.playerSellItems.containsKey(p.getUniqueId())) {
            Util.playerSellItems.put(p.getUniqueId(), 0);
        }
    }

}
