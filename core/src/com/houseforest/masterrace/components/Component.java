package com.houseforest.masterrace.components;

/**
 * Created by Tom on 30.11.2015.
 */
public class Component {

    public static final int
            MAINBOARD = 0,
            PROCESSOR = 1,
            MEMORY = 2,
            GRAPHICS = 3,
            STORAGE = 4,
            KEYBOARD = 5,
            MOUSE = 6,
            DISPLAY = 7,
            AUDIO = 8,
            WORKPLACE = 9,
            TYPE_COUNT = 10;

    public static final String[] names = new String[]{
            "Mainboard",
            "Processor",
            "Memory",
            "Graphics Card",
            "Storage Device",
            "Keyboard",
            "Mouse",
            "Display",
            "Audio Device",
            "Workplace"
    };

    // Type of this component.
    private int type;

    // Component level.
    private int level;

    // Name of the component.
    private String name;

    // Performance index.
    private double performance;

    // Improvement rank.
    private int rank;

    // Creates a new component.
    public Component(int type, int level, String name, double performance) {
        this.type = type;
        this.level = level;
        this.name = name;
        this.performance = performance;
        this.rank = 1;
    }

    public int getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public double getPerformance() {
        return performance;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public Component clone() {
        return new Component(type, level, name, performance);
    }

    public String constructDisplayString() {
        return "N/A";
    }
}
