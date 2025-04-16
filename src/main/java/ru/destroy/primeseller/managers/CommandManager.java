package ru.destroy.primeseller.managers;

import ru.destroy.primeseller.commands.OpenCommand;
import ru.destroy.primeseller.commands.PrimeSellerCommands;
import ru.destroy.primeseller.commands.tabcomplete.Completer;
import ru.destroy.primeseller.PrimeSeller;

public class CommandManager implements Manager {
    @Override
    public void init(PrimeSeller plugin) {
        new OpenCommand(plugin);
        new PrimeSellerCommands(plugin);
        new Completer(plugin);
    }
}
