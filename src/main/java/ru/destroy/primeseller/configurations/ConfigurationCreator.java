package ru.destroy.primeseller.configurations;

import ru.destroy.primeseller.PrimeSeller;
import ru.destroy.primeseller.exceptions.UnsupportedLocaleException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class ConfigurationCreator {
    /**
     *
     * @param configName
     * @param locale
     */
    public static void createConfig(String configName, Locales locale, String dataFolder) {
        String owner = "langs";

        String localeName = locale.toString().toLowerCase(Locale.ENGLISH);

        String separator = File.pathSeparator;

        String patch = owner+separator+localeName+separator+configName;

        saveResource(patch, dataFolder+separator+configName);
    }

    /**
     *
     * @param from
     * @param to
     */
    private static void saveResource(String from, String to) {
        try (InputStream stream = PrimeSeller.class
                .getClassLoader()
                .getResourceAsStream(from)) {

            byte[] bytes = stream.readAllBytes();

            Files.write(Path.of(to), bytes);

        } catch (IOException | NullPointerException e) {
            throw new UnsupportedLocaleException("Locale file is not found!");
        }
    }

}