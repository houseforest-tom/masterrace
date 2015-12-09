package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class PSU extends Component {

    private long power;

    public PSU(long power) {
        super(Component.PSU);
        this.power = power;
    }

    @Override
    public PSU clone() {
        return new PSU(power);
    }

    @Override
    public String constructDisplayString() {
        return "Max. Draw: " + Formatter.formatUnit(power, "W");
    }
}
