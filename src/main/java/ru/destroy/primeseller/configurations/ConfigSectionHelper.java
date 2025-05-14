package ru.destroy.primeseller.configurations;

import org.bukkit.configuration.ConfigurationSection;

public class ConfigSectionHelper {
    private final ConfigurationSection configurationSection;

    public ConfigSectionHelper(AbstractConfig config, String section) {
        configurationSection = config.getConfig().getConfigurationSection(section);
    }

    public ConfigurationSection getSection() {
        return configurationSection;
    }
}
