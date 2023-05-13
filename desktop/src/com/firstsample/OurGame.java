package com.firstsample;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class OurGame extends Game {
	SpriteBatch batch;
	public MainMenuScreen mainMenuScreen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		mainMenuScreen = new MainMenuScreen(this);

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
