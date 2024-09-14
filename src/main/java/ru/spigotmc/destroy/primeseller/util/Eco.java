package ru.spigotmc.destroy.primeseller.util;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Eco {
    private static Economy economy;

    public Eco() {
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static void init() {
        RegisteredServiceProvider<Economy> reg = Bukkit.getServicesManager().getRegistration(Economy.class);
        if (reg != null) {
            economy = reg.getProvider();
        }

    }
}
