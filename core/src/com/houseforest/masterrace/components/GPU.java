package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class GPU extends Component {

    public GPU(int level, String name, double performance) {
        super(Component.GPU, level, name, performance);
    }

    @Override
    public com.houseforest.masterrace.components.GPU clone() {
        return new GPU(getLevel(), getName(), getPerformance());
    }

    @Override
    public String constructDisplayString() {
        return "Core Clock: " + Formatter.formatUnit(calculateMetric(getPerformance()), "Hz");
    }
}
