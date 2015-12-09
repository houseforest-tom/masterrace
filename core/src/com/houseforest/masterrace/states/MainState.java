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
    }

    @Override
    public void render(SpriteBatch batch) {

        BitmapFont font = app.getFontCache().getDefaultFont();
        BitmapFont bold = app.getFontCache().getFont("roboto-bold");

        Component[] components = app.getRig().getComponents();
        Component c;

        float x, y;
        float dx = 24, dy = bold.getCapHeight() + 8;

        for (int type = 0; type < Component.TYPE_COUNT; ++type) {

            c = components[type];
            x = (float) (Gdx.graphics.getWidth() * 0.3);
            y = (float) (Gdx.graphics.getHeight() * (1 - (0.05 + 0.95 / Component.TYPE_COUNT * type)));

            // Component type (heading).
            bold.draw(
                    batch,
                    Component.names[type],
                    x,
                    y
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

    ;;

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    ;;
}
