package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by zumbabine on 24.12.2015.
 */
public class PoweredComponent extends Component {

    // Power consumption.
    private double powerConsumption;

    public PoweredComponent(int type, double powerConsumption) {
        super(type);
        this.powerConsumption = powerConsumption;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption){
        this.powerConsumption = powerConsumption;
    }

    protected String constructPowerConsumptionString(){
        return "Power Consumption: " + Formatter.formatUnit(getPowerConsumption(), "W");
    }
}
