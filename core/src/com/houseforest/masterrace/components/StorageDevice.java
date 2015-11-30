package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class StorageDevice extends Component {

    public StorageDevice(int level, String name, double performance) {
        super(Component.STORAGE, level, name, performance);
    }

    @Override
    public StorageDevice clone() {
        return new StorageDevice(getLevel(), getName(), getPerformance());
    }

    @Override
    public String constructDisplayString() {
        return "Capacity: " + Formatter.formatUnit(getRank(), "B");
    }
}
