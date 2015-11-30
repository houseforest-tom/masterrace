package com.houseforest.masterrace.core;

import com.houseforest.masterrace.components.Component;
import com.houseforest.masterrace.components.ComponentList;

/**
 * Created by Tom on 30.11.2015.
 */

// Made up of a collection of hardware- and peripheral components.
public class Rig {

    // Used components.
    private Component[] components;

    // List of available components.
    private ComponentList list;

    // Creates a new rig consisting of the most basic components.
    public Rig(ComponentList list) {

        this.list = list;
        this.components = new Component[Component.TYPE_COUNT];

        for (int type = 0; type < Component.TYPE_COUNT; ++type) {
            components[type] = list.get(type, 0).clone();
        }
    }

    public Component getComponent(int type) {
        return components[type];
    }

    public Component[] getComponents() {
        return components;
    }

    // Upgrade component by one level.
    public void upgrade(int type) {
        upgrade(type, components[type].getLevel() + 1);
    }

    // Upgrade component up to specified level.
    public void upgrade(int type, int targetLevel) {
        try {
            components[type] = list.get(type, targetLevel).clone();
        } catch (Exception e) {
            System.err.println(Component.names[type] + " of level " + targetLevel + " does not exist!");
        }
    }
}
