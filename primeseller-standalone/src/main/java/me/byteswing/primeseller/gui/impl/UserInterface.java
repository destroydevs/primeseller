package me.byteswing.primeseller.gui.impl;

import me.byteswing.primeseller.bukkit.entity.impl.PlayerEntity;
import me.byteswing.primeseller.gui.IUserInterface;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class UserInterface implements IUserInterface {
    //private final PlayerEntity playerEntity;
    private final Player player;
    // todo: schedulers
    private Inventory inventory;

    public UserInterface(Player player) {
        // todo: get from factory
        // this.playerEntity = new PlayerEntity(player.getUniqueId());
        this.player = player;
        // todo: cfg
        this.inventory = Bukkit.createInventory(null, 4*9, "Title");
    }

    @Override
    public void open() {
        player.openInventory(inventory);
    }

    @Override
    public void close() {
        // todo: send close commands to observer
        player.closeInventory();
    }

    @Override
    public void generateUI() {
        // todo: generate UI
    }
}
