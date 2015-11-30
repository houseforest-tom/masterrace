package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Processor extends Component {

    public Processor(int level, String name, double performance) {
        super(Component.PROCESSOR, level, name, performance);
    }

    @Override
    public Processor clone() {
        return new Processor(getLevel(), getName(), getPerformance());
    }

    @Override
    public String constructDisplayString() {
        return "Overclock: " + Formatter.formatUnit(getRank(), "Hz");
    }
}
