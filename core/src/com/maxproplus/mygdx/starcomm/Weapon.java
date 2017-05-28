package com.maxproplus.mygdx.starcomm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Weapon {
	class Bullet {

		boolean active;
		public Vector2 position;
		float speed;
		int damage;

		public Bullet() {
			speed = 16f;
			damage = 3;
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
	Texture texture;
	private int fireCounter;
	private int fireRate;

	public Weapon(int type, int ammo) {
		fireCounter = 0;
		bullet = new Bullet[ammo];
		for (int i = 0; i < bullet.length; i++) {
			bullet[i] = new Bullet();
		}
		switch (type) {
		case 1:
			texture = new Texture("bullet64x32.png");
			fireRate = 12;
			break;
		}

	}

	public void render(SpriteBatch batch) {
		for (int i = 0; i < bullet.length; i++)
			if (bullet[i].active)
				batch.draw(texture, bullet[i].position.x, bullet[i].position.y);
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
		fireCounter++;
		if (fireCounter == fireRate) {
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

}
