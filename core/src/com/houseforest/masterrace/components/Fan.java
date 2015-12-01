package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Fan extends Component {

    public Fan(int level, String name, double performance) {
        super(Component.FAN, level, name, performance);
    }

    @Override
    public Fan clone() {
        return new Fan(getLevel(), getName(), getPerformance());
    }

    @Override
    public String constructDisplayString() {
        return "Speed: " + Formatter.formatUnit(calculateMetric(getPerformance()), "RPM");
    }
}
