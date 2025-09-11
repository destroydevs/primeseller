package me.byteswing.primeseller.bukkit.entity.impl;

import me.byteswing.primeseller.bukkit.entity.IPlayerEntity;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerEntity implements IPlayerEntity {
    private final UUID uuid;
    private Player player;
    private String group;
    private int playerLimit;
    private int itemsSold;
    private boolean isAutoBuyEnabled;

    public PlayerEntity(UUID uuid) {
        this.uuid = uuid;

        // todo: find all things by player uuid
    }

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public String getPlayerGroup() {
        return "";
    }

    @Override
    public UUID getUUID() {
        return this.uuid;
    }

    @Override
    public int getPlayerLimit() {
        return 0;
    }

    @Override
    public int setPlayerLimit() {
        return 0;
    }

    @Override
    public int getPlayerSells() {
        return 0;
    }

    @Override
    public int setPlayerSells() {
        return 0;
    }

    @Override
    public boolean isAutoSellEnabled() {
        return false;
    }
}
