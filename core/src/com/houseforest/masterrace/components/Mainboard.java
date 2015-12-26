package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

import java.text.Normalizer;

/**
 * Created by Tom on 30.11.2015.
 */
public class Mainboard extends PoweredComponent {

    // CPU socket version.
    private long cpuSocketVersion;

    // Max. RAM capacity.
    private long maxRam;

    public Mainboard(long socket, long maxRam, double powerConsumption) {
        super(Component.MAINBOARD, powerConsumption);
        cpuSocketVersion = socket;
        this.maxRam = maxRam;
    }

   public long getCpuSocketVersion(){
       return cpuSocketVersion;
   }

    public void setCpuSocketVersion(long cpuSocketVersion){
        this.cpuSocketVersion = cpuSocketVersion;
    }

    public long getMaxRAM(){
        return maxRam;
    }

    public void setMaxRAM(long maxRam){
        this.maxRam = maxRam;
    }

    @Override
    public Mainboard clone() {
        return new Mainboard(cpuSocketVersion, maxRam, getPowerConsumption());
    }

    @Override
    public String constructDisplayString() {
        String str = "";
        str += "CPU Socket Version: " + cpuSocketVersion+ "\n";
        str += "Max. Memory: " + Formatter.formatUnit(maxRam, "B") + "\n";
        str += constructPowerConsumptionString();
        return str;
    }
}
