package ru.destroy.primeseller;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import ru.destroy.primeseller.util.Util;
import ru.destroy.primeseller.util.Updater;

public class Expansions extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "primeseller";
    }

    @Override
    public @NotNull String getAuthor() {
        return "destroydev";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }
    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if(params.equalsIgnoreCase("unlimited_time_formatted")) {
            return Util.unlimitedFormat;
        }
        if(params.equalsIgnoreCase("unlimited_time")) {
            return Updater.getUnLimitedTime(2);
        }
        if(params.equalsIgnoreCase("limited_time_formatted")) {
            return Util.limitedFormat;
        }
        if(params.equalsIgnoreCase("limited_time")) {
            return Updater.getLimitedTime(2);
        }
        if(params.equalsIgnoreCase("selled_items")) {
            return Util.playerSellItems.get(player.getUniqueId()).toString();
        }

        return null; // Placeholder is unknown by the Expansion
    }
}
