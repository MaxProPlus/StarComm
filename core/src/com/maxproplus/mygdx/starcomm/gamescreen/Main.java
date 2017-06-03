package com.maxproplus.mygdx.starcomm.gamescreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.maxproplus.mygdx.starcomm.gamehelpers.AssetLoader;
import com.maxproplus.mygdx.starcomm.gamehelpers.InputHandler;

public class Main extends com.badlogic.gdx.Game {

	public SpriteBatch batch;

	@Override
	public void create() {
		batch = new SpriteBatch();
		AssetLoader.load();
		Gdx.input.setInputProcessor(new InputHandler(this));
		setScreen(new MainMenuScreen(this));
	}
}
