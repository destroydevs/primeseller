package me.byteswing.primeseller.bukkit.entity;

import me.byteswing.primeseller.entity.IRawPlayerEntity;
import org.bukkit.entity.Player;

public interface IPlayerEntity extends IRawPlayerEntity {
    Player getPlayer();
}
