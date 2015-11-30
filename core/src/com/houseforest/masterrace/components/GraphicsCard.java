package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class GraphicsCard extends Component {

    public GraphicsCard(int level, String name, double performance) {
        super(Component.GRAPHICS, level, name, performance);
    }

    @Override
    public GraphicsCard clone() {
        return new GraphicsCard(getLevel(), getName(), getPerformance());
    }

    @Override
    public String constructDisplayString() {
        return "Core Clock: " + Formatter.formatUnit(getRank(), "Hz");
    }
}
