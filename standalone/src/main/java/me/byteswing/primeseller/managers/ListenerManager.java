package me.byteswing.primeseller.managers;

import me.byteswing.primeseller.PrimeSeller;
import me.byteswing.primeseller.listeners.PlayerCloseListener;
import me.byteswing.primeseller.listeners.PlayerJoinListener;
import me.byteswing.primeseller.listeners.SellerListener;
import me.byteswing.primeseller.managers.Manager;

public class ListenerManager implements Manager {


    @Override
    public void init(PrimeSeller plugin) {
        new PlayerJoinListener(plugin);
        new SellerListener(plugin);
        new PlayerCloseListener(plugin);
    }
}
