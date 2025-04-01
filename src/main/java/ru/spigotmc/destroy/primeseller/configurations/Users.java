package ru.spigotmc.destroy.primeseller.configurations;

import org.bukkit.configuration.file.FileConfiguration;
import ru.spigotmc.destroy.primeseller.entity.User;

import java.util.UUID;

public class Users extends AbstractConfig {
    private final FileConfiguration config = getConfig();

    public Users(String configName) {
        super(configName);
    }

    public void addUser(UUID uuid, User user) {

        config.set(uuid.toString()+".auto-buy", user.isAutoBuyEnabled());

        saveConfig(config);
    }
}
