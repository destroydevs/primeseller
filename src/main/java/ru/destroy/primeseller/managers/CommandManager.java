package ru.destroy.primeseller.managers;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import ru.destroy.primeseller.PrimeSeller;
import ru.destroy.primeseller.util.reflection.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

public class CommandManager implements Manager {
    @Override
    public void init(PrimeSeller plugin) {
        ReflectionUtil.registerAnnotation(
                "commands.impl",
                TabCompleter.class,
                completer -> {
                    try {

                        plugin.getCommand("seller").setTabCompleter(completer
                                .getDeclaredConstructor()
                                .newInstance());

                    } catch (IllegalAccessException |
                             InstantiationException |
                             InvocationTargetException |
                             NoSuchMethodException e) {

                        Bukkit.getLogger().severe("Failed to register tab completers.");
                        e.printStackTrace();

                    }
                });
        ReflectionUtil.registerAnnotation(
                "commands.impl",
                CommandExecutor.class,
                executor -> {
                    try {

                        plugin.getCommand("seller").setExecutor(executor
                                .getDeclaredConstructor()
                                .newInstance());

                    } catch (IllegalAccessException |
                             InstantiationException |
                             InvocationTargetException |
                             NoSuchMethodException e) {

                        Bukkit.getLogger().severe("Failed to register commands.");
                        e.printStackTrace();

                    }
                });
    }
}
