package ru.spigotmc.destroy.primeseller.util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.spigotmc.destroy.primeseller.configurations.Config;
import ru.spigotmc.destroy.primeseller.configurations.database.MapBase;
import ru.spigotmc.destroy.primeseller.configurations.Items;
import ru.spigotmc.destroy.primeseller.configurations.Menu;
import ru.spigotmc.destroy.primeseller.configurations.database.SellItem;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {

    public static boolean update = false;
    
    private static final DecimalFormat format = new DecimalFormat("##.#");

    public static HashMap<UUID, Integer> playerSellItems = new HashMap<>();

    public static String limitedFormat = "Загрузка...";
    public static String unlimitedFormat = "Загрузка...";

    public static String formattedTime(int time) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy HH:mm");
        long a = time* 1000L;

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(Config.getConfig().getString("time-zone")));
        a += calendar.getTime().getTime()+calendar.getTimeZone().getRawOffset();
        return format.format(a);
    }

    public static void fillInventory(Inventory inv, List<String> countdown, List<String> unlim, List<String> lim, Player p) {
        MapBase sql = new MapBase();
        for (Map.Entry<Integer, SellItem> entry : MapBase.database.entrySet()) {
            int next = entry.getKey();
            ItemStack item = entry.getValue().getItem().clone();
            if (sql.isLimited(next)) {
                double price = sql.getPrice(next);
                String price64 = format.format(price*64).replace(",", ".");
                String priceall = format.format(Util.calc(p, item)*price).replace(",", ".");
                for (String s : Menu.getConfig().getStringList("lim-items.lore")) {
                    lim.add(Chat.color(s
                            .replace("%price-x1%", format.format(price).replace(",", "."))
                            .replace("%price-x64%", price64)
                            .replace("%price-all%", priceall)
                            .replace("%sell%", String.valueOf(Util.playerSellItems.get(p.getUniqueId())))
                            .replace("%max%", String.valueOf(Items.getConfig().getInt("limited.limit")))
                            .replace("%sell-items%", String.valueOf(sql.getSlot(next).getPlayerItemLimit(p))))
                            .replace("%max-items%", String.valueOf(Items.getConfig().getInt("limited.limit-per-items"))));
                }
                ItemMeta meta = item.getItemMeta();
                if(meta != null) meta.setLore(lim);
                item.setItemMeta(meta);
                inv.setItem(next, item);
                lim.clear();
                continue;
            }
            double price = sql.getPrice(next);
            String price64 = format.format(price*64).replace(",", ".");
            String priceall = format.format(Util.calc(p, item)*price).replace(",", ".");
            for (String s : Menu.getConfig().getStringList("unlim-items.lore")) {
                unlim.add(Chat.color(s
                        .replace("%price-x1%", format.format(price).replace(",", "."))
                        .replace("%price-all%", priceall)
                        .replace("%price-x64%", price64)));
            }
            ItemMeta meta = item.getItemMeta();
            if(meta != null) meta.setLore(unlim);
            item.setItemMeta(meta);
            inv.setItem(next, item);
            unlim.clear();
        }

        for(String s : Menu.getConfig().getConfigurationSection("divider").getKeys(false)) {
            for (Integer i : Menu.getConfig().getIntegerList("divider."+s+".slots")) {
                String items = Menu.getConfig().getString("divider."+s+".material");
                List<String> lore = Menu.getConfig().getStringList("divider."+s+".lore");
                int modelId = Menu.getConfig().getInt("divider."+s+".model-data",0);
                ItemStack item;
                try {
                    item = new ItemStack(Material.valueOf(items));
                } catch (IllegalArgumentException e) {
                    Bukkit.getLogger().warning("Неизвестный предмет: " + items);
                    continue;
                }
                lore.forEach(Chat::color);
                ItemMeta meta = item.getItemMeta();
                meta.setCustomModelData(modelId);
                meta.setLore(lore);
                meta.setDisplayName(Chat.color(Menu.getConfig().getString("divider."+s+".name")));
                item.setItemMeta(meta);
                inv.setItem(i, item);
            }
        }
        for (Integer i : Menu.getConfig().getIntegerList("exit.slots")) {
            String items = Menu.getConfig().getString("exit.material");
            List<String> lore = Menu.getConfig().getStringList("exit.lore");
            int modelId = Menu.getConfig().getInt("exit.model-data",0);
            ItemStack item;
            try {
                item = new ItemStack(Material.valueOf(items));
            } catch (IllegalArgumentException e) {
                Bukkit.getLogger().warning("Неизвестный предмет: " + items);
                break;
            }
            lore.forEach(Chat::color);
            ItemMeta meta = item.getItemMeta();
            meta.setLore(lore);
            meta.setCustomModelData(modelId);
            meta.setDisplayName(Chat.color(Menu.getConfig().getString("exit.name")));
            item.setItemMeta(meta);
            inv.setItem(i, item);
        }
        for (Integer i : Menu.getConfig().getIntegerList("countdown.slots")) {
            String name = Menu.getConfig().getString("countdown.material");
            int modelId = Menu.getConfig().getInt("countdown.model-data",0);
            ItemStack item = new ItemStack(Material.BARRIER);
            if(name != null) {
                if (name.startsWith("basehead-")) {
                    String url = name.replace("basehead-", "");
                    item = Util.getSkull(url);
                } else {
                    item = new ItemStack(Material.valueOf(name));
                }
            }
            ItemMeta meta = item.getItemMeta();
            for (String s : Menu.getConfig().getStringList("countdown.lore")) {
                countdown.add(Chat.color(s
                        .replace("%lim-time%", Updater.getLimitedTime(2))
                        .replace("%unlim-time%", Updater.getUnLimitedTime(2))
                        .replace("%lim-time-format%", limitedFormat)
                        .replace("%unlim-time-format%", unlimitedFormat)));
            }
            meta.setLore(countdown);
            meta.setCustomModelData(modelId);
            name = Menu.getConfig().getString("countdown.name");
            meta.setDisplayName(Chat.color(name));
            item.setItemMeta(meta);
            inv.setItem(i, item);
            countdown.clear();
        }
    }

    public static int calc(Player p, ItemStack s) {
        int count = 0;
        for(int i = 0; i < p.getInventory().getSize(); ++i) {
            if (i != 40 && i != 38 && i != 37 && i != 36 && i != 39) {
                ItemStack stack = p.getInventory().getItem(i);
                if (stack != null && stack.isSimilar(s)) {
                    count += stack.getAmount();
                }
            }
        }
        return count;
    }

    public static ItemStack getSkull(String url) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);;
        if(Bukkit.getBukkitVersion().contains("1.12") || Bukkit.getBukkitVersion().contains("1_12")) {
            item = new ItemStack(Material.valueOf("HEAD"));
        }
        ItemMeta meta = item.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "byteswing");
        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException var6) {
            var6.printStackTrace();
        }

        item.setItemMeta(meta);
        return item;
    }

    /*public static String getCountry() throws IOException {
        List<String> list = new ArrayList<>();
        URL oracle = new URL("http://www.geoplugin.net/xml.gp?ip=xx.xx.xx.xx");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            list.add(inputLine);

        String s = list.get(13).replace("\t<geoplugin_countryName>", "").replace("</geoplugin_countryName>", "");
        in.close();
        return s;
    }
    public static String getCountry(String ip) throws IOException {
        List<String> list = new ArrayList<>();
        URL oracle = new URL("http://www.geoplugin.net/xml.gp?ip="+ip);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            list.add(inputLine);

        String s = list.get(13).replace("\t<geoplugin_countryName>", "").replace("</geoplugin_countryName>", "");
        in.close();
        return s;
    }*/

}
