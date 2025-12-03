package me.byteswing.primeseller.managers;

import me.byteswing.primeseller.PrimeSeller;
import me.byteswing.primeseller.listeners.*;

public class ListenerManager implements Manager {


    @Override
    public void init(PrimeSeller plugin) {
        new PlayerJoinListener(plugin);
        new SellerListener(plugin);
        new PlayerCloseListener(plugin);
        new AutoSellListener(plugin);
    }
}
