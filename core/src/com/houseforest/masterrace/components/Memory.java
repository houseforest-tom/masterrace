package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Memory extends Component {

    public Memory(int level, String name, double performance) {
        super(Component.RAM, level, name, performance);
    }

    @Override
    public Memory clone() {
        return new Memory(getLevel(), getName(), getPerformance());
    }

    @Override
    public String constructDisplayString() {
        String fmt = Formatter.formatUnit(calculateMetric(getPerformance()), "B");
        return "Size: " + fmt;
    }
}
