package ru.spigotmc.destroy.primeseller.managers;

import ru.spigotmc.destroy.primeseller.PrimeSeller;
import ru.spigotmc.destroy.primeseller.commands.OpenCommand;
import ru.spigotmc.destroy.primeseller.commands.PrimeSellerCommands;
import ru.spigotmc.destroy.primeseller.commands.tabcomplete.Completer;

public class CommandManager implements Manager {
    @Override
    public void init(PrimeSeller plugin) {
        new OpenCommand(plugin);
        new PrimeSellerCommands(plugin);
        new Completer(plugin);
    }
}
