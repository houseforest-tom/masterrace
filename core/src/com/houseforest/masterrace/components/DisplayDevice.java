package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class DisplayDevice extends Component {

    public DisplayDevice(int level, String name, double performance) {
        super(Component.DISPLAY, level, name, performance);
    }

    @Override
    public DisplayDevice clone() {
        return new DisplayDevice(getLevel(), getName(), getPerformance());
    }

    @Override
    public String constructDisplayString() {
        return "Refresh Rate: " + Formatter.formatUnit(getRank(), "Hz");
    }
}
