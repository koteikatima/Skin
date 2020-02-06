package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ProjectWithMySkin extends Game {
Skin skinJson;
    @Override
    public void create() {
        skinJson=new Skin(Gdx.files.internal("skin/project_skin.json"));
        this.setScreen(new GameOptions(this,skinJson));
    }
    @Override
    public void render() {
     super.render();
    }
    @Override
    public void dispose() {

    }
}
