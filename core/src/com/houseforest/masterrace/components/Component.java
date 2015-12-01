package com.houseforest.masterrace.components;

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
            COOLER = TYPE_COUNT++,      // Temperature [°C]
            FAN = TYPE_COUNT++,         // Speed [RPM]
            KEYBOARD = TYPE_COUNT++,    // Input Latency [s]
            MOUSE = TYPE_COUNT++;       // Precision [dpi]

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
            "Cooler",
            "Fan",
            "Keyboard",
            "Mouse"
    };

    // Global component list.
    public static final ComponentList list = new ComponentList();

    // Type of this component.
    private int type;

    // Component level.
    private int level;

    // Name of the component.
    private String name;

    // Base performance indicator.
    private double basePerformance;

    // Improvement rank.
    private int rank;

    // Creates a new component.
    public Component(int type, int level, String name, double performance) {
        this.type = type;
        this.level = level;
        this.name = name;
        this.basePerformance = performance;
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

    public double getBasePerformance() {
        return basePerformance;
    }

    /**
     * Calculates the component's performance taking into respect its current rank.
     *
     * @return Component performance.
     */
    public double getPerformance() {

        // If best component available -> max performance := 2 x base.
        double max = 2.0 * basePerformance;

        // Else max performance := upgrade's base performance.
        if (list.exists(type, level + 1)) {
            max = list.get(type, level + 1).getBasePerformance();
        }

        double delta = max - basePerformance;

        // Interpolate linearly between base and max performance.
        return basePerformance + (double) (rank - 1) / (double) MAX_RANK * delta;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double calculateMetric(double performance) {
        return performance;
    }

    @Override
    public Component clone() {
        return new Component(type, level, name, basePerformance);
    }

    public String constructDisplayString() {
        return "N/A";
    }
}
