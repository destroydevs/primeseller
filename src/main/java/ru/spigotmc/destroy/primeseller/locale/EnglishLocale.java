package ru.spigotmc.destroy.primeseller.locale;

import ru.spigotmc.destroy.primeseller.locale.reflect.Comment;
import ru.spigotmc.destroy.primeseller.locale.reflect.CommentType;
import ru.spigotmc.destroy.primeseller.locale.reflect.Path;

import java.util.Arrays;
import java.util.List;

public class EnglishLocale {

    public static class Config {
        @Path(path = "time-zone")
        @Comment(comment = "All time zones: https://timeie.com/")
        public String timezone = "Europe/Berlin";

        @Path(path = "metrics")
        @Comment(comment = "Plugin metrics")
        public boolean metrics = true;

        @Path(path = "middle-click-sell-all")
        @Comment(comment = "Sell on middle mouse click. If false, sell with SHIFT+LMB")
        public boolean middleClickSellAll = true;

        @Path(path = "inv-sell-priority")
        @Comment(comment = "Priority of selling inventory to the buyer. UNLIMITED - unlimited first, LIMITED - limited first.", type = CommentType.ABOVE)
        public String prioritySellInv = "LIMITED";

        @Path(path = "enable-permission")
        @Comment(comment = "Enable permission for command usage? primeseller.open")
        public boolean enablePermission = false;

        @Path(path = "understating-price")
        @Comment(comment = "Enable price reduction on sale \n# (percent = Percentage by which the price will be reduced on sale)\n# (min-percent = Minimum percentage of the amount)", type = CommentType.ABOVE)
        public String understanding = null;

        @Path(path = "understating-price.enable")
        @Comment(comment = "Enable price reduction on sale")
        public boolean enable = true;

        @Path(path = "understating-price.percent")
        @Comment(comment = "Percentage by which the price will be reduced on sale")
        public double percent = 0.5;

        @Path(path = "understating-price.min-percent")
        @Comment(comment = "Minimum percentage of the amount")
        public int minPercent = 50;

        @Path(path = "time-format")
        @Comment(comment = "Time format", type = CommentType.IN_LINE)
        public String timeFormat = "hhч. mmм. ssс.";

        @Path(path = "messages")
        @Comment(comment = "Message for selling inventory", type = CommentType.ABOVE)
        public String messages = null;

        @Path(path = "messages.sell-inventory")
        @Comment(comment = "Message for selling inventory")
        public String sellInventory = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddYou successfully sold your inventory. #ddddddSale results: &e%amount% #ddddddfor #53fb31$%price%!";

        @Path(path = "messages.sell")
        @Comment(comment = "Message for selling an item")
        public String sell = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddYou successfully sold &e%item% %amount% #ddddddfor #53fb31$%price%!";

        @Path(path = "messages.limit")
        @Comment(comment = "Message for reaching the sell limit")
        public String limit = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141Your sell limit for this item has been reached! Come back later.";

        @Path(path = "messages.amount")
        @Comment(comment = "Message for insufficient items")
        public String amount = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141Not enough items.";

        @Path(path = "messages.limited-update-cast")
        @Comment(comment = "Message for limited seller update")
        public List<String> limitedUpdateCast = Arrays.asList(
                "",
                "#ddddddLimited seller updated! - #00d328/seller",
                ""
        );

        @Path(path = "messages.unlimited-update-cast")
        @Comment(comment = "Message for unlimited seller update")
        public List<String> unlimitedUpdateCast = Arrays.asList(
                "",
                "#ddddddUnlimited seller updated! - #00d328/seller",
                ""
        );

        @Path(path = "messages.update-cast")
        @Comment(comment = "Message for full seller update")
        public List<String> updateCast = Arrays.asList(
                "",
                "#ddddddSeller fully updated! - #00d328/seller",
                ""
        );

        @Path(path = "messages.commands.permission")
        @Comment(comment = "Permission denied message")
        public String permission = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141You do not have permission.";

        @Path(path = "messages.commands.reload")
        @Comment(comment = "Configuration reloaded message")
        public String reload = "&aConfiguration successfully reloaded!";

        @Path(path = "messages.commands.update")
        @Comment(comment = "Sell list updated message")
        public String update = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #00d328Sell list successfully updated!";

        @Path(path = "messages.commands.added")
        @Comment(comment = "Item added to sell list message")
        public String added = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddItem #eaff43%item% #ddddddsuccessfully added to the sell list. Its price ranges from #53fb31$%min-price% #ddddddto #53fb31$%max-price%#dddddd per item.";

        @Path(path = "messages.commands.addlimited-use")
        @Comment(comment = "Usage message for adding limited item")
        public String addlimitedUse = "&cUsage: /primeseller addlimited (min price) (max price) per item (Hold the item in your hand) - Add item to sell.";

        @Path(path = "messages.commands.addunlimited-use")
        @Comment(comment = "Usage message for adding unlimited item")
        public String addunlimitedUse = "&cUsage: /primeseller addunlimited (min price) (max price) per item (Hold the item in your hand) - Add item to sell.";

        @Path(path = "messages.commands.update-use")
        @Comment(comment = "Usage message for updating sell list")
        public String updateUse = "&cUsage: /primeseller update - Update sell list";
    }

    public static class Menu {
        @Path(path = "title")
        @Comment(comment = "Title in the menu")
        public String title = "Item Buyer";

        @Path(path = "size")
        @Comment(comment = "Number of slots")
        public int size = 54;

        @Path(path = "sell-inventory.material")
        @Comment(comment = "Material for the sell inventory item")
        public String sellInventoryMaterial = "CHEST";

        @Path(path = "sell-inventory.model-data")
        @Comment(comment = "Model data for the sell inventory item")
        public int sellInventoryModelData = 0;

        @Path(path = "sell-inventory.name")
        @Comment(comment = "Name for the sell inventory item")
        public String sellInventoryName = "&aSell Inventory";

        @Path(path = "sell-inventory.lore")
        @Comment(comment = "Lore for the sell inventory item")
        public List<String> sellInventoryLore = Arrays.asList("");

        @Path(path = "sell-inventory.slots")
        @Comment(comment = "Slots for the sell inventory item")
        public List<Integer> sellInventorySlots = Arrays.asList(49);

        @Path(path = "exit.material")
        @Comment(comment = "Material for the exit item")
        public String exitMaterial = "RED_STAINED_GLASS_PANE";

        @Path(path = "exit.model-data")
        @Comment(comment = "Model data for the exit item")
        public int exitModelData = 0;

        @Path(path = "exit.name")
        @Comment(comment = "Name for the exit item")
        public String exitName = "#ff4141Close";

        @Path(path = "exit.commands")
        @Comment(comment = "Commands for the exit item")
        public List<String> exitCommands = Arrays.asList("[close]", "[cmd] menu");

        @Path(path = "exit.slots")
        @Comment(comment = "Slots for the exit item")
        public List<Integer> exitSlots = Arrays.asList(45, 53);

        @Path(path = "countdown.material")
        @Comment(comment = "Material for the countdown item")
        public String countdownMaterial = "basehead-eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzZjMGQwNDU5YzY3ZjJiZTgyZmJlNTQwNmFiOGQxMzc4ZGExZjI4ZjdhM2Y4MmYxZGZjNDc2MTVhOTU1YTcifX19";

        @Path(path = "countdown.model-data")
        @Comment(comment = "Model data for the countdown item")
        public int countdownModelData = 0;

        @Path(path = "countdown.name")
        @Comment(comment = "Name for the countdown item")
        public String countdownName = "#ddddddNext update:";

        @Path(path = "countdown.lore")
        @Comment(comment = "Lore for the countdown item")
        public List<String> countdownLore = Arrays.asList(
                "",
                "#ddddddLimited buyer update in:",
                "#eaff43> #7348dd%lim-time% &7|&8 %lim-time-format%",
                "",
                "#ddddddUnlimited buyer update in:",
                "#eaff43> #7348dd%unlim-time% &7|&8 %unlim-time-format%",
                ""
        );

        @Path(path = "countdown.slots")
        @Comment(comment = "Slots for the countdown item")
        public List<Integer> countdownSlots = Arrays.asList(4);

        @Path(path = "lim-items.lore")
        @Comment(comment = "Lore for the limited items")
        public List<String> limItemsLore = Arrays.asList(
                "",
                "#ddddddPrice for #a9e3ffx1: #53fb31$%price-x1% #b9b9b9(LMB)",
                "#ddddddPrice for #a9e3ffx64: #53fb31$%price-x64% #b9b9b9(RMB)",
                "",
                "#ddddddPrice for #a9e3ffall: #53fb31$%price-all% #b9b9b9(MMB)",
                "",
                "#ddddddItems in this row are #ff4141limited&f!",
                "#ddddddSold from total: #7348dd%sell% &8out of #7348dd%max%",
                "#ddddddSold items: #7348dd%sell-items% &8out of #7348dd%max-items%"
        );

        @Path(path = "lim-items.slots")
        @Comment(comment = "Slots for the limited items")
        public List<Integer> limItemsSlots = Arrays.asList(
                9, 10, 11, 12, 18, 19, 20, 21, 27, 28, 29, 30, 36, 37, 38, 39
        );

        @Path(path = "unlim-items.lore")
        @Comment(comment = "Lore for the unlimited items")
        public List<String> unlimItemsLore = Arrays.asList(
                "",
                "#ddddddPrice for #a9e3ffx1: #53fb31$%price-x1% &7(LMB)",
                "#ddddddPrice for #a9e3ffx64: #53fb31$%price-x64% &7(RMB)",
                "",
                "#ddddddPrice for #a9e3ffall: #53fb31$%price-all% &7(MMB)",
                "",
                "#ddddddItems are &anot limited&f!",
                "#ff4141NOTICE! #ddddddPrice is reduced!"
        );

        @Path(path = "unlim-items.slots")
        @Comment(comment = "Slots for the unlimited items")
        public List<Integer> unlimItemsSlots = Arrays.asList(
                14, 15, 16, 17, 23, 24, 25, 26, 32, 33, 34, 35, 41, 42, 43, 44
        );

        @Path(path = "divider.your_name.material")
        @Comment(comment = "Material for the divider item")
        public String dividerMaterial = "BLACK_STAINED_GLASS_PANE";

        @Path(path = "divider.your_name.model-data")
        @Comment(comment = "Model data for the divider item")
        public int dividerModelData = 0;

        @Path(path = "divider.your_name.name")
        @Comment(comment = "Name for the divider item")
        public String dividerName = "&7";

        @Path(path = "divider.your_name.slots")
        @Comment(comment = "Slots for the divider item")
        public List<Integer> dividerSlots = Arrays.asList(
                0, 1, 2, 3, 5, 6, 7, 8, 13, 22, 31, 40, 49, 48, 47, 46, 50, 51, 52
        );
    }
}
