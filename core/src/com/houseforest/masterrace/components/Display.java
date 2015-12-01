package com.houseforest.masterrace.components;

/**
 * Created by Tom on 30.11.2015.
 */
public class Display extends Component {

    public Display(int level, String name, double performance) {
        super(Component.DISPLAY, level, name, performance);
    }

    @Override
    public Display clone() {
        return new Display(getLevel(), getName(), getPerformance());
    }

    @Override
    public double calculateMetric(double performance) {
        // Pixel count.
        return 16 * 9 * performance;
    }

    @Override
    public String constructDisplayString() {
        double pixels = calculateMetric(getPerformance());
        int xpx = (int) Math.ceil(pixels / 9);
        int ypx = (int) Math.ceil(pixels / 16);
        return "Resolution: " + xpx + "x" + ypx + "px";
    }
}
