package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Workplace extends Component {

    public Workplace(int level, String name, double performance) {
        super(Component.WORKPLACE, level, name, performance);
    }

    @Override
    public Workplace clone() {
        return new Workplace(getLevel(), getName(), getPerformance());
    }

    @Override
    public String constructDisplayString() {
        return "Area: " + Formatter.formatUnit(getRank(), "m²");
    }
}
