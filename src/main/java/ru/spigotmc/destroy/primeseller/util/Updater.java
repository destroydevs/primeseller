package ru.spigotmc.destroy.primeseller.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import ru.spigotmc.destroy.primeseller.configurations.Config;
import ru.spigotmc.destroy.primeseller.configurations.database.MapBase;
import ru.spigotmc.destroy.primeseller.configurations.Items;
import ru.spigotmc.destroy.primeseller.menu.SellerMenu;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Updater {
    private static final HashMap<String, Integer> counter = new HashMap<>();

    private static final ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

    public static void startCountdown() {
        if(counter.get("limited") == null || counter.get("unlimited") == null) {
            counter.put("unlimited", Items.getConfig().getInt("unlimited.update"));
            counter.put("limited", Items.getConfig().getInt("limited.update"));
        }
        timer.scheduleAtFixedRate(() -> {
            int lim = counter.get("limited");
            int unlim = counter.get("unlimited");
            if (lim > 1) {
                counter.put("limited", lim - 1);
            }
            if (unlim > 1) {
                counter.put("unlimited", unlim - 1);
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public static String getLimitedTime(int type) {
        if (type == 1) {
            return counter.get("limited") + "сек.";
        } else {
            if (type == 2) {
                int seconds = counter.get("limited");
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int remainingSeconds = seconds % 60;

                return Config.getConfig().getString("time-format")
                        .replace("hh", String.valueOf(hours))
                        .replace("mm", String.valueOf(minutes))
                        .replace("ss", String.valueOf(remainingSeconds));
            }
        }
        return "0";
    }

    public static int getLimitedTime() {
        return counter.get("limited");
    }
    public static int getUnLimitedTime() {
        return counter.get("unlimited");
    }

    public static String getUnLimitedTime(int type) {
        if (type == 1) {
            return counter.get("unlimited") + "сек.";
        } else {
            if (type == 2) {
                int seconds = counter.get("unlimited");
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int remainingSeconds = seconds % 60;

                return Config.getConfig().getString("time-format")
                        .replace("hh", String.valueOf(hours))
                        .replace("mm", String.valueOf(minutes))
                        .replace("ss", String.valueOf(remainingSeconds));
            }
        }
        return "0";
    }

    public static void update() {
        MapBase sql = new MapBase();
        sql.clear();
        for (String s : Config.getConfig().getStringList("messages.update-cast")) {
            Chat.broadcast(s);
        }

        Util.update = true;
        Util.playerSellItems.clear();

        counter.put("unlimited", Items.getConfig().getInt("unlimited.update"));
        counter.put("limited", Items.getConfig().getInt("limited.update"));
        for(Player p: Bukkit.getOnlinePlayers()) {
            Util.playerSellItems.put(p.getUniqueId(), 0);
        }
        Util.unlimitedFormat = Util.formattedTime(Items.getConfig().getInt("unlimited.update"));
        Util.limitedFormat = Util.formattedTime(Items.getConfig().getInt("limited.update"));
        SellerMenu.createUnLimItems();
        SellerMenu.createLimItems();
    }

    private static void clearAndCreateLimited() {
        try {
            counter.put("limited", Items.getConfig().getInt("limited.update"));
            Util.update = true;
            Util.playerSellItems.clear();
            for (Player p : Bukkit.getOnlinePlayers()) {
                Util.playerSellItems.put(p.getUniqueId(), 0);
            }
            MapBase sql = new MapBase();
            sql.clearLimited();
            Util.limitedFormat = Util.formattedTime(Items.getConfig().getInt("limited.update"));
            SellerMenu.createLimItems();
            for (String s : Config.getConfig().getStringList("messages.limited-update-cast")) {
                Chat.broadcast(s);
            }
        } catch (Exception e) {
            clearAndCreateLimited();
            return;
        }
    }

    private static void clearAndCreateUnLimited() {
        try {
            counter.put("unlimited", Items.getConfig().getInt("unlimited.update"));
            Util.update = true;
            MapBase sql = new MapBase();
            sql.clearUnLimited();
            Util.unlimitedFormat = Util.formattedTime(Items.getConfig().getInt("unlimited.update"));
            SellerMenu.createUnLimItems();
            for (String s : Config.getConfig().getStringList("messages.unlimited-update-cast")) {
                Chat.broadcast(s);
            }
        } catch (Exception e) {
            clearAndCreateLimited();
            return;
        }
    }




    public static void startUnLim(Plugin plugin) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Updater.clearAndCreateUnLimited();
            }
        }.runTaskTimer(plugin, 0,Items.getConfig().getInt("unlimited.update")*20L);
    }

    public static void startLim(Plugin plugin) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Updater.clearAndCreateLimited();
            }
        }.runTaskTimer(plugin, 0,Items.getConfig().getInt("limited.update")*20L);
    }

    public static void start(Plugin plugin) {
        if(Items.getConfig().getBoolean("unlimited.enable",true)) {
            startUnLim(plugin);
        }
        if(Items.getConfig().getBoolean("limited.enable",true)) {
            startLim(plugin);
        }
        Util.update = true;
    }
}
