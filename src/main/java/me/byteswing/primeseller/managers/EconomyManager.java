package me.byteswing.primeseller.managers;

import me.byteswing.primeseller.economy.CoinsEngineEconomy;
import me.byteswing.primeseller.economy.EconomyProvider;
import me.byteswing.primeseller.economy.VaultEconomy;
import me.byteswing.primeseller.PrimeSeller;
import org.bukkit.entity.Player;

public class EconomyManager {
    private static PrimeSeller plugin;
    private static EconomyProvider currentEconomy;

    public static void init(PrimeSeller plugin) {
        EconomyManager.plugin = plugin;
        reload();
    }

    public static void reload() {
        boolean isCoinsEngine = plugin.getConfig().getBoolean("economy.coins-engine.enable", false);

        if (isCoinsEngine) {
            currentEconomy = new CoinsEngineEconomy(plugin);
        } else {
            currentEconomy = new VaultEconomy(plugin);
        }
    }

    public static void addBalance(Player player, double amount) {
        if (currentEconomy != null && currentEconomy.isAvailable()) {
            currentEconomy.addBalance(player, amount);
        } else {
            plugin.getLogger().warning("No available economy provider to add balance!");
        }
    }

    public static String format(double amount) {
        if (currentEconomy != null && currentEconomy.isAvailable()) {
            return currentEconomy.format(amount);
        }
        return String.valueOf(amount);
    }

    public static boolean isEconomyAvailable() {
        return currentEconomy != null && currentEconomy.isAvailable();
    }
}
