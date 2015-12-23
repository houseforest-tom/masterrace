package com.houseforest.masterrace.resources;

/**
 * Created by Tom on 30.11.2015.
 */

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import java.util.HashMap;

/**
 * TODO: Add type documentation here.
 */
public class FontCache {

    // ===========================================================
    // Constants
    // ===========================================================

    ;;

    // ===========================================================
    // Fields
    // ===========================================================

    private HashMap<String, FreeTypeFontGenerator> generators;
    private HashMap<String, BitmapFont> fonts;
    private String defaultFontName;

    // ===========================================================
    // Constructors
    // ===========================================================

    public FontCache() {
        this.generators = new HashMap<String, FreeTypeFontGenerator>();
        this.fonts = new HashMap<String, BitmapFont>();
        this.defaultFontName = "";
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public BitmapFont getDefaultFont() {

        if (defaultFontName == null || defaultFontName.isEmpty()) {
            return null;
        }

        return fonts.get(defaultFontName);
    }

    public void setDefaultFont(String fontName) {
        this.defaultFontName = fontName;
    }

    public BitmapFont getFont(String name) {
        return fonts.get(name);
    }

    // ===========================================================
    // Override Methods
    // ===========================================================

    ;;

    // ===========================================================
    // Methods
    // ===========================================================

    public void addFontSource(String sourceName, FileHandle ttf) {
        generators.put(sourceName, new FreeTypeFontGenerator(ttf));
    }

    public BitmapFont createFont(String sourceName, FontParamAdapter params) {
        FreeTypeFontParameter p = new FreeTypeFontParameter();
        params.setup(p);
        return generators.get(sourceName).generateFont(p);
    }

    public void addFont(String fontName, BitmapFont font) {
        fonts.put(fontName, font);
        if (defaultFontName == null || defaultFontName.isEmpty()) {
            defaultFontName = fontName;
        }
    }

    // Dispose generators and fonts.
    public void dispose(){
        for(HashMap.Entry<String, FreeTypeFontGenerator> generator : generators.entrySet()){
            generator.getValue().dispose();
        }
        for(HashMap.Entry<String, BitmapFont> font : fonts.entrySet()){
            font.getValue().dispose();
        }
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    ;;
}

