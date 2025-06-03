package ru.destroy.primeseller.managers;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import ru.destroy.primeseller.PrimeSeller;
import ru.destroy.primeseller.listeners.PlayerCloseListener;
import ru.destroy.primeseller.listeners.PlayerJoinListener;
import ru.destroy.primeseller.listeners.SellerListener;
import ru.destroy.primeseller.util.reflection.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

public class ListenerManager implements Manager {


    @Override
    public void init(PrimeSeller plugin) {
        ReflectionUtil.registerAnnotation(
                "listeners",
                Listener.class,
                listener -> {

                    try {
                        Bukkit.getPluginManager()
                                .registerEvents(

                                        listener.getDeclaredConstructor()
                                                .newInstance(),

                                        plugin

                                );
                    } catch (IllegalAccessException |
                             InstantiationException |
                             InvocationTargetException |
                             NoSuchMethodException e) {

                        Bukkit.getLogger().severe("Failed to register listeners.");
                        e.printStackTrace();

                    }

                });
    }
}
