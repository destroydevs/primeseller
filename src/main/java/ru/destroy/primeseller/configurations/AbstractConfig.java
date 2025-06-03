package ru.destroy.primeseller.configurations;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public abstract class AbstractConfig {
    private final String configName;
    private File file;
    private FileConfiguration config;

    public AbstractConfig(String configName) {
        this.configName = configName;
    }

    public ConfigSectionHelper sectionHelper(String section) {
        return new ConfigSectionHelper(this, section);
    }

    public void loadYaml(Plugin main, Locales lang) {
        file = new File(main.getDataFolder(), configName);
        if (!file.exists()) {
            ConfigurationCreator.createConfig(configName, lang, main.getDataFolder().getAbsolutePath());
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public String getConfigName() {
        return configName;
    }

    public File getFile() {
        return file;
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void saveConfig(FileConfiguration config) {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadConfig() {
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            Bukkit.getLogger().warning("Не удалось загрузить "+this.configName);
            Bukkit.getLogger().warning("Возможные причины:");
            Bukkit.getLogger().warning("1. Нехватка памяти,");
            Bukkit.getLogger().warning("2. У плагина нет прав,");
            Bukkit.getLogger().warning("3. Конфигурация повреждена,");
            Bukkit.getLogger().warning("4. Неверный формат YAML.");
        }
    }
}
