package ru.destroy.primeseller.managers;

import ru.destroy.primeseller.commands.impl.OpenCommand;
import ru.destroy.primeseller.commands.impl.MainCommand;
import ru.destroy.primeseller.commands.impl.Completer;
import ru.destroy.primeseller.PrimeSeller;

public class CommandManager implements Manager {
    @Override
    public void init(PrimeSeller plugin) {
        new OpenCommand(plugin);
        new MainCommand(plugin);
        new Completer(plugin);
    }
}
