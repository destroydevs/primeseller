package me.byteswing.primeseller.economy;

import me.byteswing.primeseller.PrimeSeller;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.text.DecimalFormat;

public class VaultEconomy implements EconomyProvider {
    private final PrimeSeller plugin;
    private final Economy economy;
    private final DecimalFormat format = new DecimalFormat("##.##");

    public VaultEconomy(PrimeSeller plugin) {
        this.plugin = plugin;
        if (plugin.getServer().getPluginManager().getPlugin("Vault") == null) {
            plugin.getLogger().warning("Vault plugin not found!");
            economy = null;
            return;
        }

        RegisteredServiceProvider<Economy> rsp = plugin.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            plugin.getLogger().warning("No economy provider found for Vault!");
            economy = null;
            return;
        }

        economy = rsp.getProvider();
        plugin.getLogger().info("Vault economy provider: " + economy.getName());
    }

    public void addBalance(Player player, double amount) {
        if (economy == null) {
            return;
        }

        try {
            economy.depositPlayer(player, amount);
        } catch (Exception e) {
            plugin.getLogger().warning("Vault addBalance error: " + e.getMessage());
        }
    }

    public String format(double amount) {
        if (economy == null) {
            return format.format(amount);
        }
        return economy.format(Double.parseDouble(format.format(amount).replace(",", ".")));
    }

    public boolean isAvailable() {
        return economy != null;
    }
}
