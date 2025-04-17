package ru.destroy.primeseller.settings.configs.ru;

import ru.leymooo.annotatedyaml.Annotations.*;
import ru.leymooo.annotatedyaml.Configuration;

import java.util.List;

public class RussianConfig extends Configuration {

    @Key("time-zone")
    @Comment({"Настройки таймзоны"})
    private String timeZone = "Europe/Moscow";

    @Key("metrics")
    @Comment({"метрика плагина"})
    private boolean metrics = true;

    @Key("middle-click-sell-all")
    @Comment({"продажа на среднюю кнопку мыши. Если false продаётся через ШИФТ+ЛКМ"})
    private boolean middleClickSellAll = true;

    @Key("inv-sell-priority")
    private String invSellPriority = "LIMITED";

    @Key("enable-permission")
    @Comment({"включить ли право на использование команды? primeseller.open"})
    private boolean enablePermission = false;

    private UnderstatingPriceConfig understatingPrice = new UnderstatingPriceConfig();

    @Key("time-format")
    @Comment({"формат времени"})
    private String timeFormat = "hhч. mmм. ssс.";

    private MessagesConfig messages = new MessagesConfig();

    @Key("understating-price")
    @Comment({"Включить снижение цены при продаже",
            "(percent = Процент, на который будет снижена цена при продаже)",
            "(min-percent = Минимальный процент от суммы)"})
    public static class UnderstatingPriceConfig {
        @Key("enable")
        private boolean enable = true;

        @Key("percent")
        private double percent = 0.50;

        @Key("min-percent")
        private int minPercent = 50;
    }

    @Key("messages")
    public static class MessagesConfig {
        @Key("sell-inventory")
        private String sellInventory = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddВы успешно продали &eсвой инвентарь. #ddddddРезультаты продажи: &e%amount% #ddddddза #53fb31$%price%!";

        @Key("sell")
        private String sell = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddВы успешно продали &e%item% %amount% #ddddddза #53fb31$%price%!";

        @Key("limit")
        private String limit = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141Ваш лимит на продажу этого предмета исчерпан! Приходите в другой раз.";

        @Key("amount")
        private String amount = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141Недостаточно предметов.";

        @Key("limited-update-cast")
        private List<String> limitedUpdateCast = List.of("", "#ddddddСкупщик с лимитом обновился! - #00d328/seller", "");

        @Key("unlimited-update-cast")
        private List<String> unlimitedUpdateCast = List.of("", "#ddddddСкупщик без лимита обновился! - #00d328/seller", "");

        @Key("update-cast")
        private List<String> updateCast = List.of("", "#ddddddСкупщик полностью обновился! - #00d328/seller", "");

        private CommandsMessages commands = new CommandsMessages();

        @Key("commands")
        public static class CommandsMessages {
            @Key("permission")
            private String permission = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141У Вас нет прав.";

            @Key("reload")
            private String reload = "&aКонфигурация успешно перезагружена!";

            @Key("update")
            private String update = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #00d328Список продаваемых предметов успешно обновлен!";

            @Key("added")
            private String added = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddПредмет #eaff43%item% #ddddddуспешно добавлен в список товаров. Его цена колеблится от #53fb31$%min-price% #ddddddдо #53fb31$%max-price%#dddddd за штуку.";

            @Key("addlimited-use")
            private String addLimitedUse = "&cИспользование: /primeseller addlimited (мин. цена) (макс. цена) за шт. (Держите предмет в руке) - Добавить предмет в продажу.";

            @Key("addunlimited-use")
            private String addUnlimitedUse = "&cИспользование: /primeseller addunlimited (мин. цена) (макс. цена) за шт. (Держите предмет в руке) - Добавить предмет в продажу.";

            @Key("update-use")
            private String updateUse = "&cИспользование: /primeseller update - Обновить список торгов";

            public String getPermission() {
                return permission;
            }

            public String getReload() {
                return reload;
            }

            public String getUpdate() {
                return update;
            }

            public String getAdded() {
                return added;
            }

            public String getAddLimitedUse() {
                return addLimitedUse;
            }

            public String getAddUnlimitedUse() {
                return addUnlimitedUse;
            }

            public String getUpdateUse() {
                return updateUse;
            }
        }

        public String getSellInventory() {
            return sellInventory;
        }

        public String getSell() {
            return sell;
        }

        public String getLimit() {
            return limit;
        }

        public String getAmount() {
            return amount;
        }

        public List<String> getLimitedUpdateCast() {
            return limitedUpdateCast;
        }

        public List<String> getUnlimitedUpdateCast() {
            return unlimitedUpdateCast;
        }

        public List<String> getUpdateCast() {
            return updateCast;
        }

        public CommandsMessages getCommands() {
            return commands;
        }
    }

    public String getTimeZone() {
        return timeZone;
    }

    public boolean isMetrics() {
        return metrics;
    }

    public boolean isMiddleClickSellAll() {
        return middleClickSellAll;
    }

    public String getInvSellPriority() {
        return invSellPriority;
    }

    public boolean isEnablePermission() {
        return enablePermission;
    }

    public UnderstatingPriceConfig getUnderstatingPrice() {
        return understatingPrice;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public MessagesConfig getMessages() {
        return messages;
    }
}
