package ru.destroy.primeseller.locale;

import java.util.Arrays;

public class RussianLocale extends Locale {

    @Override
    protected void setLocaleValues() {
        menu.title = "Скупщик предметов";
        menu.size = 54;
        menu.sellInventoryMaterial = "CHEST";
        menu.sellInventoryModelData = 0;
        menu.sellInventoryName = "&aПродать инвентарь";
        menu.sellInventoryLore = Arrays.asList("");
        menu.sellInventorySlots = Arrays.asList(49);
        menu.exitMaterial = "RED_STAINED_GLASS_PANE";
        menu.exitModelData = 0;
        menu.exitName = "#ff4141Закрыть";
        menu.exitCommands = Arrays.asList("[close]", "[cmd] menu");
        menu.exitSlots = Arrays.asList(45, 53);
        menu.countdownMaterial = "basehead-eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzZjMGQwNDU5YzY3ZjJiZTgyZmJlNTQwNmFiOGQxMzc4ZGExZjI4ZjdhM2Y4MmYxZGZjNDc2MTVhOTU1YTcifX19";
        menu.countdownModelData = 0;
        menu.countdownName = "#ddddddДо след обновления:";
        menu.countdownLore = Arrays.asList(
                "",
                "#ddddddОбновление лимитированного скупщика через:",
                "#eaff43> #7348dd%lim-time% &7|&8 %lim-time-format%",
                "",
                "#ddddddОбновление скупщика без лимита через:",
                "#eaff43> #7348dd%unlim-time% &7|&8 %unlim-time-format%",
                ""
        );
        menu.countdownSlots = Arrays.asList(4);
        menu.limItemsLore = Arrays.asList(
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
        menu.limItemsSlots = Arrays.asList(
                9, 10, 11, 12, 18, 19, 20, 21, 27, 28, 29, 30, 36, 37, 38, 39
        );
        menu.unlimItemsLore = Arrays.asList(
                "",
                "#ddddddЦена за #a9e3ffх1: #53fb31$%price-x1% &7(ЛКМ)",
                "#ddddddЦена за #a9e3ffх64: #53fb31$%price-x64% &7(ПКМ)",
                "",
                "#ddddddЦена за #a9e3ffвсё: #53fb31$%price-all% &7(СКМ)",
                "",
                "#ddddddПредметы &aне ограничены&f!",
                "#ff4141ВНИМАНИЕ! #ddddddЦена занижена!"
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

        config.timezone = "Europe/Moscow";
        config.metrics = true;
        config.middleClickSellAll = true;
        config.prioritySellInv = "LIMITED";
        config.enablePermission = false;
        config.understatingPriceEnable = true;
        config.understatingPricePercent = 0.5;
        config.understatingPriceMinPercent = 50;
        config.timeFormat = "hhч. mmм. ssс.";
        config.sellInventory = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddВы успешно продали &eсвой инвентарь. #ddddddРезультаты продажи: &e%amount% #ddddddза #53fb31$%price%!";
        config.sell = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddВы успешно продали &e%item% %amount% #ddddddза #53fb31$%price%!";
        config.limit = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141Ваш лимит на продажу этого предмета исчерпан! Приходите в другой раз.";
        config.amount = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141Недостаточно предметов.";
        config.limitedUpdateCast = Arrays.asList(
                "",
                "#ddddddСкупщик с лимитом обновился! - #00d328/seller",
                ""
        );
        config.unlimitedUpdateCast = Arrays.asList(
                "",
                "#ddddddСкупщик без лимита обновился! - #00d328/seller",
                ""
        );
        config.updateCast = Arrays.asList(
                "",
                "#ddddddСкупщик полностью обновился! - #00d328/seller",
                ""
        );
        config.permission = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141У Вас нет прав.";
        config.reload = "&aКонфигурация успешно перезагружена!";
        config.update = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #00d328Список продаваемых предметов успешно обновлен!";
        config.added = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddПредмет #eaff43%item% #ddddddуспешно добавлен в список товаров. Его цена колеблится от #53fb31$%min-price% #ddddddдо #53fb31$%max-price%#dddddd за штуку.";
        config.addlimitedUse = "&cИспользование: /primeseller addlimited (мин. цена) (макс. цена) за шт. (Держите предмет в руке) - Добавить предмет в продажу.";
        config.addunlimitedUse = "&cИспользование: /primeseller addunlimited (мин. цена) (макс. цена) за шт. (Держите предмет в руке) - Добавить предмет в продажу.";
        config.updateUse = "&cИспользование: /primeseller update - Обновить список торгов";
    }
}