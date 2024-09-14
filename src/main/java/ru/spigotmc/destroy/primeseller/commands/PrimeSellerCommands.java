package ru.spigotmc.destroy.primeseller.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.spigotmc.destroy.primeseller.configurations.Config;
import ru.spigotmc.destroy.primeseller.managers.ConfigManager;
import ru.spigotmc.destroy.primeseller.configurations.Items;
import ru.spigotmc.destroy.primeseller.PrimeSeller;
import ru.spigotmc.destroy.primeseller.util.Chat;
import ru.spigotmc.destroy.primeseller.util.Updater;

public class PrimeSellerCommands implements CommandExecutor {

    public PrimeSellerCommands(PrimeSeller main) {
        main.getCommand("PrimeSeller").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("primeseller.admin")) {
            Chat.sendMessage(sender, Config.getConfig().getString("messages.commands.permission"));
            return true;
        }
        if(args.length < 1) {
            Chat.sendMessage(sender, Config.getConfig().getString("messages.commands.update-use"));
            return true;
        }
        if(args[0].equalsIgnoreCase("update")) {
            Updater.update();
            Chat.sendMessage(sender, Config.getConfig().getString("messages.commands.update"));
            return true;
        } else if(args[0].equalsIgnoreCase("reload")) {
            ConfigManager.reloadConfigurations();
            Chat.sendMessage(sender, Config.getConfig().getString("messages.commands.reload"));
            return true;
        }
        if(!(sender instanceof Player)) {
            sender.sendMessage("Только для игроков!");
            return true;
        }
        Player p = (Player) sender;
        if (args.length < 3) {
            Chat.sendMessage(p, Config.getConfig().getString("messages.commands.addlimited-use"));
            Chat.sendMessage(p, Config.getConfig().getString("messages.commands.addunlimited-use"));
            return true;
        }
        if(args[0].equalsIgnoreCase("addlimited")) {
            if(p.getInventory().getItemInMainHand().getType() == Material.AIR) {
                Chat.sendMessage(p, "&fНельзя добавить &cничего&f в список скупаемых предметов.");
                return true;
            }
            double min;
            double max;
            try {
                min = Double.parseDouble(args[1]);
                max = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {
                Chat.sendMessage(p, "&cВведите правильное число.");
                return true;
            }
            Items.addItem(p.getInventory().getItemInMainHand(), min, max, true);
            Chat.sendMessage(p, Config.getConfig().getString("messages.commands.added")
                    .replace("%item%", p.getInventory().getItemInMainHand().getType().toString())
                    .replace("%min-price%", String.valueOf(min).replace(".", ","))
                    .replace("%max-price%", String.valueOf(max).replace(".", ",")));
        } else if(args[0].equalsIgnoreCase("addunlimited")) {
            if(p.getInventory().getItemInMainHand().getType() == Material.AIR) {
                Chat.sendMessage(p, "&fНельзя добавить &cничего&f в список скупаемых предметов.");
                return true;
            }
            double min;
            double max;
            try {
                min = Double.parseDouble(args[1]);
                max = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {
                Chat.sendMessage(p, "&cВведите правильное число.");
                return true;
            }
            Items.addItem(p.getInventory().getItemInMainHand(), min, max, false);
            Chat.sendMessage(p, Config.getConfig().getString("messages.commands.added")
                    .replace("%item%", p.getInventory().getItemInMainHand().getType().toString())
                    .replace("%min-price%", String.valueOf(min).replace(".", ","))
                    .replace("%max-price%", String.valueOf(max).replace(".", ",")));
        } else {
            Chat.sendMessage(p, Config.getConfig().getString("messages.commands.addunlimited-use"));
        }
        return true;
    }
}
