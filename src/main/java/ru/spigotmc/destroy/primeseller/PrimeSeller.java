package ru.spigotmc.destroy.primeseller;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.spigotmc.destroy.primeseller.configurations.Config;
import ru.spigotmc.destroy.primeseller.configurations.database.MapBase;
import ru.spigotmc.destroy.primeseller.managers.CommandManager;
import ru.spigotmc.destroy.primeseller.managers.ConfigManager;
import ru.spigotmc.destroy.primeseller.managers.ListenerManager;
import ru.spigotmc.destroy.primeseller.managers.Manager;
import ru.spigotmc.destroy.primeseller.util.Chat;
import ru.spigotmc.destroy.primeseller.util.Eco;
import ru.spigotmc.destroy.primeseller.util.ServerVersionUtil;
import ru.spigotmc.destroy.primeseller.util.Updater;

public final class PrimeSeller extends JavaPlugin {


    private void msg(String msg) {
        String prefix = Chat.color("&bPrimeSeller &e| &f");
        Bukkit.getConsoleSender().sendMessage(prefix+ Chat.color(msg));
    }

    @Override
    public void onEnable() {
        ConfigManager.loadConfigurations(this);
        Eco.init();
        loadManager(new ListenerManager(), this);
        loadManager(new CommandManager(), this);
        Updater.startCountdown();
        Updater.start(this);
        msg("&a██████╗░██████╗░██╗███╗░░░███╗███████╗░██████╗███████╗██╗░░░░░██╗░░░░░███████╗██████╗░");
        msg("&a██╔══██╗██╔══██╗██║████╗░████║██╔════╝██╔════╝██╔════╝██║░░░░░██║░░░░░██╔════╝██╔══██╗");
        msg("&a██████╔╝██████╔╝██║██╔████╔██║█████╗░░╚█████╗░█████╗░░██║░░░░░██║░░░░░█████╗░░██████╔╝");
        msg("&a██╔═══╝░██╔══██╗██║██║╚██╔╝██║██╔══╝░░░╚═══██╗██╔══╝░░██║░░░░░██║░░░░░██╔══╝░░██╔══██╗");
        msg("&a██║░░░░░██║░░██║██║██║░╚═╝░██║███████╗██████╔╝███████╗███████╗███████╗███████╗██║░░██║");
        msg("&a╚═╝░░░░░╚═╝░░╚═╝╚═╝╚═╝░░░░░╚═╝╚══════╝╚═════╝░╚══════╝╚══════╝╚══════╝╚══════╝╚═╝░░╚═╝");
        msg("&e▀█░█▀ █▀▀ █▀▀█ █▀▀ ░▀░ █▀▀█ █▀▀▄ ");
        msg("&e░█▄█░ █▀▀ █▄▄▀ ▀▀█ ▀█▀ █░░█ █░░█ &bv"+getDescription().getVersion()+" &7| &fDeveloper: &dTelegram: &b@byteswing &7| &dServer: "+ ServerVersionUtil.getServerVersion().getMajor()+"."+ServerVersionUtil.getServerVersion().getMinor()+"."+ServerVersionUtil.getServerVersion().getPatch());
        msg("&e░░▀░░ ▀▀▀ ▀░▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀░░▀ ");
        if(Config.getConfig().getBoolean("metrics")) {
            new Metrics(this,17800);
        }
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new Expansions().register();
        }
    }

    @Override
    public void onDisable() {
        msg("&c██████╗░██████╗░██╗███╗░░░███╗███████╗░██████╗███████╗██╗░░░░░██╗░░░░░███████╗██████╗░");
        msg("&c██╔══██╗██╔══██╗██║████╗░████║██╔════╝██╔════╝██╔════╝██║░░░░░██║░░░░░██╔════╝██╔══██╗");
        msg("&c██████╔╝██████╔╝██║██╔████╔██║█████╗░░╚█████╗░█████╗░░██║░░░░░██║░░░░░█████╗░░██████╔╝");
        msg("&c██╔═══╝░██╔══██╗██║██║╚██╔╝██║██╔══╝░░░╚═══██╗██╔══╝░░██║░░░░░██║░░░░░██╔══╝░░██╔══██╗");
        msg("&c██║░░░░░██║░░██║██║██║░╚═╝░██║███████╗██████╔╝███████╗███████╗███████╗███████╗██║░░██║");
        msg("&c╚═╝░░░░░╚═╝░░╚═╝╚═╝╚═╝░░░░░╚═╝╚══════╝╚═════╝░╚══════╝╚══════╝╚══════╝╚══════╝╚═╝░░╚═╝");
        msg("&e▀█░█▀ █▀▀ █▀▀█ █▀▀ ░▀░ █▀▀█ █▀▀▄ ");
        msg("&e░█▄█░ █▀▀ █▄▄▀ ▀▀█ ▀█▀ █░░█ █░░█ &bv"+getDescription().getVersion()+" &7| &fDeveloper: &dTelegram: &b@byteswing &7| &dServer: "+ ServerVersionUtil.getServerVersion().getMajor()+"."+ServerVersionUtil.getServerVersion().getMinor()+"."+ServerVersionUtil.getServerVersion().getPatch());
        msg("&e░░▀░░ ▀▀▀ ▀░▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀░░▀ ");
        MapBase sql = new MapBase();
        sql.clear();
    }

    private void loadManager(Manager manager, PrimeSeller plugin) {
        manager.init(plugin);
    }

}
