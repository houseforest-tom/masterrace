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
    private ComponentList componentList;
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

        componentList = new ComponentList();

        // Tier 0
        for (int type = 0; type < Component.TYPE_COUNT; ++type) {
            componentList.add(new Component(type, 0, "None", 0.0));
        }

        // Tier 1
        componentList.add(new Mainboard(1, "Breadboard", 1.0));
        componentList.add(new Processor(1, "Intel 4004", 1.0));
        componentList.add(new Memory(1, "Punchcard", 1.0));
        componentList.add(new GraphicsCard(1, "Monochrome Adapter", 1.0));
        componentList.add(new StorageDevice(1, "Punchcard", 1.0));
        componentList.add(new Keyboard(1, "Wired Typewriter", 1.0));
        componentList.add(new Mouse(1, "Engelbart Mouse", 1.0));
        componentList.add(new DisplayDevice(1, "Oscilloscope", 1.0));
        componentList.add(new AudioDevice(1, "Horn", 1.0));
        componentList.add(new Workplace(1, "Floor", 1.0));

        // Init player rig.
        rig = new Rig(componentList);

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

    public ComponentList getComponentList() {
        return componentList;
    }

    public FontCache getFontCache() {
        return fonts;
    }

    public GameStateManager getStateManager() {
        return stateMgr;
    }
}