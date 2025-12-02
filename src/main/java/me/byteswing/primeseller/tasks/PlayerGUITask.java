package me.byteswing.primeseller.tasks;

import me.byteswing.primeseller.PrimeSeller;
import me.byteswing.primeseller.util.Util;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerGUITask extends BukkitRunnable {
    private final PrimeSeller plugin;
    private final Player player;
    private final Inventory inv;

    public PlayerGUITask(PrimeSeller plugin, Inventory inv, Player player) {
        this.plugin = plugin;
        this.player = player;
        this.inv = inv;
    }

    @Override
    public void run() {
        if (Util.update) {
            try {
                Util.fillInventory(inv, player, plugin);
            } catch (NullPointerException e) {
                return;
            }
            Util.update = false;
        }
    }
}
