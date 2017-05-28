package com.maxproplus.mygdx.starcomm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private Background bg;
	private Hero hero;
	private Asteroid[] asteroids;

	public void create() {
		batch = new SpriteBatch();
		bg = new Background();
		hero = new Hero();
		asteroids = new Asteroid[60];
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i] = new Asteroid();

		}

	}

	public void render() {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		bg.render(batch);
		hero.render(batch);
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i].render(batch);
		}
		batch.end();
	}

	public void update() {
		bg.update();
		hero.update();
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i].update();

		}
		for (int i = 0; i < hero.weapon.getBullet().length; i++) {
			if (hero.weapon.getBullet()[i].active)
				for (int j = 0; j < asteroids.length; j++)
					if (asteroids[j].circle.contains(hero.weapon.getBullet()[i].position)) {
						hero.weapon.getBullet()[i].disabled();
						asteroids[j].takeDamage(hero.weapon.getBullet()[i].damage);
					}
		}

	}

	public void dispose() {
		batch.dispose();
	}
}
