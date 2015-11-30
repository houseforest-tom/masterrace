package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class AudioDevice extends Component {

    public AudioDevice(int level, String name, double performance) {
        super(Component.AUDIO, level, name, performance);
    }

    @Override
    public AudioDevice clone() {
        return new AudioDevice(getLevel(), getName(), getPerformance());
    }

    @Override
    public String constructDisplayString() {
        return "Volume: " + Formatter.formatUnit(getRank(), "sone");
    }
}
