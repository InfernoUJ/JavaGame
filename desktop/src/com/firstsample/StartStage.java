package com.firstsample;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class StartStage extends Stage{
    MainMenuScreen mainMenuScreen;
    public Stage currentStage;

    public StartStage(MainMenuScreen mainMenuScreen){
        this.mainMenuScreen = mainMenuScreen;

        currentStage = new Stage(mainMenuScreen.viewport);

        TextButton StartGameButton = new TextButton("Start", mainMenuScreen.skin);
        // funny, but it doesn't work
        StartGameButton.setSize(100, 500);
        TextButton SettingsButton = new TextButton("Settings", mainMenuScreen.skin);
        SettingsButton.setSize(200, 50);
        TextButton ExitButton = new TextButton("Exit", mainMenuScreen.skin);
        ExitButton.setSize(200, 50);
        ExitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        Table table = new Table(mainMenuScreen.skin);

        // set children coord system to parent coord system
        table.setTransform(true);
        // size as parent
        table.setFillParent(true);

        table.defaults().space(Math.round(Gdx.graphics.getHeight() * 1f/1080 * 200));
        table.defaults().size(200, 50);
        table.add(StartGameButton);
        table.row();
        table.add(SettingsButton);
        table.row();
        table.add(ExitButton);

        //table.background(mainMenuScreen.backScreen);
        currentStage.addActor(table);
    }
}
