package me.byteswing.primeseller.tasks;

import me.byteswing.primeseller.PrimeSeller;
import me.byteswing.primeseller.util.Updater;
import org.bukkit.scheduler.BukkitRunnable;

public class UpdaterTask extends BukkitRunnable {
    private final PrimeSeller plugin;
    private final boolean isLimited;

    public UpdaterTask(PrimeSeller plugin, boolean isLimited) {
        this.plugin = plugin;
        this.isLimited = isLimited;
    }

    @Override
    public void run() {
        if (isLimited) {
            Updater.clearAndCreateLimited(plugin, false);
        } else {
            Updater.clearAndCreateUnLimited(plugin, false);
        }
    }
}
