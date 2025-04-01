package ru.spigotmc.destroy.primeseller.configurations;

public class Lang extends AbstractConfig {


    public Lang(String configName) {
        super(configName);
    }

    public String getLocale() {
        return getConfig().getString("language");
    }
}
