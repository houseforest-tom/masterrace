package com.houseforest.masterrace;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.houseforest.masterrace.components.*;
import com.houseforest.masterrace.core.Formatter;
import com.houseforest.masterrace.core.Rig;
import com.houseforest.masterrace.resources.FontCache;
import com.houseforest.masterrace.resources.FontParamAdapter;
import com.houseforest.masterrace.states.GameStateManager;

public class App extends ApplicationAdapter {

    private GameStateManager stateMgr;
    private SpriteBatch batch;
    private FontCache fonts;
    private Rig rig;

    public static void log(String message) {
        Gdx.app.log(App.class.getPackage().getName(), message);
    }

    @Override
    public void create() {

        Gdx.graphics.setDisplayMode(1280, 720, false);

        // Init spritebatch.
        batch = new SpriteBatch();

        // Load & generate fonts.
        fonts = new FontCache();
        fonts.addFontSource("roboto", Gdx.files.internal("fonts/roboto.ttf"));
        fonts.addFont("roboto14", fonts.createFont("roboto", new FontParamAdapter() {

            @Override
            public void setup(FreeTypeFontGenerator.FreeTypeFontParameter params) {
                params.color = new Color(1, 1, 1, 1);
                params.size = 18;
            }
        }));
        fonts.addFont("roboto-bold", fonts.createFont("roboto", new FontParamAdapter() {

            @Override
            public void setup(FreeTypeFontGenerator.FreeTypeFontParameter params) {
                params.color = new Color(1, 1, 1, 1);
                params.size = 20;
                params.borderWidth *= 2;
            }
        }));

        Formatter.init();

        // Tier 0
        for (int type = 0; type < Component.TYPE_COUNT; ++type) {
            Component.list.add(new Component(type, 0, "None", 0.0));
        }

        // Tier 1
        Component.list.add(new Mainboard(1, "Breadboard", 1.0));
        Component.list.add(new Processor(1, "Intel 4004", 1.0));
        Component.list.add(new Memory(1, "Punchcard", 1.0));
        Component.list.add(new GPU(1, "Monochrome Adapter", 1.0));
        Component.list.add(new Display(1, "Oscilloscope", 1.0));
        Component.list.add(new PSU(1, "Potato", 1.0));
        Component.list.add(new Cooler(1, "Lead Block", 1.0));
        Component.list.add(new Fan(1, "Waving Hands", 1.0));
        Component.list.add(new Keyboard(1, "Typewriter", 1.0));
        Component.list.add(new Mouse(1, "Engelbart Rodent", 1.0));


        // Init player rig.
        rig = new Rig();

        // Init game state manager.
        stateMgr = new GameStateManager(this);
    }

    private void update(float dt) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        // Update current game state.
        stateMgr.update(dt);
    }

    @Override
    public void render() {

        // Update game logic.
        this.update(Gdx.graphics.getDeltaTime());

        // Clear screen.
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // Render current game state.
        stateMgr.render(batch);

        batch.end();
    }

    public Rig getRig() {
        return rig;
    }

    public FontCache getFontCache() {
        return fonts;
    }

    public GameStateManager getStateManager() {
        return stateMgr;
    }
}