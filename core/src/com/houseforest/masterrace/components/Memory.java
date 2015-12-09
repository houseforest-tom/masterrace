package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class Memory extends Component {

    // Size in bytes.
    private long capacity;

    // Memory frequency.
    private double freq;

    // CAS latency.
    private long cl;

    public Memory(long capacity, double freq, long cl) {
        super(Component.RAM);
        this.capacity = capacity;
        this.freq = freq;
        this.cl = cl;
    }

    public long getCapacity(){
        return capacity;
    }

    public double getFrequency(){
        return freq;
    }

    public long getLatency(){
        return cl;
    }

    @Override
    public Memory clone() {
        return new Memory(capacity, freq, cl);
    }

    @Override
    public String constructDisplayString() {
        String str = "";
        str += "Capacity: " + Formatter.formatUnit(capacity, "B") + "\n";
        str += "Frequency: " + Formatter.formatUnit(freq, "Hz") + "\n";
        str += "Latency: CL" + cl;
        return str;
    }
}
