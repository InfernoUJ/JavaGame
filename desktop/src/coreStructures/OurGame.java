package coreStructures;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import viewmodel.Manager;

public class OurGame extends Game {
	public SpriteBatch batch;
	public Manager mainMenuScreen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		mainMenuScreen = new Manager(this);

		this.setScreen(mainMenuScreen);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		mainMenuScreen.dispose();
	}


}
