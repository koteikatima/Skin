package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.classicGame.ClassicGame;

import static com.mygdx.game.Constants.*;

public class GameOptions implements Screen {
    private ProjectWithMySkin game;
    Skin skinJson;

    private Stage stage;
    private Table table;
    private TextButton textButtonPlay;
    private TextButton textButtonSetting;
    private TextButton textButtonExit;

    public GameOptions(ProjectWithMySkin gam,
                       Skin skinJson) {
        this.game = gam;//Ссылка   на экземпляр класса ProjectWithMySkin ,
        // например, для перехода между экранами игры
this.skinJson=skinJson;//Ссылка   на экземпляр класса Skin

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
//Table  устанавливает положение и размер своих дочерних элементов, используя логическую таблицу.
        table = new Table();
        table.getAlign();
// width  и height -за ширину и высоту окна приложения
        table.setWidth(width);
        table.setHeight(height);
    }

    @Override
    public void show() {
        if (language.equals("english")) {
            textButtonPlay = new TextButton("New Game", skinJson);
            textButtonSetting = new TextButton("Setting", skinJson);
            textButtonExit = new TextButton("Exit", skinJson);
        }
        if (language.equals("russian")) {
            textButtonPlay = new TextButton("Новая игра", skinJson);
            textButtonSetting = new TextButton("Настройки", skinJson);
            textButtonExit = new TextButton("Выход", skinJson);
        }

        textButtonPlay.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
game.setScreen(new ClassicGame(game,skinJson));//перехода между экранами игры
            }
        });

        textButtonSetting.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                   }
        });

        textButtonExit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
Gdx.app.exit();
            }
        });
        //   установка положения и размеров кнопок в Table
        textButtonPlay.getLabel().setFontScale((float) 1, (float) 1);
        table.add(textButtonPlay).width(width * 2 / 3).height(height / 5).pad(10);
        table.row();

        textButtonSetting.getLabel().setFontScale((float) 1, (float) 1);
        table.add(textButtonSetting).width(width * 2 / 3).height(height / 5).pad(10);
        table.row();

        textButtonExit.getLabel().setFontScale((float) 1, (float) 1);
        table.add(textButtonExit).width(width * 2 / 3).height(height / 5).pad(10);
            stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.6f, 0.8f, 0.6f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}