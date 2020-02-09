package com.mygdx.game.classicGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.ProjectWithMySkin;
import com.mygdx.game.classicGame.stage.GameMenu;
import com.mygdx.game.classicGame.stage.Player;


import static com.mygdx.game.Constants.*;

public class ClassicGame implements Screen {
    private ProjectWithMySkin game;
    private Stage stage;
    private Button ClassicButton;
    private Skin skinJson;
    private InputMultiplexer in;//
    private int ButtonSize;
  GameMenu gameMenu;
    Player player;

    public ClassicGame(ProjectWithMySkin game, Skin skinJson) {
        this.game = game;//Ссылка   на экземпляр класса ProjectWithMySkin ,
        // например, для перехода между экранами игры
        this.skinJson = skinJson;//Ссылка   на экземпляр класса Skin

        ButtonSize = height / 3;//размер игровой клетки исходя из высоты окна приложения

        //стандартная настройка Stage
        stage = new Stage(new FitViewport(width, height));//
        stage.getCamera().position.set(height / 2, height / 2, 0);//Stage имеет свою камеру
        gameMenu = new GameMenu(skinJson);//создание экземпляра класса GameMenu
        player = new Player(skinJson);


        in = new InputMultiplexer();
        in.addProcessor(gameMenu); //добавление обработчика GameMenu,
        // необхоимо для работы слушателей(ClickListener) у актеров сцены(кнопок)
     //   in.addProcessor(player);
        in.addProcessor(stage);
        Gdx.input.setInputProcessor(in);
    }

    @Override
    public void show() {
        //создание поля 3*3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ClassicButton = new ImageButton(skinJson);//создание ImageButton и  передача объекта Skin в конструктор
                ClassicButton.setSize(ButtonSize, ButtonSize);//установка размеров
                ClassicButton.setPosition(ButtonSize * i, ButtonSize * j);//установка позиции для каждой кнопки
                ClassicButton.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                    }
                });
                ClassicButton.setChecked(false);
                //установка времени (в сек) до сброса счетчика нажатий
                ClassicButton.getClickListener().setTapCountInterval((float) 0.5);
                //добавление кнопки в stage
                stage.addActor(ClassicButton);
            }
        }

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.6f, 0.8f, 0.6f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();//
        stage.draw();

        gameMenu.act();
        gameMenu.draw();

 //       player.act();
 //       player.draw();

        //Обращение к каждой кнопке, входящей в stage
        for (int i = 0; i < stage.getActors().size; i++) {
            ImageButton button = (ImageButton) stage.getActors().items[i];

            //если счетчик нажатий =2 ,то установить стиль "crest" для этой кнопки
            if (button.getClickListener().getTapCount() == 2) {
                button.setStyle(skinJson.get("nolic", ImageButton.ImageButtonStyle.class));
                button.setSize(ButtonSize, ButtonSize);//установка размеров

            }
        }
    }
    @Override
    public void
    resize(int width, int height) {
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

