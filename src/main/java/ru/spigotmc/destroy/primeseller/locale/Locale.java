package ru.spigotmc.destroy.primeseller.locale;

import ru.spigotmc.destroy.primeseller.locale.reflect.Comment;
import ru.spigotmc.destroy.primeseller.locale.reflect.CommentType;
import ru.spigotmc.destroy.primeseller.locale.reflect.Path;

import java.util.List;

public abstract class Locale {
    public Menu menu;
    public Config config;

    public Locale() {
        this.menu = new Menu();
        this.config = new Config();
        setLocaleValues();
    }

    protected abstract void setLocaleValues();

    public static class Menu {
        @Path(path = "title")
        @Comment(comment = "Title in the menu")
        public String title;

        @Path(path = "size")
        @Comment(comment = "Number of slots")
        public int size;

        @Path(path = "sell-inventory.material")
        @Comment(comment = "Material for the sell inventory item")
        public String sellInventoryMaterial;

        @Path(path = "sell-inventory.model-data")
        @Comment(comment = "Model data for the sell inventory item")
        public int sellInventoryModelData;

        @Path(path = "sell-inventory.name")
        @Comment(comment = "Name for the sell inventory item")
        public String sellInventoryName;

        @Path(path = "sell-inventory.lore")
        @Comment(comment = "Lore for the sell inventory item")
        public List<String> sellInventoryLore;

        @Path(path = "sell-inventory.slots")
        @Comment(comment = "Slots for the sell inventory item")
        public List<Integer> sellInventorySlots;

        @Path(path = "exit.material")
        @Comment(comment = "Material for the exit item")
        public String exitMaterial;

        @Path(path = "exit.model-data")
        @Comment(comment = "Model data for the exit item")
        public int exitModelData;

        @Path(path = "exit.name")
        @Comment(comment = "Name for the exit item")
        public String exitName;

        @Path(path = "exit.commands")
        @Comment(comment = "Commands for the exit item")
        public List<String> exitCommands;

        @Path(path = "exit.slots")
        @Comment(comment = "Slots for the exit item")
        public List<Integer> exitSlots;

        @Path(path = "countdown.material")
        @Comment(comment = "Material for the countdown item")
        public String countdownMaterial;

        @Path(path = "countdown.model-data")
        @Comment(comment = "Model data for the countdown item")
        public int countdownModelData;

        @Path(path = "countdown.name")
        @Comment(comment = "Name for the countdown item")
        public String countdownName;

        @Path(path = "countdown.lore")
        @Comment(comment = "Lore for the countdown item")
        public List<String> countdownLore;

        @Path(path = "countdown.slots")
        @Comment(comment = "Slots for the countdown item")
        public List<Integer> countdownSlots;

        @Path(path = "lim-items.lore")
        @Comment(comment = "Lore for the limited items")
        public List<String> limItemsLore;

        @Path(path = "lim-items.slots")
        @Comment(comment = "Slots for the limited items")
        public List<Integer> limItemsSlots;

        @Path(path = "unlim-items.lore")
        @Comment(comment = "Lore for the unlimited items")
        public List<String> unlimItemsLore;

        @Path(path = "unlim-items.slots")
        @Comment(comment = "Slots for the unlimited items")
        public List<Integer> unlimItemsSlots;

        @Path(path = "divider.your_name.material")
        @Comment(comment = "Material for the divider item")
        public String dividerMaterial;

        @Path(path = "divider.your_name.model-data")
        @Comment(comment = "Model data for the divider item")
        public int dividerModelData;

        @Path(path = "divider.your_name.name")
        @Comment(comment = "Name for the divider item")
        public String dividerName;

        @Path(path = "divider.your_name.slots")
        @Comment(comment = "Slots for the divider item")
        public List<Integer> dividerSlots;
    }

    public static class Config {
        @Path(path = "time-zone")
        @Comment(comment = "Time zone setting")
        public String timezone;

        @Path(path = "metrics")
        @Comment(comment = "Plugin metrics")
        public boolean metrics;

        @Path(path = "middle-click-sell-all")
        @Comment(comment = "Sell on middle mouse click")
        public boolean middleClickSellAll;

        @Path(path = "inv-sell-priority")
        @Comment(comment = "Priority of selling inventory", type = CommentType.ABOVE)
        public String prioritySellInv;

        @Path(path = "enable-permission")
        @Comment(comment = "Enable permission for command usage")
        public boolean enablePermission;

        @Path(path = "understating-price.enable")
        @Comment(comment = "Enable price reduction on sale")
        public boolean understatingPriceEnable;

        @Path(path = "understating-price.percent")
        @Comment(comment = "Percentage by which the price will be reduced")
        public double understatingPricePercent;

        @Path(path = "understating-price.min-percent")
        @Comment(comment = "Minimum percentage of the amount")
        public int understatingPriceMinPercent;

        @Path(path = "time-format")
        @Comment(comment = "Time format")
        public String timeFormat;

        @Path(path = "messages.sell-inventory")
        @Comment(comment = "Message for selling inventory")
        public String sellInventory;

        @Path(path = "messages.sell")
        @Comment(comment = "Message for selling an item")
        public String sell;

        @Path(path = "messages.limit")
        @Comment(comment = "Message for reaching the sell limit")
        public String limit;

        @Path(path = "messages.amount")
        @Comment(comment = "Message for insufficient items")
        public String amount;

        @Path(path = "messages.limited-update-cast")
        @Comment(comment = "Message for limited seller update")
        public List<String> limitedUpdateCast;

        @Path(path = "messages.unlimited-update-cast")
        @Comment(comment = "Message for unlimited seller update")
        public List<String> unlimitedUpdateCast;

        @Path(path = "messages.update-cast")
        @Comment(comment = "Message for full seller update")
        public List<String> updateCast;

        @Path(path = "messages.commands.permission")
        @Comment(comment = "Permission denied message")
        public String permission;

        @Path(path = "messages.commands.reload")
        @Comment(comment = "Configuration reloaded message")
        public String reload;

        @Path(path = "messages.commands.update")
        @Comment(comment = "Sell list updated message")
        public String update;

        @Path(path = "messages.commands.added")
        @Comment(comment = "Item added to sell list message")
        public String added;

        @Path(path = "messages.commands.addlimited-use")
        @Comment(comment = "Usage message for adding limited item")
        public String addlimitedUse;

        @Path(path = "messages.commands.addunlimited-use")
        @Comment(comment = "Usage message for adding unlimited item")
        public String addunlimitedUse;

        @Path(path = "messages.commands.update-use")
        @Comment(comment = "Usage message for updating sell list")
        public String updateUse;
    }
}
