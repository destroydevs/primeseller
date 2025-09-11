package me.byteswing.primeseller.bukkit.entity.impl;

import me.byteswing.primeseller.bukkit.entity.IPlayerEntity;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerEntity implements IPlayerEntity {
    private final UUID uuid;
    private final Player player;
    private String group;
    private int playerLimit;
    private int itemsSold;
    private boolean isAutoSellEnabled;

    // todo: create factory for easy player creating
    public PlayerEntity(UUID uuid, Player player, String group, int playerLimit, int itemsSold, boolean isAutoBuyEnabled) {
        this.uuid = uuid;
        this.player = player;
        this.group = group;
        this.playerLimit = playerLimit;
        this.itemsSold = itemsSold;
        this.isAutoSellEnabled = isAutoBuyEnabled;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public String getPlayerGroup() {
        return this.group;
    }

    @Override
    public UUID getUUID() {
        return this.uuid;
    }

    @Override
    public int getPlayerLimit() {
        return this.playerLimit;
    }

    @Override
    public void setPlayerLimit(int limit) {
        this.playerLimit = limit;
    }

    @Override
    public int getPlayerSold() {
        return this.itemsSold;
    }

    @Override
    public void setPlayerSold(int sold) {
        this.itemsSold = sold;
    }

    @Override
    public boolean isAutoSellEnabled() {
        return this.isAutoSellEnabled;
    }

    @Override
    public void setAutoSellEnabled(boolean enabled) {
        this.isAutoSellEnabled = enabled;
    }
}
