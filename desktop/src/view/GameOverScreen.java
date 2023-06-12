package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import viewmodel.GameManager;
import viewmodel.Manager;

public class GameOverScreen extends ScreenAdapter {
    Manager mainManager;
    Stage stage;
    public GameOverScreen(Manager mainManager){
        super();
        this.mainManager = mainManager;
        loadElements();
    }

    private void loadElements(){
        stage = new Stage(mainManager.viewport);
        TextButton mainMenuButton = new TextButton("Back to main menu", mainManager.skin);
        // funny, but it doesn't work
        mainMenuButton.setSize(100, 500);
        mainMenuButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mainManager.loadStartMenu();
            }
        });

        TextButton ExitButton = new TextButton("Exit", mainManager.skin);
        ExitButton.setSize(200, 50);
        ExitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mainManager.exitGame();
            }
        });

        Table table = new Table(mainManager.skin);

        // set children coord system to parent coord system
        table.setTransform(true);
        // size as parent
        table.setFillParent(true);

        table.defaults().space(Math.round(Gdx.graphics.getHeight() * 1f/1080 * 200));
        table.defaults().size(200, 50);
        table.add(mainMenuButton);
        table.row();;
        table.add(ExitButton);

        // table.background(mainManager.backScreen);
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void render(float delta){
        super.render(delta);

        // Set the background color
        // TODO: move it to textures and skin pack( or smth like that)
        Gdx.gl.glClearColor(0,  0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose(){
        super.dispose();
        stage.dispose();
    }
}
