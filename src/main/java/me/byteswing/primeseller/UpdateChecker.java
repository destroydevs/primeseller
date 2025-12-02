package me.byteswing.primeseller;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

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

    public static void start(Plugin plugin) {
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(()->UpdateChecker.checkForUpdates(plugin),10,60*2*60, TimeUnit.SECONDS);
    }

    private static void checkForUpdates(Plugin plugin) {
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
                    String currentVersion = plugin.getDescription().getVersion();

                    if (!currentVersion.equals(latestVersion)) {
                        Bukkit.getConsoleSender().sendMessage(" ");
                        Bukkit.getConsoleSender().sendMessage("§c[PrimeSeller] A new version of the plugin is available: §av" + latestVersion);
                        Bukkit.getConsoleSender().sendMessage("§c[PrimeSeller] Current version: §ev" + currentVersion);
                        Bukkit.getConsoleSender().sendMessage("§c[PrimeSeller] Download the latest version from SpigotMC.");
                        Bukkit.getConsoleSender().sendMessage(" ");
                        Bukkit.getConsoleSender().sendMessage("§c[PrimeSeller] Доступна новая версия плагина: §av" + latestVersion);
                        Bukkit.getConsoleSender().sendMessage("§c[PrimeSeller] Текущая версия: §ev" + currentVersion);
                        Bukkit.getConsoleSender().sendMessage("§c[PrimeSeller] Скачайте последнюю версию с SpigotMC.");
                        Bukkit.getConsoleSender().sendMessage(" ");

                    }
                })
                .exceptionally(e -> {
                    Bukkit.getLogger().warning("[PrimeSeller] Failed to check for updates: " + e.getMessage());
                    return null;
                });
    }
}
