package com.firstsample.Stages;

import com.firstsample.Screens.MainMenuScreen;
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
        TextButton SettingsButton = new TextButton("Settings", mainMenuScreen.skin);
        TextButton ExitButton = new TextButton("Exit", mainMenuScreen.skin);

        Table table = new Table(mainMenuScreen.skin);

        // set children coord system to parent coord system
        table.setTransform(true);
        // size as parent
        table.setFillParent(true);

        table.defaults().space(Math.round(Gdx.graphics.getHeight() * 1f/1080 * 10));
        table.add(StartGameButton);
        table.row();
        table.add(SettingsButton);
        table.row();
        table.add(ExitButton);

        //table.background(mainMenuScreen.backScreen);
        currentStage.addActor(table);
    }
}
