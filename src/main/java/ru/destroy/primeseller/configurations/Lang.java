package ru.destroy.primeseller.configurations;

import ru.destroy.primeseller.locale.Locales;

import java.util.Locale;

public class Lang extends AbstractConfig {


    public Lang(String configName) {
        super(configName);
    }

    public Locales getLocale() {
        return Locales.valueOf(getConfig().getString("language","RU").toUpperCase(Locale.ENGLISH));
    }
}
