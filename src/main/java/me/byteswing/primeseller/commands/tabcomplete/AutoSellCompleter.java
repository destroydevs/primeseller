package me.byteswing.primeseller.commands.tabcomplete;

import me.byteswing.primeseller.PrimeSeller;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class AutoSellCompleter implements TabCompleter {

    public AutoSellCompleter(PrimeSeller main) {
        main.getCommand("autoseller").setTabCompleter(this);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("on", "off", "toggle");
        }
        return null;
    }
}
