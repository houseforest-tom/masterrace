package com.houseforest.masterrace.components;

import com.houseforest.masterrace.core.Formatter;

/**
 * Created by Tom on 30.11.2015.
 */
public class GPU extends Component {

    // Video memory.
    private long vram;

    // Fillrate.
    private double fillrate;

    // Number of shader units.
    private long shaderUnits;

    public GPU(long vram, double fillrate, long shaderUnits) {
        super(Component.GPU);
        this.vram = vram;
        this.fillrate = fillrate;
        this.shaderUnits = shaderUnits;
    }

    @Override
    public com.houseforest.masterrace.components.GPU clone() {
        return new GPU(vram, fillrate, shaderUnits);
    }

    @Override
    public String constructDisplayString() {
        String str = "";
        str += "VRAM: " + Formatter.formatUnit(vram, "B") + "\n";
        str += "Fillrate: " + Formatter.formatUnit(fillrate, "p/s") + "\n";
        str += "Shader Units: " + shaderUnits;
        return str;
    }
}
