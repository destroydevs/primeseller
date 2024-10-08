package ru.spigotmc.destroy.primeseller.locale;

import ru.spigotmc.destroy.primeseller.locale.reflect.Comment;
import ru.spigotmc.destroy.primeseller.locale.reflect.CommentType;
import ru.spigotmc.destroy.primeseller.locale.reflect.Path;

import java.util.Arrays;
import java.util.List;

public class RussianLocale {

    public static class Menu {
        @Path(path = "title")
        @Comment(comment = "тайтл в меню")
        public String title = "Скупщик предметов";

        @Path(path = "size")
        @Comment(comment = "кол-во слотов")
        public int size = 54;

        @Path(path = "sell-inventory.material")
        @Comment(comment = "материал для продажи инвентаря")
        public String sellInventoryMaterial = "CHEST";

        @Path(path = "sell-inventory.model-data")
        @Comment(comment = "модель данных для продажи инвентаря")
        public int sellInventoryModelData = 0;

        @Path(path = "sell-inventory.name")
        @Comment(comment = "имя для продажи инвентаря")
        public String sellInventoryName = "&aПродать инвентарь";

        @Path(path = "sell-inventory.lore")
        @Comment(comment = "описание для продажи инвентаря")
        public List<String> sellInventoryLore = Arrays.asList("");

        @Path(path = "sell-inventory.slots")
        @Comment(comment = "слоты для продажи инвентаря")
        public List<Integer> sellInventorySlots = Arrays.asList(49);

        @Path(path = "exit.material")
        @Comment(comment = "материал для выхода")
        public String exitMaterial = "RED_STAINED_GLASS_PANE";

        @Path(path = "exit.model-data")
        @Comment(comment = "модель данных для выхода")
        public int exitModelData = 0;

        @Path(path = "exit.name")
        @Comment(comment = "имя для выхода")
        public String exitName = "#ff4141Закрыть";

        @Path(path = "exit.commands")
        @Comment(comment = "команды для выхода")
        public List<String> exitCommands = Arrays.asList("[close]", "[cmd] menu");

        @Path(path = "exit.slots")
        @Comment(comment = "слоты для выхода")
        public List<Integer> exitSlots = Arrays.asList(45, 53);

        @Path(path = "countdown.material")
        @Comment(comment = "материал для обратного отсчета")
        public String countdownMaterial = "basehead-eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzZjMGQwNDU5YzY3ZjJiZTgyZmJlNTQwNmFiOGQxMzc4ZGExZjI4ZjdhM2Y4MmYxZGZjNDc2MTVhOTU1YTcifX19";

        @Path(path = "countdown.model-data")
        @Comment(comment = "модель данных для обратного отсчета")
        public int countdownModelData = 0;

        @Path(path = "countdown.name")
        @Comment(comment = "имя для обратного отсчета")
        public String countdownName = "#ddddddДо след обновления:";

        @Path(path = "countdown.lore")
        @Comment(comment = "описание для обратного отсчета")
        public List<String> countdownLore = Arrays.asList(
                "",
                "#ddddddОбновление лимитированного скупщика через:",
                "#eaff43> #7348dd%lim-time% &7|&8 %lim-time-format%",
                "",
                "#ddddddОбновление скупщика без лимита через:",
                "#eaff43> #7348dd%unlim-time% &7|&8 %unlim-time-format%",
                ""
        );

        @Path(path = "countdown.slots")
        @Comment(comment = "слоты для обратного отсчета")
        public List<Integer> countdownSlots = Arrays.asList(4);

        @Path(path = "lim-items.lore")
        @Comment(comment = "описание для ограниченных предметов")
        public List<String> limItemsLore = Arrays.asList(
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

        @Path(path = "lim-items.slots")
        @Comment(comment = "слоты для ограниченных предметов")
        public List<Integer> limItemsSlots = Arrays.asList(
                9, 10, 11, 12, 18, 19, 20, 21, 27, 28, 29, 30, 36, 37, 38, 39
        );

        @Path(path = "unlim-items.lore")
        @Comment(comment = "описание для неограниченных предметов")
        public List<String> unlimItemsLore = Arrays.asList(
                "",
                "#ddddddЦена за #a9e3ffх1: #53fb31$%price-x1% &7(ЛКМ)",
                "#ddddddЦена за #a9e3ffх64: #53fb31$%price-x64% &7(ПКМ)",
                "",
                "#ddddddЦена за #a9e3ffвсё: #53fb31$%price-all% &7(СКМ)",
                "",
                "#ddddddПредметы &aне ограничены&f!",
                "#ff4141ВНИМАНИЕ! #ddddddЦена занижена!"
        );

        @Path(path = "unlim-items.slots")
        @Comment(comment = "слоты для неограниченных предметов")
        public List<Integer> unlimItemsSlots = Arrays.asList(
                14, 15, 16, 17, 23, 24, 25, 26, 32, 33, 34, 35, 41, 42, 43, 44
        );

        @Path(path = "divider.your_name.material")
        @Comment(comment = "материал для разделителя")
        public String dividerMaterial = "BLACK_STAINED_GLASS_PANE";

        @Path(path = "divider.your_name.model-data")
        @Comment(comment = "модель данных для разделителя")
        public int dividerModelData = 0;

        @Path(path = "divider.your_name.name")
        @Comment(comment = "имя для разделителя")
        public String dividerName = "&7";

        @Path(path = "divider.your_name.slots")
        @Comment(comment = "слоты для разделителя")
        public List<Integer> dividerSlots = Arrays.asList(
                0, 1, 2, 3, 5, 6, 7, 8, 13, 22, 31, 40, 49, 48, 47, 46, 50, 51, 52
        );
    }

    public static class Config {
        @Path(path = "time-zone")
        @Comment(comment = "GMT+3 стандарт")
        public String timezone = "GMT+3";

        @Path(path = "metrics")
        @Comment(comment = "метрика плагина")
        public boolean metrics = true;

        @Path(path = "middle-click-sell-all")
        @Comment(comment = "продажа на среднюю кнопку мыши. Если false продаётся через ШИФТ+ЛКМ")
        public boolean middleClickSellAll = true;

        @Path(path = "inv-sell-priority")
        @Comment(comment = "Приоритет продажи инвентаря скупщику. UNLIMITED - сначала нелимитированные, LIMITED - сначала лимитированные.", type = CommentType.ABOVE)
        public String prioritySellInv = "LIMITED";

        @Path(path = "enable-permission")
        @Comment(comment = "включить ли право на использование команды? primeseller.open")
        public boolean enablePermission = false;

        @Path(path = "understating-price")
        @Comment(comment = "Включить снижение цены при продаже \n# (percent = Процент, на который будет снижена цена при продаже)\n# (min-percent = Минимальный процент от суммы)", type = CommentType.ABOVE)
        public String understanding = null;

        @Path(path = "understating-price.enable")
        @Comment(comment = "включить ли снижение цены при продаже")
        public boolean understatingPriceEnable = true;

        @Path(path = "understating-price.percent")
        @Comment(comment = "на сколько % будет понижаться цена при продаже")
        public double understatingPricePercent = 0.5;

        @Path(path = "understating-price.min-percent")
        @Comment(comment = "минимальный % от суммы")
        public int understatingPriceMinPercent = 50;

        @Path(path = "time-format")
        @Comment(comment = "формат времени")
        public String timeFormat = "hhч. mmм. ssс.";

        @Path(path = "messages.sell-inventory")
        @Comment(comment = "сообщение при продаже инвентаря")
        public String sellInventory = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddВы успешно продали &eсвой инвентарь. #ddddddРезультаты продажи: &e%amount% #ddddddза #53fb31$%price%!";

        @Path(path = "messages.sell")
        @Comment(comment = "сообщение при продаже предмета")
        public String sell = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddВы успешно продали &e%item% %amount% #ddddddза #53fb31$%price%!";

        @Path(path = "messages.limit")
        @Comment(comment = "сообщение при достижении лимита продажи")
        public String limit = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141Ваш лимит на продажу этого предмета исчерпан! Приходите в другой раз.";

        @Path(path = "messages.amount")
        @Comment(comment = "сообщение при недостаточном количестве предметов")
        public String amount = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141Недостаточно предметов.";

        @Path(path = "messages.limited-update-cast")
        @Comment(comment = "сообщение при обновлении скупщика с лимитом")
        public List<String> limitedUpdateCast = Arrays.asList(
                "",
                "#ddddddСкупщик с лимитом обновился! - #00d328/seller",
                ""
        );

        @Path(path = "messages.unlimited-update-cast")
        @Comment(comment = "сообщение при обновлении скупщика без лимита")
        public List<String> unlimitedUpdateCast = Arrays.asList(
                "",
                "#ddddddСкупщик без лимита обновился! - #00d328/seller",
                ""
        );

        @Path(path = "messages.update-cast")
        @Comment(comment = "сообщение при полном обновлении скупщика")
        public List<String> updateCast = Arrays.asList(
                "",
                "#ddddddСкупщик полностью обновился! - #00d328/seller",
                ""
        );

        @Path(path = "messages.commands.permission")
        @Comment(comment = "сообщение при отсутствии прав")
        public String permission = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141У Вас нет прав.";

        @Path(path = "messages.commands.reload")
        @Comment(comment = "сообщение при перезагрузке конфигурации")
        public String reload = "&aКонфигурация успешно перезагружена!";

        @Path(path = "messages.commands.update")
        @Comment(comment = "сообщение при обновлении списка продаваемых предметов")
        public String update = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #00d328Список продаваемых предметов успешно обновлен!";

        @Path(path = "messages.commands.added")
        @Comment(comment = "сообщение при добавлении предмета в список товаров")
        public String added = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddПредмет #eaff43%item% #ddddddуспешно добавлен в список товаров. Его цена колеблится от #53fb31$%min-price% #ddddddдо #53fb31$%max-price%#dddddd за штуку.";

        @Path(path = "messages.commands.addlimited-use")
        @Comment(comment = "сообщение о использовании команды для добавления ограниченного предмета")
        public String addlimitedUse = "&cИспользование: /primeseller addlimited (мин. цена) (макс. цена) за шт. (Держите предмет в руке) - Добавить предмет в продажу.";

        @Path(path = "messages.commands.addunlimited-use")
        @Comment(comment = "сообщение о использовании команды для добавления неограниченного предмета")
        public String addunlimitedUse = "&cИспользование: /primeseller addunlimited (мин. цена) (макс. цена) за шт. (Держите предмет в руке) - Добавить предмет в продажу.";

        @Path(path = "messages.commands.update-use")
        @Comment(comment = "сообщение о использовании команды для обновления списка торгов")
        public String updateUse = "&cИспользование: /primeseller update - Обновить список торгов";
    }
}

