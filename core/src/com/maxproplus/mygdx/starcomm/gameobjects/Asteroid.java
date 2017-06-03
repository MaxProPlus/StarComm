package com.maxproplus.mygdx.starcomm.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.maxproplus.mygdx.starcomm.gamehelpers.AssetLoader;

public class Asteroid extends Hero {

	
	private float angle;
	private float scale;
	public Circle circle;
	public int dmg;

	protected Asteroid() {
		
		position = new Vector2(Gdx.graphics.getWidth() + (float) Math.random() * Gdx.graphics.getWidth(),
				(float) Math.random() * Gdx.graphics.getHeight());
		hp = 3 + (int) (Math.random() * 13);
		speed = 4.0f + (float) Math.random() * 4.0f;
		angle = (float) Math.random() * 360;
		circle = new Circle(position, 28 * (0.5f + hp * 0.1f));
		dmg=hp;
	}

	protected void render(SpriteBatch batch) {
		scale = 0.5f + hp * 0.1f;
		batch.draw(AssetLoader.asteroid, position.x - 32, position.y - 32, 32, 32, 64, 64, scale, scale, angle, 0, 0, 64, 64, false,
				false);
	}

	protected void recreate() {
		position.x = Gdx.graphics.getWidth() + (float) Math.random() * Gdx.graphics.getWidth();
		position.y = (float) Math.random() * Gdx.graphics.getHeight();
		hp = 3 + (int) (Math.random() * 13);
		dmg=hp;
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

	public void takeDamage(int dmg) {
		hp -= dmg;
		if (hp <= 0) {
			recreate();
			return;
		}
		speed = 4.0f + (float) Math.random() * 4.0f;
		circle.radius = 28 * (0.5f + hp * 0.1f);
	}

	public void dispose() {
	}

}
