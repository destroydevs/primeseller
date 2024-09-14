package ru.spigotmc.destroy.primeseller.managers;

import org.bukkit.plugin.java.JavaPlugin;
import ru.spigotmc.destroy.primeseller.PrimeSeller;
import ru.spigotmc.destroy.primeseller.listeners.PlayerCloseListener;
import ru.spigotmc.destroy.primeseller.listeners.PlayerJoinListener;
import ru.spigotmc.destroy.primeseller.listeners.SellerListener;

public class ListenerManager implements Manager {


    @Override
    public void init(PrimeSeller plugin) {
        new PlayerJoinListener(plugin);
        new SellerListener(plugin);
        new PlayerCloseListener(plugin);
    }
}
