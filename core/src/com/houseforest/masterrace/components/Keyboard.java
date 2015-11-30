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
    public String constructDisplayString() {
        double slowdown = 1E3;
        double latency = 0.01E-24 + (60 - 0.01E-24) * Math.exp((1 - getRank()) / slowdown);
        return "Latency: " + Formatter.formatUnit(latency, "s");
    }
}
