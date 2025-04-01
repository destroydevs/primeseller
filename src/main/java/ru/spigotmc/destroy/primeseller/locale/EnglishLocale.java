package ru.spigotmc.destroy.primeseller.locale;

import java.util.Arrays;

public class EnglishLocale extends Locale {

    @Override
    protected void setLocaleValues() {
        menu.title = "Item Buyer";
        menu.size = 54;
        menu.sellInventoryMaterial = "CHEST";
        menu.sellInventoryModelData = 0;
        menu.sellInventoryName = "&aSell Inventory";
        menu.sellInventoryLore = Arrays.asList("");
        menu.sellInventorySlots = Arrays.asList(49);
        menu.exitMaterial = "RED_STAINED_GLASS_PANE";
        menu.exitModelData = 0;
        menu.exitName = "#ff4141Close";
        menu.exitCommands = Arrays.asList("[close]", "[cmd] menu");
        menu.exitSlots = Arrays.asList(45, 53);
        menu.countdownMaterial = "basehead-eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzZjMGQwNDU5YzY3ZjJiZTgyZmJlNTQwNmFiOGQxMzc4ZGExZjI4ZjdhM2Y4MmYxZGZjNDc2MTVhOTU1YTcifX19";
        menu.countdownModelData = 0;
        menu.countdownName = "#ddddddNext update:";
        menu.countdownLore = Arrays.asList(
                "",
                "#ddddddLimited buyer update in:",
                "#eaff43> #7348dd%lim-time% &7|&8 %lim-time-format%",
                "",
                "#ddddddUnlimited buyer update in:",
                "#eaff43> #7348dd%unlim-time% &7|&8 %unlim-time-format%",
                ""
        );
        menu.countdownSlots = Arrays.asList(4);
        menu.limItemsLore = Arrays.asList(
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
        menu.limItemsSlots = Arrays.asList(
                9, 10, 11, 12, 18, 19, 20, 21, 27, 28, 29, 30, 36, 37, 38, 39
        );
        menu.unlimItemsLore = Arrays.asList(
                "",
                "#ddddddPrice for #a9e3ffx1: #53fb31$%price-x1% &7(LMB)",
                "#ddddddPrice for #a9e3ffx64: #53fb31$%price-x64% &7(RMB)",
                "",
                "#ddddddPrice for #a9e3ffall: #53fb31$%price-all% &7(MMB)",
                "",
                "#ddddddItems are &anot limited&f!",
                "#ff4141NOTICE! #ddddddPrice is reduced!"
        );
        menu.unlimItemsSlots = Arrays.asList(
                14, 15, 16, 17, 23, 24, 25, 26, 32, 33, 34, 35, 41, 42, 43, 44
        );
        menu.dividerMaterial = "BLACK_STAINED_GLASS_PANE";
        menu.dividerModelData = 0;
        menu.dividerName = "&7";
        menu.dividerSlots = Arrays.asList(
                0, 1, 2, 3, 5, 6, 7, 8, 13, 22, 31, 40, 49, 48, 47, 46, 50, 51, 52
        );

        config.timezone = "Europe/Berlin";
        config.metrics = true;
        config.middleClickSellAll = true;
        config.prioritySellInv = "LIMITED";
        config.enablePermission = false;
        config.understatingPriceEnable = true;
        config.understatingPricePercent = 0.5;
        config.understatingPriceMinPercent = 50;
        config.timeFormat = "hhч. mmм. ssс.";
        config.sellInventory = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddYou successfully sold your inventory. #ddddddSale results: &e%amount% #ddddddfor #53fb31$%price%!";
        config.sell = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddYou successfully sold &e%item% %amount% #ddddddfor #53fb31$%price%!";
        config.limit = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141Your sell limit for this item has been reached! Come back later.";
        config.amount = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141Not enough items.";
        config.limitedUpdateCast = Arrays.asList(
                "",
                "#ddddddLimited seller updated! - #00d328/seller",
                ""
        );
        config.unlimitedUpdateCast = Arrays.asList(
                "",
                "#ddddddUnlimited seller updated! - #00d328/seller",
                ""
        );
        config.updateCast = Arrays.asList(
                "",
                "#ddddddSeller fully updated! - #00d328/seller",
                ""
        );
        config.permission = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141You do not have permission.";
        config.reload = "&aConfiguration successfully reloaded!";
        config.update = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #00d328Sell list successfully updated!";
        config.added = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddItem #eaff43%item% #ddddddsuccessfully added to the sell list. Its price ranges from #53fb31$%min-price% #ddddddto #53fb31$%max-price%#dddddd per item.";
        config.addlimitedUse = "&cUsage: /primeseller addlimited (min price) (max price) per item (Hold the item in your hand) - Add item to sell.";
        config.addunlimitedUse = "&cUsage: /primeseller addunlimited (min price) (max price) per item (Hold the item in your hand) - Add item to sell.";
        config.updateUse = "&cUsage: /primeseller update - Update sell list";
    }
}