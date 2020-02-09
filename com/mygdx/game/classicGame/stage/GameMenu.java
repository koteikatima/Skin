package com.mygdx.game.classicGame.stage;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


import static com.mygdx.game.Constants.height;
import static com.mygdx.game.Constants.language;
import static com.mygdx.game.Constants.width;

public class GameMenu extends Stage {//создание своей сцены(Stage)
    Button pause;
    Button plus;
    Button minus;
    TextButton textButton;
    Table table;
    Skin skin2;
    float PoleInPlayDrawSize = (float) ((width - height) / 2);//так как игровое поле имеет
    // длину и ширину равную height, то  оставшееся место справа(по х) это их разница пополам

    public GameMenu(Skin skin2
    ) {
        this.skin2 = skin2;
        pause = new Button(skin2, "pause");
        textButton = new TextButton("45", skin2);
        plus = new Button(skin2, "plus");
        minus = new Button(skin2, "minus");
//Table  устанавливает положение и размер своих дочерних элементов, используя логическую таблицу.
        table = new Table();
        //оставшееся место справа(площадь) отдается под кнопки
        table.setBounds(width - PoleInPlayDrawSize, 0, PoleInPlayDrawSize, height);
        pause.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        plus.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        //   установка положения и размеров кнопок в Table
        table.add(pause).width(PoleInPlayDrawSize).height(height / 4);
        table.row();
        table.add(textButton).width(PoleInPlayDrawSize).height(height / 4);
        table.row();
        table.add(plus).width(PoleInPlayDrawSize).height(height / 4);
        table.row();
        table.add(minus).width(PoleInPlayDrawSize).height(height / 4);
//добавление table в сцену(Stage)
        addActor(table);
    }
}
