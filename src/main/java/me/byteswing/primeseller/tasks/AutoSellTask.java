package me.byteswing.primeseller.tasks;

import me.byteswing.primeseller.managers.AutoSellManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoSellTask extends BukkitRunnable {

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.isOnline()) {
                AutoSellManager.processPlayerAutoSell(player);
            }
        }
    }
}
