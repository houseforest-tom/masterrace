package com.houseforest.masterrace;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.*;
import com.houseforest.masterrace.core.Formatter;
import com.houseforest.masterrace.core.Rig;
import com.houseforest.masterrace.resources.FontCache;
import com.houseforest.masterrace.resources.FontParamAdapter;
import com.houseforest.masterrace.states.GameStateManager;

public class App extends ApplicationAdapter {

    public static final int width = 1440;
    public static final int height = 2560;

    private GameStateManager stateMgr;
    private SpriteBatch batch;
    private FontCache fonts;
    private Viewport viewport;
    private Camera camera;
    private Rig rig;

    public static void log(String message) {
        Gdx.app.log(App.class.getPackage().getName(), message);
    }

    @Override
    public void create() {

        Gdx.graphics.setDisplayMode(
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight(),
                false
        );

        // Init spritebatch.
        batch = new SpriteBatch();

        // Setup camera & viewport.
        camera = new OrthographicCamera();
        viewport = new StretchViewport(width, height, camera);
        viewport.apply();
        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Load & generate fonts.
        fonts = new FontCache();
        fonts.addFontSource("roboto", Gdx.files.internal("fonts/roboto.ttf"));
        fonts.addFont("roboto14", fonts.createFont("roboto", new FontParamAdapter() {

            @Override
            public void setup(FreeTypeFontGenerator.FreeTypeFontParameter params) {
                params.color = new Color(0, 0, 0, 1);
                params.size = 48;
            }
        }));
        fonts.addFont("roboto-bold", fonts.createFont("roboto", new FontParamAdapter() {

            @Override
            public void setup(FreeTypeFontGenerator.FreeTypeFontParameter params) {
                params.color = new Color(0, 0, 0, 1);
                params.size = 54;
                params.borderWidth *= 2;
            }
        }));

        Formatter.init();

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
        camera.update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        // Render current game state.
        stateMgr.render(batch);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
    }

    @Override
    public void dispose(){
        stateMgr.dispose();
        fonts.dispose();
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