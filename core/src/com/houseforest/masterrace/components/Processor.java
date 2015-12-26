package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Processor extends PoweredComponent {

    // Core count.
    private long cores;

    // Frequency.
    private double freq;

    // Cache size in bytes.
    // private long cache;

    public Processor(long cores, double freq, double powerConsumption) {
        super(Component.CPU, powerConsumption);
        this.freq = freq;
        this.cores = cores;
    }

    public double getFrequency() {
        return freq;
    }

    public long getCoreCount() {
        return cores;
    }

    @Override
    public Processor clone() {
        return new Processor(cores, freq, getPowerConsumption());
    }

    @Override
    public String constructDisplayString() {
        String str = "";
        str += "Cores: " + cores + "\n";
        str += "Frequency: " + Formatter.formatUnit(freq, "Hz") + "\n";
        str += constructPowerConsumptionString();
        return str;
    }
}
