package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Processor extends Component {

    // Core count.
    private long cores;

    // Frequency.
    private double freq;

    // Cache size in bytes.
    private long cache;

    public Processor(long cores, double freq, long cache) {
        super(Component.CPU);
        this.freq = freq;
        this.cores = cores;
        this.cache = cache;
    }

    public double getFrequency() {
        return freq;
    }

    public long getCoreCount() {
        return cores;
    }

    public long getCacheSize() {
        return cache;
    }

    @Override
    public Processor clone() {
        return new Processor(cores, freq, cache);
    }

    @Override
    public String constructDisplayString() {
        String str = "";
        str += "Cores: " + cores + "\n";
        str += "Frequency: " + Formatter.formatUnit(freq, "Hz") + "\n";
        str += "Cache: " + Formatter.formatUnit(cache, "B");
        return str;
    }
}
