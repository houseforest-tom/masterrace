package com.houseforest.masterrace.components;

/**
 * Created by Tom on 30.11.2015.
 */
public class Mainboard extends Component {

    // Mainboard stability percentage.
    private double stability;

    public Mainboard(double stability) {
        super(Component.MAINBOARD);
    }

    public double getStability(){
        return stability;
    }

    @Override
    public Mainboard clone() {
        return new Mainboard(stability);
    }

    @Override
    public String constructDisplayString() {
        return "Stability: " + String.format("%.4f", stability) + "%";
    }
}
