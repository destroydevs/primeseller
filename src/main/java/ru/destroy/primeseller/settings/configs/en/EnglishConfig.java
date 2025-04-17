package ru.destroy.primeseller.settings.configs.en;

import ru.leymooo.annotatedyaml.Annotations.*;
import ru.leymooo.annotatedyaml.Configuration;

import java.util.List;

public class EnglishConfig extends Configuration {

    @Key("time-zone")
    @Comment({"Time zone setting"})
    private String timeZone = "Europe/Berlin";

    @Key("metrics")
    @Comment({"Plugin metrics"})
    private boolean metrics = true;

    @Key("middle-click-sell-all")
    @Comment({"Sell all items with middle mouse button. If false, sell with Shift+Left-click"})
    private boolean middleClickSellAll = true;

    @Key("inv-sell-priority")
    private String invSellPriority = "LIMITED";

    @Key("enable-permission")
    @Comment({"Enable permission to use the command? primeseller.open"})
    private boolean enablePermission = false;

    private UnderstatingPriceConfig understatingPrice = new UnderstatingPriceConfig();

    @Key("time-format")
    @Comment({"Time format"})
    private String timeFormat = "hhhrs. mmmin. sssec.";

    private MessagesConfig messages = new MessagesConfig();

    @Key("understating-price")
    @Comment({"Enable price reduction on sale",
            "(percent = Percentage by which the price will be reduced on sale)",
            "(min-percent = Minimum percentage of the amount)"})
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
        private String sellInventory = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddYou have successfully sold your inventory. #ddddddSale results: &e%amount% #ddddddfor #53fb31$%price%!";

        @Key("sell")
        private String sell = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddYou have successfully sold &e%item% %amount% #ddddddfor #53fb31$%price%!";

        @Key("limit")
        private String limit = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141Your limit for selling this item has been exhausted! Come back another time.";

        @Key("amount")
        private String amount = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141Not enough items.";

        @Key("limited-update-cast")
        private List<String> limitedUpdateCast = List.of("", "#ddddddThe buyer with a limit has been updated! - #00d328/seller", "");

        @Key("unlimited-update-cast")
        private List<String> unlimitedUpdateCast = List.of("", "#ddddddThe buyer without a limit has been updated! - #00d328/seller", "");

        @Key("update-cast")
        private List<String> updateCast = List.of("", "#ddddddThe buyer has been fully updated! - #00d328/seller", "");

        private CommandsMessages commands = new CommandsMessages();

        @Key("commands")
        public static class CommandsMessages {
            @Key("permission")
            private String permission = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ff4141You do not have permission.";

            @Key("reload")
            private String reload = "&aConfiguration successfully reloaded!";

            @Key("update")
            private String update = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #00d328The list of items for sale has been successfully updated!";

            @Key("added")
            private String added = "#5637bc&lS#623ec9&lE#6e44d7&lL#7a4be4&lL#8651f2&lE#9258ff&lR #b9b9b9| #ddddddItem #eaff43%item% #ddddddhas been successfully added to the list of goods. Its price ranges from #53fb31$%min-price% #ddddddto #53fb31$%max-price%#dddddd per piece.";

            @Key("addlimited-use")
            private String addLimitedUse = "&cUsage: /primeseller addlimited (min. price) (max. price) per piece (Hold the item in your hand) - Add an item for sale.";

            @Key("addunlimited-use")
            private String addUnlimitedUse = "&cUsage: /primeseller addunlimited (min. price) (max. price) per piece (Hold the item in your hand) - Add an item for sale.";

            @Key("update-use")
            private String updateUse = "&cUsage: /primeseller update - Update the list of trades";

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