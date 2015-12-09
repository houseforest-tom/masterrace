package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Fan extends Component {

    // Fan RPM.
    private double rpm;

    public Fan(double rpm) {
        super(Component.FAN);
        this.rpm = rpm;
    }

    @Override
    public Fan clone() {
        return new Fan(rpm);
    }

    @Override
    public String constructDisplayString() {
        return "Speed: " + Formatter.formatUnit(rpm, "RPM");
    }
}
