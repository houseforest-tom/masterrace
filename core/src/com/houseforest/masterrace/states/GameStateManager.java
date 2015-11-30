package com.houseforest.masterrace.states;

/**
 * Created by Tom on 30.11.2015.
 */

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.houseforest.masterrace.App;
import com.houseforest.masterrace.core.GameObject;

import java.util.HashMap;

/**
 * TODO: Add type documentation here.
 */
public class GameStateManager extends GameObject {

    // ===========================================================
    // Constants
    // ===========================================================

    ;;

    // ===========================================================
    // Fields
    // ===========================================================

    private HashMap<GameState.Id, GameState> states;
    private GameState.Id current;

    // ===========================================================
    // Constructors
    // ===========================================================

    public GameStateManager(App app) {
        super(app);
        this.states = new HashMap<GameState.Id, GameState>();
        this.current = null;

        createStates();
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public App getApplication() {
        return app;
    }

    // ===========================================================
    // Override Methods
    // ===========================================================

    @Override
    public void update(float dt) {
        if (current != null) {
            states.get(current).update(dt);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        if (current != null) {
            states.get(current).render(batch);
        }
    }

    ;

    // ===========================================================
    // Methods
    // ===========================================================

    private void addState(GameState state) {
        this.states.put(state.getId(), state);
    }

    public GameState.Id getCurrentState() {
        return this.current;
    }

    public void setCurrentState(GameState.Id id) {
        this.current = id;
    }

    private void createStates() {
        addState(new MainState(this));
        setCurrentState(GameState.Id.Main);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    ;;
}
