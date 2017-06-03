package com.maxproplus.mygdx.starcomm.gamescreen;

import com.badlogic.gdx.Screen;
import com.maxproplus.mygdx.starcomm.gameworld.GameRender;
import com.maxproplus.mygdx.starcomm.gameworld.GameWorld;

public class GameScreen implements Screen {

	Main main;
	GameWorld world;
	GameRender renderer;

	public GameScreen(Main main) {
		this.main = main;
		world = new GameWorld();
		renderer = new GameRender(world, main.batch);
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		world.update();
		renderer.render();

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {
		main.setScreen(new MainMenuScreen(main));

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		world.dispose();
		renderer.dispose();
	}
}
