package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class PSU extends Component {

    public PSU(int level, String name, double performance) {
        super(Component.PSU, level, name, performance);
    }

    @Override
    public com.houseforest.masterrace.components.PSU clone() {
        return new PSU(getLevel(), getName(), getPerformance());
    }

    @Override
    public String constructDisplayString() {
        return "Max. Draw: " + Formatter.formatUnit(calculateMetric(getPerformance()), "W");
    }
}
