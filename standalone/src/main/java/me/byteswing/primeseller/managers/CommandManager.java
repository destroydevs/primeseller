package me.byteswing.primeseller.managers;

import me.byteswing.primeseller.PrimeSeller;
import me.byteswing.primeseller.commands.OpenCommand;
import me.byteswing.primeseller.commands.PrimeSellerCommands;
import me.byteswing.primeseller.commands.tabcomplete.Completer;
import me.byteswing.primeseller.managers.Manager;

public class CommandManager implements Manager {
    @Override
    public void init(PrimeSeller plugin) {
        new OpenCommand(plugin);
        new PrimeSellerCommands(plugin);
        new Completer(plugin);
    }
}
