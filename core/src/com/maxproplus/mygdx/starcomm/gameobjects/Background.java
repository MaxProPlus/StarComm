package com.maxproplus.mygdx.starcomm.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.maxproplus.mygdx.starcomm.gamehelpers.AssetLoader;

public class Background {
	private class Star {
		private float speed;
		private Vector2 pos;

		public Star() {
			speed = 1.0f + (float) (Math.random() * 4);
			pos = new Vector2((float) (Math.random() * 1280), (float) (Math.random() * 720));
		}

		public void update() {
			pos.x -= speed;
			if (pos.x < -20) {
				pos.x = 1280;
				pos.y = (float) (Math.random() * 720);
			}
		}
	}

	
	private Star[] stars;

	public Background() {
		stars = new Star[240];
		for (int i = 0; i < stars.length; i++) {
			stars[i] = new Star();
		}
	}

	public void render(SpriteBatch batch) {
		batch.disableBlending();
		batch.draw(AssetLoader.background, 0, 0);
		batch.enableBlending();
		for (int i = 0; i < stars.length; i++) {
			batch.draw(AssetLoader.textureStar, stars[i].pos.x, stars[i].pos.y);
		}

	}

	public void update() {
		for (int i = 0; i < stars.length; i++) {
			stars[i].update();
		}
	}
	
	public void dispose() {
	}

}
