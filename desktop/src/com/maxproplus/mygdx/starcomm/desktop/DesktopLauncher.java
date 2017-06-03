package com.maxproplus.mygdx.starcomm.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.maxproplus.mygdx.starcomm.gamescreen.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "StarComm";
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new Main(), config);
	}
}
