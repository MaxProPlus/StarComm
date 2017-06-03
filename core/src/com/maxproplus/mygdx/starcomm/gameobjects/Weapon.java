package com.maxproplus.mygdx.starcomm.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.maxproplus.mygdx.starcomm.gamehelpers.AssetLoader;

public class Weapon {
	class Bullet {

		boolean active;
		public Vector2 position;
		float speed;

		public Bullet() {
			speed = 16f;
			active = false;
			position = new Vector2(0, 0);
		}

		public void shot(float x, float y) {
			active = true;
			position.x = x;
			position.y = y;
		}

		public void disabled() {
			active = false;
		}

	}

	Bullet[] bullet;
	private long fireCounterLast;
	private long fireCounter;
	private double fireRate;
	int damage;

	public Weapon(int type, int ammo) {
		fireCounterLast = System.nanoTime();
		bullet = new Bullet[ammo];
		for (int i = 0; i < bullet.length; i++) {
			bullet[i] = new Bullet();
		}
		switch (type) {
		case 1:
			AssetLoader.bullet = new Texture("bullet64x32.png");
			fireRate = 1*100000000L;
			damage = 3;
			break;
		case 2:
			AssetLoader.bullet = new Texture("spaceMissiles_006.png");
			fireRate = 6*100000000L;
			damage = 6;
			break;
		}

	}

	public void render(SpriteBatch batch) {
		for (int i = 0; i < bullet.length; i++)
			if (bullet[i].active)
				batch.draw(AssetLoader.bullet, bullet[i].position.x, bullet[i].position.y);
	}

	public void update() {
		for (int i = 0; i < bullet.length; i++) {
			if (bullet[i].active)
				bullet[i].position.x += bullet[i].speed;
			if (bullet[i].position.x > Gdx.graphics.getWidth())
				bullet[i].disabled();

		}
	}

	public void fire(float x, float y) {
		fireCounter = System.nanoTime();
		if (fireCounter-fireCounterLast >= fireRate) {
			fireCounterLast = System.nanoTime();
			for (int i = 0; i < bullet.length; i++) {
				if (!bullet[i].active) {
					bullet[i].shot(x + 50, y + 16);
					fireCounter = 0;
					break;
				}

			}
		}
	}

	public Bullet[] getBullet() {
		return bullet;
	}
	
	public void dispose() {
	}

}
