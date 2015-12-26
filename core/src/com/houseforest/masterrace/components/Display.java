package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Display extends PoweredComponent {

    // Pixel count.
    private long pixels;

    // Refresh rate.
    private double hz;

    public Display(long pixels, double hz, double powerConsumption) {
        super(Component.DISPLAY, powerConsumption);
        this.pixels = pixels;
        this.hz = hz;
    }

    public long getPixels() {
        return pixels;
    }

    public double getRefreshRate() {
        return hz;
    }

    @Override
    public Display clone() {
        return new Display(pixels, hz, getPowerConsumption());
    }

    @Override
    public String constructDisplayString() {
        String str = "";
        str += "Resolution: " + (long) Math.ceil(pixels / 9.0) + "x" + (long) Math.ceil(pixels / 16.0) + " Pixels\n";
        str += "Refresh Rate: " + Formatter.formatUnit(hz, "Hz") + "\n";
        str += constructPowerConsumptionString();
        return str;
    }
}
