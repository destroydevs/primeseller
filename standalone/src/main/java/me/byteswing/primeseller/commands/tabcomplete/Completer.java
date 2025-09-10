package me.byteswing.primeseller.commands.tabcomplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import me.byteswing.primeseller.PrimeSeller;

import java.util.Arrays;
import java.util.List;

public class Completer implements TabCompleter {

    public Completer(PrimeSeller main) {
        main.getCommand("PrimeSeller").setTabCompleter(this);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1) {
            return Arrays.asList("update", "reload", "addlimited", "addunlimited");
        }
        if(args.length == 2 && args[0].equalsIgnoreCase("addlimited") || args[0].equalsIgnoreCase("addunlimited")) {
            return Arrays.asList("10", "50", "100");
        }
        if(args.length == 3 && args[0].equalsIgnoreCase("addlimited") || args[0].equalsIgnoreCase("addunlimited")) {
            return Arrays.asList("100", "500", "1000");
        }
        return null;
    }
}
