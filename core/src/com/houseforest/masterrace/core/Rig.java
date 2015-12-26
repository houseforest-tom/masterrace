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
        this.components[Component.MAINBOARD] = new Mainboard(0, 0, 1);
        this.components[Component.CPU] = new Processor(0, 0.0, 0.0);
        this.components[Component.RAM] = new Memory(0, 0.0, 0.0);
        this.components[Component.GPU] = new GPU(0, 0.0, 0.0);
        this.components[Component.PSU] = new PSU(1.0, 1.0);
        this.components[Component.FAN] = new Fan(0.0, 0.0, 0.0);
        this.components[Component.DISPLAY] = new Display(0, 0.0, 0.0);
    }

    public Component getComponent(int type) {
        return components[type];
    }

    public Component[] getComponents() {
        return components;
    }

    public double calculateFPS(){
        double fps = 0.0;

        return fps;
    }
}
