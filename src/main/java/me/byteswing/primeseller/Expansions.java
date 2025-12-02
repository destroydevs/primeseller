package me.byteswing.primeseller;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import me.byteswing.primeseller.util.Updater;
import me.byteswing.primeseller.util.Util;

public class Expansions extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "primeseller";
    }

    @Override
    public @NotNull String getAuthor() {
        return "destroydev, golovin12";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (params.equalsIgnoreCase("unlimited_time_formatted")) {
            return Util.unlimitedFormat;
        }
        if (params.equalsIgnoreCase("unlimited_time")) {
            return Updater.getUnLimitedTime();
        }
        if (params.equalsIgnoreCase("limited_time_formatted")) {
            return Util.limitedFormat;
        }
        if (params.equalsIgnoreCase("limited_time")) {
            return Updater.getLimitedTime();
        }
        if (params.equalsIgnoreCase("selled_items")) {
            return Util.playerSellItems.get(player.getUniqueId()).toString();
        }

        return null;
    }
}
