package com.maxproplus.mygdx.starcomm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private Background bg;
	Level level;
	Texture start;
	boolean active;
	int x;
	int y;

	public void create() {
		batch = new SpriteBatch();
		bg = new Background();

		start = new Texture("Start_game.png");

	}

	public void render() {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		bg.render(batch);
		if (!active)
			batch.draw(start, 640 - 124, 360 - 64);
		if (active)
			level.render(batch);
		batch.end();
	}

	public void update() {
		bg.update();
		if (active)
			if (Gdx.input.isKeyPressed(Input.Keys.R)) {
				active = false;
				level.dispose();
			}
		if (active)
			level.update();
		if (!active)
			menu();

	}

	public void menu() {
		x = Gdx.input.getX();
		y = Gdx.input.getY();
		if (Gdx.input.isTouched()) {

			if (x > 640 - 79 && x < 640 + 76 && y > 360 - 19 && y < 360 + 16) {
				level = new Level();
				active = true;
			}
		}
		if (x > 640 - 79 && x < 640 + 76 && y > 360 - 19 && y < 360 + 16) {
			start = new Texture("Start_game1.png");
		} else
			start = new Texture("Start_game.png");
	}

	public void startGame() {
		level.render(batch);
	}

	public void dispose() {
		batch.dispose();
	}
}
