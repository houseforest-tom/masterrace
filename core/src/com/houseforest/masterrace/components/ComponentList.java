package com.houseforest.masterrace.components;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by Tom on 30.11.2015.
 */

// Stores all available components and assigns them a 'level' i.e. incremental id that represents its rank.
public class ComponentList {

    private HashMap<Integer, TreeMap<Integer, Component>> list;

    public ComponentList() {
        list = new HashMap<Integer, TreeMap<Integer, Component>>();
        for (int i = 0; i < Component.TYPE_COUNT; ++i) {
            list.put(i, new TreeMap<Integer, Component>());
        }
    }

    public TreeMap<Integer, Component> getAllOfType(int type) {
        return list.get(type);
    }

    public void add(Component component) {
        getAllOfType(component.getType()).put(component.getLevel(), component);
    }

    public Component get(int type, int level) {
        return getAllOfType(type).get(level);
    }

    public boolean exists(int type, int level) {
        return getAllOfType(type).containsKey(level);
    }
}
