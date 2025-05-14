package ru.destroy.primeseller.commands.impl;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import ru.destroy.primeseller.commands.CommandRegistry;
import ru.destroy.primeseller.commands.CommandType;

import java.util.Arrays;
import java.util.List;

@CommandRegistry(command = "primeseller",
        commandType = CommandType.TAB_COMPLETE)
public class Completer implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        switch (args.length) {
            case 1 -> {
                if (isAddCommand(args)) return Arrays.asList(
                        "update",
                        "reload",
                        "addlimited",
                        "addunlimited"
                );
            }
            case 2 -> {
                if (isAddCommand(args)) return Arrays.asList(
                        "10",
                        "50",
                        "100"
                );
            }
            case 3 -> {
                if (isAddCommand(args)) return Arrays.asList(
                        "100",
                        "500",
                        "1000"
                );
            }
            default -> {
                return List.of("");
            }
        }
        return null;
    }

    private boolean isAddCommand(String... args) {
        return args[0].equalsIgnoreCase("addlimited")
                || args[0].equalsIgnoreCase("addunlimited");
    }
}
