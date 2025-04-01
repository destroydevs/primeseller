package ru.spigotmc.destroy.primeseller.configurations;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import ru.spigotmc.destroy.primeseller.locale.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

public class Menu extends AbstractConfig {
    public Menu(String configName) {
        super(configName);
    }
}
