package com.maxproplus.mygdx.starcomm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid extends Hero {

	private static Texture texture;
	private float angle;
	private float scale;
	public Circle circle;

	protected Asteroid() {
		texture = new Texture("asteroid64.png");
		position = new Vector2(Gdx.graphics.getWidth() + (float) Math.random() * Gdx.graphics.getWidth(),
				(float) Math.random() * Gdx.graphics.getHeight());
		hp = 3 + (int) (Math.random() * 13);
		speed = 4.0f + (float) Math.random() * 4.0f;
		angle = (float) Math.random() * 360;
		circle = new Circle(position, 28 * (0.5f + hp * 0.1f));
	}

	protected void render(SpriteBatch batch) {
		scale = 0.5f + hp * 0.1f;
		batch.draw(texture, position.x - 32, position.y - 32, 32, 32, 64, 64, scale, scale, angle, 0, 0, 64, 64, false,
				false);
	}

	protected void recreate() {
		position.x = Gdx.graphics.getWidth() + (float) Math.random() * Gdx.graphics.getWidth();
		position.y = (float) Math.random() * Gdx.graphics.getHeight();
		hp = 3 + (int) (Math.random() * 13);
		speed = 4.0f + (float) Math.random() * 4.0f;
		angle = (float) Math.random() * 360;
		circle.radius = 28 * (0.5f + hp * 0.1f);
	}

	protected void update() {
		position.x -= speed;
		angle += speed / 4;
		if (position.x < -100)
			recreate();
		circle.x = position.x;
		circle.y = position.y;
	}

	public void takeDamage(int dem) {
		hp -= dem;
		if (hp <= 0) {
			recreate();
			return;
		}
		speed = 4.0f + (float) Math.random() * 4.0f;
		circle.radius = 28 * (0.5f + hp * 0.1f);
	}

}
