package me.byteswing.primeseller.util;

import me.byteswing.primeseller.PrimeSeller;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Chat {
    private static String prefix = "";
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();

    public static void init(PrimeSeller plugin) {
        prefix = plugin.getConfig().getString("prefix", "<gradient:#5637bc:#9258ff>SELLER</gradient> <#b9b9b9>|");
    }

    public static Component toComponent(@NotNull String message) {
        return miniMessage.deserialize(message);
    }

    public static void sendMessage(CommandSender sender, String msg) {
        if (msg == null || msg.isEmpty()) return;
        sender.sendMessage(toComponent(prefix + " " + msg));
    }

    public static void broadcast(List<String> messages) {
        if (messages.isEmpty()) return;
        String combinedMessage = String.join("\n", messages);
        Bukkit.broadcast(toComponent(combinedMessage));
    }
}
