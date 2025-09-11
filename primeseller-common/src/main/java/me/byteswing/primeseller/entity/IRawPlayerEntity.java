package me.byteswing.primeseller.entity;

import java.util.UUID;

public interface IRawPlayerEntity {
    String getPlayerGroup();
    UUID getUUID();

    int getPlayerLimit();
    int setPlayerLimit();

    /**
     * @return Amount of sold items by player
     */
    int getPlayerSells();
    int setPlayerSells();

    boolean isAutoSellEnabled();


}
