package me.byteswing.primeseller.commands;

import me.byteswing.primeseller.managers.AutoSellManager;
import me.byteswing.primeseller.menu.AutoSellMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.byteswing.primeseller.PrimeSeller;
import me.byteswing.primeseller.configurations.Config;
import me.byteswing.primeseller.util.Chat;

public class AutoSellerCommand implements CommandExecutor {
    private final PrimeSeller plugin;

    public AutoSellerCommand(PrimeSeller main) {
        this.plugin = main;
        main.getCommand("autoseller").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            Chat.sendMessage(sender, Config.getMessage("commands.player-only"));
            return true;
        }

        if (!player.hasPermission("primeseller.autoseller")) {
            Chat.sendMessage(sender, Config.getMessage("commands.permission"));
            return true;
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("on")) {
                AutoSellManager.setAutoSellEnabled(player, true);
                Chat.sendMessage(player, Config.getMessage("autosell.enabled"));
                return true;
            } else if (args[0].equalsIgnoreCase("off")) {
                AutoSellManager.setAutoSellEnabled(player, false);
                Chat.sendMessage(player, Config.getMessage("autosell.disabled"));
                return true;
            } else if (args[0].equalsIgnoreCase("toggle")) {
                AutoSellManager.toggleAutoSell(player);
                boolean enabled = AutoSellManager.isAutoSellEnabled(player);
                Chat.sendMessage(player, enabled ?
                        Config.getMessage("autosell.enabled") :
                        Config.getMessage("autosell.disabled"));
                return true;
            }
        }
        AutoSellMenu.openAutoSellMenu(player, plugin);
        return true;
    }
}
