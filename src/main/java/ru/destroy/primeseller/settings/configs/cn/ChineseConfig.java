package ru.destroy.primeseller.settings.configs.cn;

import ru.leymooo.annotatedyaml.Annotations.*;
import ru.leymooo.annotatedyaml.Configuration;

import java.util.List;

public class ChineseConfig extends Configuration {

    @Key("time-zone")
    @Comment({"Translated by AI.","时区设置"})
    private String timeZone = "Asia/Shanghai";

    @Key("metrics")
    @Comment({"插件指标收集"})
    private boolean metrics = true;

    @Key("middle-click-sell-all")
    @Comment({"使用鼠标中键一键出售。如果设为false，则使用SHIFT+左键出售"})
    private boolean middleClickSellAll = true;

    @Key("inv-sell-priority")
    private String invSellPriority = "LIMITED";

    @Key("enable-permission")
    @Comment({"是否启用权限控制？primeseller.open"})
    private boolean enablePermission = false;

    private UnderstatingPriceConfig understatingPrice = new UnderstatingPriceConfig();

    @Key("time-format")
    @Comment({"时间格式"})
    private String timeFormat = "hh时 mm分 ss秒";

    private MessagesConfig messages = new MessagesConfig();

    @Key("understating-price")
    @Comment({"启用出售时价格递减",
            "(percent = 每次出售价格降低的百分比)",
            "(min-percent = 最低价格百分比)"})
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
        private String sellInventory = "#5637bc&l出#623ec9&l售#6e44d7&l成#7a4be4&l功#8651f2&l！ #b9b9b9| #dddddd您成功出售了所有物品 获得：&e%amount% #dddddd件 总计：#53fb31$%price%!";

        @Key("sell")
        private String sell = "#5637bc&l出#623ec9&l售#6e44d7&l成#7a4be4&l功#8651f2&l！ #b9b9b9| #dddddd您成功出售了 &e%item% %amount% #dddddd件 获得：#53fb31$%price%!";

        @Key("limit")
        private String limit = "#5637bc&l出#623ec9&l售#6e44d7&l错#7a4be4&l误#8651f2&l！ #b9b9b9| #ff4141该物品的出售限额已用尽！请稍后再试。";

        @Key("amount")
        private String amount = "#5637bc&l出#623ec9&l售#6e44d7&l错#7a4be4&l误#8651f2&l！ #b9b9b9| #ff4141物品数量不足。";

        @Key("limited-update-cast")
        private List<String> limitedUpdateCast = List.of("", "#dddddd限时商人已刷新！ - #00d328/seller", "");

        @Key("unlimited-update-cast")
        private List<String> unlimitedUpdateCast = List.of("", "#dddddd无限商人已刷新！ - #00d328/seller", "");

        @Key("update-cast")
        private List<String> updateCast = List.of("", "#dddddd商人列表已全面刷新！ - #00d328/seller", "");

        private CommandsMessages commands = new CommandsMessages();

        @Key("commands")
        public static class CommandsMessages {
            @Key("permission")
            private String permission = "#5637bc&l权#623ec9&l限#6e44d7&l不#7a4be4&l足#8651f2&l！ #b9b9b9| #ff4141您没有执行此操作的权限。";

            @Key("reload")
            private String reload = "&a配置重载成功！";

            @Key("update")
            private String update = "#5637bc&l更#623ec9&l新#6e44d7&l成#7a4be4&l功#8651f2&l！ #b9b9b9| #00d328出售列表已成功更新！";

            @Key("added")
            private String added = "#5637bc&l物#623ec9&l品#6e44d7&l添#7a4be4&l加#8651f2&l！ #b9b9b9| #dddddd物品 #eaff43%item% #dddddd已加入出售列表 单价范围：#53fb31$%min-price% #dddddd至 #53fb31$%max-price%#dddddd。";

            @Key("addlimited-use")
            private String addLimitedUse = "&c用法: /primeseller addlimited (最低价) (最高价) (手持物品) - 添加限时收购物品";

            @Key("addunlimited-use")
            private String addUnlimitedUse = "&c用法: /primeseller addunlimited (最低价) (最高价) (手持物品) - 添加无限收购物品";

            @Key("update-use")
            private String updateUse = "&c用法: /primeseller update - 更新商人列表";

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