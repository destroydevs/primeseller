package ru.destroy.primeseller.settings.menus.ru;

import ru.leymooo.annotatedyaml.Annotations.*;
import ru.leymooo.annotatedyaml.Configuration;
import ru.leymooo.annotatedyaml.ConfigurationSection;

import java.util.List;
import java.util.Map;

public class RussianMenu extends Configuration {

    @Key("title")
    @Comment({"тайтл в меню"})
    private String title = "Скупщик предметов";

    @Key("size")
    @Comment({"кол-во слотов"})
    private int size = 54;

    private SellInventory sellInventory = new SellInventory();

    private Exit exit = new Exit();

    private Countdown countdown = new Countdown();

    private LimItems limItems = new LimItems();

    private UnlimItems unlimItems = new UnlimItems();

    @Key("divider")
    private Map<String, DividerEntry> dividers;

    @Key("sell-inventory")
    public static class SellInventory {
        @Key("material") private String material = "CHEST";
        @Key("model-data") private int modelData = 0;
        @Key("name") private String name = "&aПродать инвентарь";
        @Key("lore") private List<String> lore = List.of("");
        @Key("slots") private List<Integer> slots = List.of(49);

        public String getMaterial() { return material; }
        public int getModelData() { return modelData; }
        public String getName() { return name; }
        public List<String> getLore() { return lore; }
        public List<Integer> getSlots() { return slots; }
    }

    @Key("exit")
    public static class Exit {
        @Key("material") private String material = "RED_STAINED_GLASS_PANE";
        @Key("model-data") private int modelData = 0;
        @Key("name") private String name = "#ff4141Закрыть";
        @Key("commands") private List<String> commands = List.of("[close]", "[cmd] menu");
        @Key("slots") private List<Integer> slots = List.of(45, 53);

        public String getMaterial() { return material; }
        public int getModelData() { return modelData; }
        public String getName() { return name; }
        public List<String> getCommands() { return commands; }
        public List<Integer> getSlots() { return slots; }
    }

    @Key("countdown")
    public static class Countdown {
        @Key("material") private String material = "basehead-eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzZjMGQwNDU5YzY3ZjJiZTgyZmJlNTQwNmFiOGQxMzc4ZGExZjI4ZjdhM2Y4MmYxZGZjNDc2MTVhOTU1YTcifX19";
        @Key("model-data") private int modelData = 0;
        @Key("name") private String name = "#ddddddДо след обновления:";
        @Key("lore") private List<String> lore = List.of(
                "",
                "#ddddddОбновление лимитированного скупщика через:",
                "#eaff43> #7348dd%lim-time% &7|&8 %lim-time-format%",
                "",
                "#ddddddОбновление скупщика без лимита через:",
                "#eaff43> #7348dd%unlim-time% &7|&8 %unlim-time-format%",
                ""
        );
        @Key("slots") private List<Integer> slots = List.of(4);

        public String getMaterial() { return material; }
        public int getModelData() { return modelData; }
        public String getName() { return name; }
        public List<String> getLore() { return lore; }
        public List<Integer> getSlots() { return slots; }
    }

    @Key("lim-items")
    public static class LimItems {
        @Key("lore") private List<String> lore = List.of(
                "",
                "#ddddddЦена за #a9e3ffх1: #53fb31$%price-x1% #b9b9b9(ЛКМ)",
                "#ddddddЦена за #a9e3ffх64: #53fb31$%price-x64% #b9b9b9(ПКМ)",
                "",
                "#ddddddЦена за #a9e3ffвсё: #53fb31$%price-all% #b9b9b9(СКМ)",
                "",
                "#ddddddПредметы в этой строке #ff4141ограничены&f!",
                "#ddddddПродано из общ. кол-ва: #7348dd%sell% &8из #7348dd%max%",
                "#ddddddПродано таких предметов: #7348dd%sell-items% &8из #7348dd%max-items%"
        );
        @Key("slots") private List<Integer> slots = List.of(9,10,11,12,18,19,20,21,27,28,29,30,36,37,38,39);

        public List<String> getLore() { return lore; }
        public List<Integer> getSlots() { return slots; }
    }

    @Key("unlim-items")
    public static class UnlimItems {
        @Key("lore") private List<String> lore = List.of(
                "",
                "#ddddddЦена за #a9e3ffх1: #53fb31$%price-x1% &7(ЛКМ)",
                "#ddddddЦена за #a9e3ffх64: #53fb31$%price-x64% &7(ПКМ)",
                "",
                "#ddddddЦена за #a9e3ffвсё: #53fb31$%price-all% &7(СКМ)",
                "",
                "#ddddddПредметы &aне ограничены&f!",
                "#ff4141ВНИМАНИЕ! #ddddddЦена занижена!"
        );
        @Key("slots") private List<Integer> slots = List.of(14,15,16,17,23,24,25,26,32,33,34,35,41,42,43,44);

        public List<String> getLore() { return lore; }
        public List<Integer> getSlots() { return slots; }
    }

    public static class DividerEntry implements ConfigurationSection {
        @Key("material") private String material;
        @Key("model-data") private int modelData;
        @Key("name") private String name;
        @Key("slots") private List<Integer> slots;

        public String getMaterial() { return material; }
        public int getModelData() { return modelData; }
        public String getName() { return name; }
        public List<Integer> getSlots() { return slots; }
    }

    public String getTitle() { return title; }
    public int getSize() { return size; }
    public SellInventory getSellInventory() { return sellInventory; }
    public Exit getExit() { return exit; }
    public Countdown getCountdown() { return countdown; }
    public LimItems getLimItems() { return limItems; }
    public UnlimItems getUnlimItems() { return unlimItems; }
    public Map<String, DividerEntry> getDividers() { return dividers; }
}