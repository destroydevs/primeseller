package ru.spigotmc.destroy.primeseller;

import com.github.Anon8281.universalScheduler.UniversalScheduler;
import com.github.Anon8281.universalScheduler.scheduling.schedulers.TaskScheduler;
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

    private static TaskScheduler scheduler;

    public static TaskScheduler getScheduler() {
        return scheduler;
    }

    @Override
    public void onEnable() {
        JavaChecker.checkJavaVersion(()->{
            scheduler = UniversalScheduler.getScheduler(this);
            ConfigManager.loadConfigurations(this);
            Eco.init();
            loadManager(new ListenerManager(), this);
            loadManager(new CommandManager(), this);
            Updater.startCountdown();
            Updater.start();
            msg("&a██████╗░██████╗░██╗███╗░░░███╗███████╗░██████╗███████╗██╗░░░░░██╗░░░░░███████╗██████╗░");
            msg("&a██╔══██╗██╔══██╗██║████╗░████║██╔════╝██╔════╝██╔════╝██║░░░░░██║░░░░░██╔════╝██╔══██╗");
            msg("&a██████╔╝██████╔╝██║██╔████╔██║█████╗░░╚█████╗░█████╗░░██║░░░░░██║░░░░░█████╗░░██████╔╝");
            msg("&a██╔═══╝░██╔══██╗██║██║╚██╔╝██║██╔══╝░░░╚═══██╗██╔══╝░░██║░░░░░██║░░░░░██╔══╝░░██╔══██╗");
            msg("&a██║░░░░░██║░░██║██║██║░╚═╝░██║███████╗██████╔╝███████╗███████╗███████╗███████╗██║░░██║");
            msg("&a╚═╝░░░░░╚═╝░░╚═╝╚═╝╚═╝░░░░░╚═╝╚══════╝╚═════╝░╚══════╝╚══════╝╚══════╝╚══════╝╚═╝░░╚═╝");
            msg("&e▀█░█▀ █▀▀ █▀▀█ █▀▀ ░▀░ █▀▀█ █▀▀▄ &bv"+getDescription().getVersion());
            msg("&e░█▄█░ █▀▀ █▄▄▀ ▀▀█ ▀█▀ █░░█ █░░█ &7| &fDeveloper: &dTelegram: &b@byteswing");
            msg("&e░░▀░░ ▀▀▀ ▀░▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀░░▀ &7| &fServer version: &7(&e"+ ServerVersionUtil.getServerVersion().getMajor()+"."+ServerVersionUtil.getServerVersion().getMinor()+"."+ServerVersionUtil.getServerVersion().getPatch()+"&7)");
            UpdateChecker.start(this);
            if(Config.getConfig().getBoolean("metrics")) {
                new Metrics(this,17800);
            }
            if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
                new Expansions().register();
            }
        }, ()->{
            msg(" ");
            msg("&c[PrimeSeller] Ваша версия Java не поддерживается.");
            msg("&c[PrimeSeller] Используйте версию 11+.");
            msg("&c[PrimeSeller] Плагин был отключен.");
            msg(" ");
            msg("&c[PrimeSeller] Your Java version is not supported.");
            msg("&c[PrimeSeller] Please use version 11+.");
            msg("&c[PrimeSeller] The plugin has been disabled.");
            msg(" ");
            this.setEnabled(false);
        });
    }

    @Override
    public void onDisable() {
        msg("&c██████╗░██████╗░██╗███╗░░░███╗███████╗░██████╗███████╗██╗░░░░░██╗░░░░░███████╗██████╗░");
        msg("&c██╔══██╗██╔══██╗██║████╗░████║██╔════╝██╔════╝██╔════╝██║░░░░░██║░░░░░██╔════╝██╔══██╗");
        msg("&c██████╔╝██████╔╝██║██╔████╔██║█████╗░░╚█████╗░█████╗░░██║░░░░░██║░░░░░█████╗░░██████╔╝");
        msg("&c██╔═══╝░██╔══██╗██║██║╚██╔╝██║██╔══╝░░░╚═══██╗██╔══╝░░██║░░░░░██║░░░░░██╔══╝░░██╔══██╗");
        msg("&c██║░░░░░██║░░██║██║██║░╚═╝░██║███████╗██████╔╝███████╗███████╗███████╗███████╗██║░░██║");
        msg("&c╚═╝░░░░░╚═╝░░╚═╝╚═╝╚═╝░░░░░╚═╝╚══════╝╚═════╝░╚══════╝╚══════╝╚══════╝╚══════╝╚═╝░░╚═╝");
        msg("&e▀█░█▀ █▀▀ █▀▀█ █▀▀ ░▀░ █▀▀█ █▀▀▄ &bv"+getDescription().getVersion());
        msg("&e░█▄█░ █▀▀ █▄▄▀ ▀▀█ ▀█▀ █░░█ █░░█ &7| &fDeveloper: &dTelegram: &b@byteswing");
        msg("&e░░▀░░ ▀▀▀ ▀░▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀░░▀ &7| &fServer version: &7(&e"+ ServerVersionUtil.getServerVersion().getMajor()+"."+ServerVersionUtil.getServerVersion().getMinor()+"."+ServerVersionUtil.getServerVersion().getPatch()+"&7)");
        MapBase sql = new MapBase();
        sql.clear();
    }

    private void loadManager(Manager manager, PrimeSeller plugin) {
        manager.init(plugin);
    }

}
