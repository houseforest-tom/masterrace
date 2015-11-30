package com.houseforest.masterrace.core;

import java.util.HashMap;

/**
 * Created by Tom on 30.11.2015.
 */
public class Formatter {

    private static HashMap<Integer, String> unitPrefixes;

    public static void init() {
        unitPrefixes = new HashMap<Integer, String>();
        unitPrefixes.put(-25, "y");
        unitPrefixes.put(-21, "z");
        unitPrefixes.put(-18, "a");
        unitPrefixes.put(-15, "f");
        unitPrefixes.put(-12, "p");
        unitPrefixes.put(-9, "n");
        unitPrefixes.put(-6, "µ");
        unitPrefixes.put(-3, "m");
        unitPrefixes.put(0, "");
        unitPrefixes.put(3, "k");
        unitPrefixes.put(6, "M");
        unitPrefixes.put(9, "G");
        unitPrefixes.put(12, "T");
        unitPrefixes.put(15, "P");
        unitPrefixes.put(18, "E");
        unitPrefixes.put(21, "Z");
        unitPrefixes.put(24, "Y");
    }

    public static String formatUnit(double value, String unit) {

        String valstr = String.format("%.2f", value);
        int order = 0;

        while (value <= 1E-3) {
            value *= 1E3;
            order -= 3;
        }
        while (value >= 1E3) {
            value /= 1E3;
            order += 3;
        }

        return valstr + unitPrefixes.get(Math.max(-24, Math.min(order, 24))) + unit;
    }
}
