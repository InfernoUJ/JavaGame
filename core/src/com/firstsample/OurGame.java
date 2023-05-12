package com.firstsample;

import Screens.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class OurGame extends Game {
	SpriteBatch batch;
	public MainMenuScreen mainMenuScreen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		mainMenuScreen = new MainMenuScreen(this);
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
