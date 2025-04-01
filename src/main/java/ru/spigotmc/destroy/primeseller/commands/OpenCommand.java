package ru.spigotmc.destroy.primeseller.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.spigotmc.destroy.primeseller.PrimeSeller;
import ru.spigotmc.destroy.primeseller.configurations.Config;
import ru.spigotmc.destroy.primeseller.menu.GuiMenu;
import ru.spigotmc.destroy.primeseller.util.Chat;

public class OpenCommand implements CommandExecutor {

    PrimeSeller main;
    public OpenCommand(PrimeSeller main) {
        main.getCommand("seller").setExecutor(this);
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
