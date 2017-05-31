package com.maxproplus.mygdx.starcomm;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level {
	
	Hero hero;
	Asteroid[] asteroids;

	public Level() {
		hero = new Hero();
		asteroids = new Asteroid[60];
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i] = new Asteroid();

		}
	}
	
	public void render(SpriteBatch batch) {
		hero.render(batch);
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i].render(batch);
		}
	}
	
	public void update() {
		hero.update();
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i].update();

		}
		for (int i = 0; i < hero.weapon.getBullet().length; i++) {
			if (hero.weapon.getBullet()[i].active)
				for (int j = 0; j < asteroids.length; j++)
					if (asteroids[j].circle.contains(hero.weapon.getBullet()[i].position)) {
						hero.weapon.getBullet()[i].disabled();
						asteroids[j].takeDamage(hero.weapon.damage);
					}
		}
	}
	
	public void dispose() {
		hero.dispose();
		for (int i = 0; i < asteroids.length; i++)
			asteroids[i].dispose();
	}

}
