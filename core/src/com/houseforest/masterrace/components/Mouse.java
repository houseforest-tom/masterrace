package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Mouse extends Component {

    public Mouse(int level, String name, double performance) {
        super(Component.MOUSE, level, name, performance);
    }

    @Override
    public Mouse clone() {
        return new Mouse(getLevel(), getName(), getPerformance());
    }

    @Override
    public String constructDisplayString() {
        return "Precision: " + Formatter.formatUnit(calculateMetric(getPerformance()), "dpi");
    }
}
