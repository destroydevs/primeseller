package me.byteswing.primeseller.entity;

import java.util.UUID;

public interface IRawPlayerEntity {
    String getPlayerGroup();
    UUID getUUID();

    int getPlayerLimit();
    void setPlayerLimit(int limit);

    /**
     * @return Amount of sold items by player
     */
    int getPlayerSold();
    void setPlayerSold(int sold);

    boolean isAutoSellEnabled();
    void setAutoSellEnabled(boolean enabled);

}
