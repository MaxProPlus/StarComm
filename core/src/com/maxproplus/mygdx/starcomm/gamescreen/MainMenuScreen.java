package com.maxproplus.mygdx.starcomm.gamescreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.maxproplus.mygdx.starcomm.gamehelpers.AssetLoader;
import com.maxproplus.mygdx.starcomm.gameobjects.Background;

public class MainMenuScreen implements Screen {

	final Main main;
	Background bg;

	public MainMenuScreen(Main main) {
		this.main = main;
		bg = new Background();

	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		bg.update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		main.batch.begin();

		bg.render(main.batch);
		main.batch.draw(AssetLoader.start, 640 - 124, 360 - 64);

		main.batch.end();
		if (Gdx.input.isTouched()) {

		}
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		bg.dispose();
	}
}
