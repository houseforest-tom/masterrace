package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Fan extends PoweredComponent {

    // Fan RPM.
    private double rpm;

    // Fan diameter.
    private double diameter;

    public Fan(double rpm, double diameter, double powerConsumption) {
        super(Component.FAN, powerConsumption);
        this.rpm = rpm;
        this.diameter = diameter;
    }

    @Override
    public Fan clone() {
        return new Fan(rpm, diameter, getPowerConsumption());
    }

    @Override
    public String constructDisplayString() {
        String str = "";
        str += "Speed: " + Formatter.formatUnit(rpm, "RPM") + "\n";
        str += "Diameter: " + Formatter.formatUnit(diameter, "m") + "\n";
        str += constructPowerConsumptionString();
        return str;
    }
}
