package com.firstsample;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.firstsample.OurGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setForegroundFPS(60);
		config.setTitle("FirstSample");
		config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode(Lwjgl3ApplicationConfiguration.getPrimaryMonitor()));

		new Lwjgl3Application(new OurGame(), config);
	}
}
