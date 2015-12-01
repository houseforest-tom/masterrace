package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Cooler extends Component {

    public Cooler(int level, String name, double performance) {
        super(Component.COOLER, level, name, performance);
    }

    @Override
    public Cooler clone() {
        return new Cooler(getLevel(), getName(), getBasePerformance());
    }

    @Override
    public double calculateMetric(double performance) {
        // performance = 1.0    => temperature = 100°C
        // performance -> inf   => temperature -> -273.15°C
        double slowdown = 1E3;
        return -273.15 + (100.00 + 273.15) * Math.exp((1 - performance) / slowdown);
    }

    @Override
    public String constructDisplayString() {
        return "Temperature: " + Formatter.formatUnit(calculateMetric(getPerformance()), "°C");
    }
}
