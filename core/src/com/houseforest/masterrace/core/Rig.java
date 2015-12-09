package com.houseforest.masterrace.core;

import com.houseforest.masterrace.components.*;

/**
 * Created by Tom on 30.11.2015.
 */

// Made up of a collection of hardware- and peripheral components.
public class Rig {

    // Used components.
    private Component[] components;

    // Creates a new rig consisting of the most basic components.
    public Rig() {
        this.components = new Component[Component.TYPE_COUNT];
        this.components[Component.MAINBOARD] = new Mainboard(0.0001);
        this.components[Component.CPU] = new Processor(1L, 1.0, 0L);
        this.components[Component.RAM] = new Memory(1L, 1.0, 99L);
        this.components[Component.GPU] = new GPU(1L, 1.0, 1L);
        this.components[Component.PSU] = new PSU(1L);
        this.components[Component.FAN] = new Fan(1.0);
        this.components[Component.DISPLAY] = new Display(16L * 9L, 1.0, 0.01);
    }

    public Component getComponent(int type) {
        return components[type];
    }

    public Component[] getComponents() {
        return components;
    }
}
