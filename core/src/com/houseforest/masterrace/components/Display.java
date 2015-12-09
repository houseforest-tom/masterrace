package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Display extends Component {

    // Pixel count.
    private long pixels;

    // Refresh rate.
    private double hz;

    // Screen diagonal.
    private double diagonal;

    public Display(long pixels, double hz, double diagonal) {
        super(Component.DISPLAY);
        this.pixels = pixels;
        this.hz = hz;
        this.diagonal = diagonal;
    }

    public long getPixels() {
        return pixels;
    }

    public double getRefreshRate() {
        return hz;
    }

    public double getScreenDiagonal() {
        return diagonal;
    }

    @Override
    public Display clone() {
        return new Display(pixels, hz, diagonal);
    }

    @Override
    public String constructDisplayString() {
        String str = "";
        str += "Resolution: " + (long) Math.ceil(pixels / 9.0) + "x" + (long) Math.ceil(pixels / 16.0) + "p\n";
        str += "Refresh Rate: " + Formatter.formatUnit(hz, "Hz") + "\n";
        str += "Screen Diagonal: " + Formatter.formatUnit(diagonal, "m");
        return str;
    }
}
