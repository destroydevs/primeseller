package ru.destroy.primeseller.managers;

import ru.destroy.primeseller.PrimeSeller;
import ru.destroy.primeseller.listeners.PlayerCloseListener;
import ru.destroy.primeseller.listeners.PlayerJoinListener;
import ru.destroy.primeseller.listeners.SellerListener;

public class ListenerManager implements Manager {


    @Override
    public void init(PrimeSeller plugin) {
        new PlayerJoinListener(plugin);
        new SellerListener(plugin);
        new PlayerCloseListener(plugin);
    }
}
