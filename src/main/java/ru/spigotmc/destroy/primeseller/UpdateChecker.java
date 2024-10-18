package ru.spigotmc.destroy.primeseller;

import org.bukkit.Bukkit;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UpdateChecker {
    private static final String PLUGIN_ID = "108813";
    private static final String RESOURCE_URL = "https://www.spigotmc.org/resources/primeseller-advanced-buyer-of-items-1-13-1-21.108813/";
    private static final String API_URL = "https://api.spigotmc.org/legacy/update.php?resource=" + PLUGIN_ID;

    public static void start() {
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(UpdateChecker::checkForUpdates,1,60*6, TimeUnit.MINUTES);
    }

    private static void checkForUpdates() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    if (response.statusCode() != 200) {
                        Bukkit.getLogger().warning("[PrimeSeller] Failed to check for updates: " + response.statusCode());
                        return;
                    }

                    String latestVersion = response.body().replace(" ", "").substring(1);
                    String currentVersion = PrimeSeller.getPlugin(PrimeSeller.class).getDescription().getVersion();

                    if (!currentVersion.equals(latestVersion)) {
                        Bukkit.getConsoleSender().sendMessage(" ");
                        Bukkit.getConsoleSender().sendMessage("§c[PrimeSeller] §eA new version of the plugin is available: v" + latestVersion);
                        Bukkit.getConsoleSender().sendMessage("§c[PrimeSeller] §eCurrent version: v" + currentVersion);
                        Bukkit.getConsoleSender().sendMessage("§c[PrimeSeller] §eDownload the latest version from SpigotMC.");
                        Bukkit.getConsoleSender().sendMessage(" ");
                    }
                })
                .exceptionally(e -> {
                    Bukkit.getLogger().warning("[PrimeSeller] Failed to check for updates: " + e.getMessage());
                    return null;
                });
    }
}