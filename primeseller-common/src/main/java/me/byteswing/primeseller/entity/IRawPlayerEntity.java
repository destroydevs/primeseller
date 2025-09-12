package me.byteswing.primeseller.entity;

import java.util.UUID;

public interface IRawPlayerEntity {
    String getPlayerGroup();
    void setPlayerGroup(String group);

    UUID getUUID();

    int getUsedLimit();
    int getTotalLimit();
    void setUsedLimit(int limit);

    default void addUsedLimit(int limit) {
        setUsedLimit(getUsedLimit() + limit);
    }

    /**
     * @return Amount of sold items by player
     */
    int getPlayerSold();
    void setPlayerSold(int sold);

    default void addPlayerSold(int sold) {
        setPlayerSold(getPlayerSold() + sold);
    }

    boolean isAutoSellEnabled();
    void setAutoSellEnabled(boolean enabled);

}
