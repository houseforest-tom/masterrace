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
    public String constructDisplayString() {
        double slowdown = 1E3;
        double stability = 100 * (1.0 - Math.exp((1-getRank()) / slowdown));
        return "Stability: " + String.format("%.4f", stability) + "%";
    }
}
