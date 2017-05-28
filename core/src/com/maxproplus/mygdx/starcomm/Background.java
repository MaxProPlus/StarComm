package com.maxproplus.mygdx.starcomm;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

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

	private Texture background;
	private Texture textureStar;
	private Star[] stars;

	protected Background() {
		background = new Texture("staticback.jpg");
		textureStar = new Texture("star12.tga");
		stars = new Star[240];
		for (int i = 0; i < stars.length; i++) {
			stars[i] = new Star();
		}
	}

	protected void render(SpriteBatch batch) {
		batch.draw(background, 0, 0);
		for (int i = 0; i < stars.length; i++) {
			batch.draw(textureStar, stars[i].pos.x, stars[i].pos.y);
		}

	}

	protected void update() {
		for (int i = 0; i < stars.length; i++) {
			stars[i].update();
		}
	}

}
