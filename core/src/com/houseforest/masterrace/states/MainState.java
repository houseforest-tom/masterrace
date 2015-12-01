package com.houseforest.masterrace.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.houseforest.masterrace.components.Component;

/**
 * Created by Tom on 30.11.2015.
 */
public class MainState extends GameState {

    // ===========================================================
    // Constants
    // ===========================================================

    ;;

    // ===========================================================
    // Fields
    // ===========================================================

    ;;

    // ===========================================================
    // Constructors
    // ===========================================================

    public MainState(GameStateManager mgr) {
        super(mgr, GameState.Id.Main);
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    ;;

    // ===========================================================
    // Override Methods
    // ===========================================================

    @Override
    public void update(float dt) {

        for (int type = 0; type < Component.TYPE_COUNT; ++type) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_0 + type)) {
                if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                    upgradeComponent(type);
                } else {
                    increaseComponentRank(type, 1000);
                }
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        BitmapFont font = app.getFontCache().getDefaultFont();
        BitmapFont bold = app.getFontCache().getFont("roboto-bold");

        Component[] components = app.getRig().getComponents();
        Component c;

        float x, y;
        float dx = 24, dy = bold.getCapHeight() + 4;

        for (int type = 0; type < Component.TYPE_COUNT; ++type) {

            c = components[type];
            x = (float) (Gdx.graphics.getWidth() * (0.38 + (type / 5) * 0.33));
            y = (float) (Gdx.graphics.getHeight() * (1 - (0.05 + 0.6 / 4 * (type % 5))));

            // Component type (heading).
            bold.draw(
                    batch,
                    Component.names[type],
                    x,
                    y
            );

            // Component model name.
            font.draw(
                    batch,
                    "Model: " + c.getName(),
                    x + dx,
                    y -= dy
            );

            // Component rank (improvement count).
            font.draw(
                    batch,
                    "Rank: " + c.getRank(),
                    x + dx,
                    y -= dy
            );

            // Component specific characteristics.
            font.draw(
                    batch,
                    c.constructDisplayString(),
                    x + dx,
                    y -= dy
            );
        }
    }

    // ===========================================================
    // Methods
    // ===========================================================

    private void upgradeComponent(int type) {
        if (Component.list.exists(type, app.getRig().getComponent(type).getLevel() + 1)) {
            app.getRig().upgrade(type);
        }
    }

    private void increaseComponentRank(int type, int amount) {
        Component component = app.getRig().getComponent(type);
        if (component.getLevel() == 0) return;
        amount = Math.min(amount, Component.MAX_RANK - component.getRank());
        component.setRank(component.getRank() + amount);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    ;;
}
