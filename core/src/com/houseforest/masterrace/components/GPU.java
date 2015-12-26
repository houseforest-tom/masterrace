package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class GPU extends PoweredComponent {

    // Video memory.
    private long vram;

    // Core clock frequency.
    private double frequency;

    public GPU(long vram, double frequency, double powerConsumption) {
        super(Component.GPU, powerConsumption);
        this.vram = vram;
        this.frequency = frequency;
    }

    public long getVRAM(){
        return vram;
    }

    public void setVRAM(long vram){
        this.vram = vram;
    }

    public double getFrequency(){
        return frequency;
    }

    public void setFrequency(double frequency){
        this.frequency = frequency;
    }

    @Override
    public com.houseforest.masterrace.components.GPU clone() {
        return new GPU(vram, frequency, getPowerConsumption());
    }

    @Override
    public String constructDisplayString() {
        String str = "";
        str += "Video Memory: " + Formatter.formatUnit(vram, "B") + "\n";
        str += "Core Frequency: " + Formatter.formatUnit(frequency, "Hz") + "\n";
        str += constructPowerConsumptionString();
        return str;
    }
}
