package coreStructures;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import viewmodel.Manager;

public class OurGame extends Game {
	public SpriteBatch batch;
	public Manager mainManager;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		mainManager = new Manager(this);

		this.setScreen(mainManager.currentScreen);
	}

	@Override
	public void render () {
		if(mainManager.currentScreen != null) {
			super.render();
			if (getScreen() != mainManager.currentScreen) {
				System.out.println("Rendering ScreenGame");
				setScreen(mainManager.currentScreen);
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		mainManager.dispose();
	}


}
