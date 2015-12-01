package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Keyboard extends Component {

    public Keyboard(int level, String name, double performance) {
        super(Component.KEYBOARD, level, name, performance);
    }

    @Override
    public Keyboard clone() {
        return new Keyboard(getLevel(), getName(), getPerformance());
    }

    @Override
    public double calculateMetric(double performance) {
        double slowdown = 1E3;
        double latency = 0.01E-24 + (60 - 0.01E-24) * Math.exp((1 - performance) / slowdown);
        return latency;
    }

    @Override
    public String constructDisplayString() {
        return "Latency: " + Formatter.formatUnit(calculateMetric(getPerformance()), "s");
    }
}
