package me.byteswing.primeseller.economy;

import me.byteswing.primeseller.PrimeSeller;
import org.bukkit.entity.Player;
import su.nightexpress.coinsengine.api.CoinsEngineAPI;
import su.nightexpress.coinsengine.api.currency.Currency;

import java.text.DecimalFormat;

public class CoinsEngineEconomy implements EconomyProvider {
    private final PrimeSeller plugin;
    private Currency currency;
    private final DecimalFormat format = new DecimalFormat("##.##");

    public CoinsEngineEconomy(PrimeSeller plugin) {
        this.plugin = plugin;
        String currencyName = plugin.getConfig().getString("economy.coins-engine.currency", "money");
        if (plugin.getServer().getPluginManager().getPlugin("CoinsEngine") != null) {
            currency = CoinsEngineAPI.getCurrency(currencyName);
        }
        if (currency == null) {
            plugin.getLogger().warning("Currency '" + currencyName + "' not found in CoinsEngine!");
        } else {
            plugin.getLogger().info("CoinsEngineEconomy use '" + currencyName + "' currency!");
        }
    }

    public void addBalance(Player player, double amount) {
        if (currency == null) {
            return;
        }

        try {
            CoinsEngineAPI.addBalance(player, currency, amount);
        } catch (Exception e) {
            plugin.getLogger().warning("AddBalance error: " + e.getMessage());
        }
    }

    public String format(double amount) {
        if (currency == null) {
            return format.format(amount);
        }
        return currency.format(Double.parseDouble(format.format(amount).replace(",", ".")));
    }

    public boolean isAvailable() {
        return currency != null;
    }
}
