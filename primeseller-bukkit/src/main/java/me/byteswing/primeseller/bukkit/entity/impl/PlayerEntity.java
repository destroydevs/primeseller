package me.byteswing.primeseller.bukkit.entity.impl;

import me.byteswing.primeseller.bukkit.entity.IPlayerEntity;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerEntity implements IPlayerEntity {
    private final UUID uuid;
    private final Player player;
    private String group;
    private int playerUsedLimit;
    private final int playerTotalLimit;
    private int itemsSold;
    private boolean isAutoSellEnabled;

    // todo: create factory for easy player creating
    public PlayerEntity(UUID uuid,
                        Player player,
                        String group,
                        int playerUsedLimit,
                        int playerTotalLimit,
                        int itemsSold,
                        boolean isAutoSellEnabled) {
        this.uuid = uuid;
        this.player = player;
        this.group = group;
        this.playerUsedLimit = playerUsedLimit;
        this.playerTotalLimit = playerTotalLimit;
        this.itemsSold = itemsSold;
        this.isAutoSellEnabled = isAutoSellEnabled;
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
    public void setPlayerGroup(String group) {
        this.group = group;
    }

    @Override
    public UUID getUUID() {
        return this.uuid;
    }

    @Override
    public int getUsedLimit() {
        return this.playerUsedLimit;
    }

    @Override
    public int getTotalLimit() {
        return this.playerTotalLimit;
    }

    @Override
    public void setUsedLimit(int limit) {
        this.playerUsedLimit = limit;
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
