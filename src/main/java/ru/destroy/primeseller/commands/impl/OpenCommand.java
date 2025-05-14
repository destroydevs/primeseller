package ru.destroy.primeseller.commands.impl;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.destroy.primeseller.PrimeSeller;
import ru.destroy.primeseller.commands.CommandRegistry;
import ru.destroy.primeseller.configurations.Config;
import ru.destroy.primeseller.menu.GuiMenu;
import ru.destroy.primeseller.util.Chat;

@CommandRegistry(command = "seller")
public class OpenCommand implements CommandExecutor {

    PrimeSeller main;
    public OpenCommand(PrimeSeller main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(Config.getConfig().getBoolean("enable-permission")) {
                if(!p.hasPermission("primeseller.open")) {
                    Chat.sendMessage(sender, Config.getConfig().getString("messages.commands.permission"));
                    return true;
                }
            }
            GuiMenu.open(p);
            p.playSound(p.getLocation(), Sound.UI_TOAST_IN, 1,1);
        }
        return true;
    }
}
