package Screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.firstsample.OurGame;

public class MainMenuScreen extends ScreenAdapter{
    final OurGame game;
    public Viewport viewport;

    public MainMenuScreen(OurGame game) {
        this.game = game;

        viewport = new ScreenViewport();
    }
}
