package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Memory extends PoweredComponent {

    // Size in bytes.
    private long capacity;

    // Memory frequency.
    private double freq;

    public Memory(long capacity, double freq, double powerConsumption) {
        super(Component.RAM, powerConsumption);
        this.capacity = capacity;
        this.freq = freq;
    }

    public long getCapacity(){
        return capacity;
    }

    public double getFrequency(){
        return freq;
    }

    @Override
    public Memory clone() {
        return new Memory(capacity, freq, getPowerConsumption());
    }

    @Override
    public String constructDisplayString() {
        String str = "";
        str += "Capacity: " + Formatter.formatUnit(capacity, "B") + "\n";
        str += "Frequency: " + Formatter.formatUnit(freq, "Hz") + "\n";
        str += constructPowerConsumptionString();
        return str;
    }
}
