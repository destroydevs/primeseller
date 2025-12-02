package me.byteswing.primeseller.util;

import me.byteswing.primeseller.configurations.Config;
import me.byteswing.primeseller.configurations.database.MapBase;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Understating {

    public static final HashMap<Integer, Double> standardPrice = new HashMap<>();

    private static final DecimalFormat format = new DecimalFormat("#.##");

    public static void takePrice(int item, int count) {
        if(Config.getConfig().getBoolean("understating-price.enable")) {
            MapBase h2 = new MapBase();
            if(!standardPrice.containsKey(item)) {
                standardPrice.put(item, h2.getPrice(item));
            }
            double d = Double.parseDouble(format.format(h2.getPrice(item) / 100 * Double.parseDouble(Config.getConfig().getString("understating-price.percent").replace(",", "."))).replace(",", "."));
            double s = d*count;
            double max = h2.getPrice(item)*100/standardPrice.get(item);
            int percent = Config.getConfig().getInt("understating-price.min-percent");
            double sum = standardPrice.get(item)/100*percent;

            if (max > percent) {
                if(s > sum) {
                    h2.setPrice(item, sum);
                } else {
                    h2.takePrice(item, s);
                }
            }
        }
    }

}
