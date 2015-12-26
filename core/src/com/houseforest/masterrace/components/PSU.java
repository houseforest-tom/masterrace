package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

import java.text.Normalizer;

/**
 * Created by Tom on 30.11.2015.
 */
public class PSU extends Component {

    // Max. draw.
    private double power;

    // Efficiency (Percentage).
    private double efficiency;

    public PSU(double power, double efficiency) {
        super(Component.PSU);
        this.power = power;
        this.efficiency = efficiency;
    }

    public double getPower(){
        return power;
    }

    public void setPower(double power){
        this.power = power;
    }

    public double getEfficiency(){
        return efficiency;
    }

    public void setEfficiency(double efficiency){
        this.efficiency = efficiency;
    }

    @Override
    public PSU clone() {
        return new PSU(power, efficiency);
    }

    @Override
    public String constructDisplayString() {
        String str = "";
        str += "Power: " + Formatter.formatUnit(power, "W") + "\n";
        str += "Efficiency: " + Formatter.formatPercentage(efficiency);
        return str;
    }
}
