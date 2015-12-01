package com.houseforest.masterrace.components;

/**
 * Created by Tom on 30.11.2015.
 */
public class Mainboard extends Component {

    public Mainboard(int level, String name, double performance) {
        super(Component.MAINBOARD, level, name, performance);
    }

    @Override
    public Mainboard clone() {
        return new Mainboard(getLevel(), getName(), getPerformance());
    }

    @Override
    public double calculateMetric(double performance) {
        double slowdown = 1E3;
        double stability = 100 * (1.0 - Math.exp((1 - performance) / slowdown));
        return stability;
    }

    @Override
    public String constructDisplayString() {
        return "Stability: " + String.format("%.4f", calculateMetric(getPerformance())) + "%";
    }
}
