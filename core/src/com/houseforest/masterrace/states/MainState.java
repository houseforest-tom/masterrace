package com.houseforest.masterrace.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.houseforest.masterrace.App;
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

    private Sprite[] componentSprites;

    // ===========================================================
    // Constructors
    // ===========================================================

    public MainState(GameStateManager mgr) {
        super(mgr, GameState.Id.Main);
        if (componentSprites == null) {
            componentSprites = new Sprite[Component.TYPE_COUNT];
            for (int i = 0; i < componentSprites.length; ++i) {
                componentSprites[i] = new Sprite(
                        new Texture(
                                Gdx.files.internal(
                                        "textures/components/" + i + ".png"
                                )
                        )
                );
                componentSprites[i].setSize(230, 230);
                componentSprites[i].setCenter(
                        App.width / 2 - 360,
                        App.height - (320 + i * 316)
                );
                App.log("Loaded component sprite #" + i);
            }
        }
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

        float nameTextX = App.width / 2 - 120;
        float featuresTextX = nameTextX + 32;

        for (int type = 0; type < Component.TYPE_COUNT; ++type) {

            c = components[type];

            componentSprites[type].draw(batch);

            // Component type (heading).
            bold.draw(
                    batch,
                    Component.names[type],
                    nameTextX,
                    App.height - (192 + type * 316)
            );

            // Component specific characteristics.
            font.draw(
                    batch,
                    c.constructDisplayString(),
                    featuresTextX,
                    App.height - (256 + type * 316)
            );
        }
    }

    @Override
    public void dispose() {
        for (Sprite componentSprite : componentSprites) {
            componentSprite.getTexture().dispose();
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
