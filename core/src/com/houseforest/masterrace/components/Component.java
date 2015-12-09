package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Rig;

import java.util.ArrayList;

/**
 * Created by Tom on 30.11.2015.
 */
public class Component {

    public static int TYPE_COUNT = 0;
    public static final int
            MAINBOARD = TYPE_COUNT++,   // Stability [%]
            CPU = TYPE_COUNT++,         // Frequency [Hz]
            RAM = TYPE_COUNT++,         // Size [B]
            GPU = TYPE_COUNT++,         // Frequency [Hz]
            DISPLAY = TYPE_COUNT++,     // Resolution [px]
            PSU = TYPE_COUNT++,         // Max. Draw [W]
            FAN = TYPE_COUNT++;         // Speed [RPM]

    // Maximum component rank.
    // The component's performance will reach that of its successor at this rank.
    public static final int MAX_RANK = 65535;

    public static final String[] names = new String[]{
            "Mainboard",
            "Processor",
            "Memory",
            "Graphics Card",
            "Display",
            "Power Supply",
            "Fan",
    };

    // Type of this component.
    private int type;

    // Creates a new component.
    public Component(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    /**
     * Create an identical copy of this component.
     *
     * @return Exact copy.
     */
    @Override
    public Component clone() {
        return new Component(type);
    }

    /**
     * To be implemented by subclasses.
     * Constructs the string to be displayed to the player that contains all required component information.
     *
     * @return Display string.
     */
    public String constructDisplayString() {
        return "N/A";
    }
}
