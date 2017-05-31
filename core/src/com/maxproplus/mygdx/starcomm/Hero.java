package com.maxproplus.mygdx.starcomm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Hero {

	private Texture texture;
	protected Vector2 position;
	protected Rectangle rectangle;
	protected float speed;
	protected int hp;
	public Weapon weapon;

	protected Hero() {
		texture = new Texture("ship64.png");
		position = new Vector2(0, 720 / 2);
		rectangle = new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
		speed = 10f;
		weapon = new Weapon(1, 200);
	}

	protected void render(SpriteBatch batch) {
		batch.draw(texture, position.x, position.y);
		weapon.render(batch);

	}

	protected void update() {
		weapon.update();
		if (Gdx.input.isKeyPressed(Input.Keys.D))
			position.x += speed;
		if (Gdx.input.isKeyPressed(Input.Keys.A))
			position.x -= speed;
		if (Gdx.input.isKeyPressed(Input.Keys.W))
			position.y += speed;
		if (Gdx.input.isKeyPressed(Input.Keys.S))
			position.y -= speed;
		if (position.x < 0)
			position.x = 0;
		if (position.x > 1216)
			position.x = 1216;
		if (position.y > 720)
			position.y = -64;
		if (position.y < -64)
			position.y = 720;
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			weapon.fire(position.x, position.y);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.NUM_1))
				weapon = new Weapon(1,200); 
		if (Gdx.input.isKeyPressed(Input.Keys.NUM_2))
			weapon = new Weapon(2,200); 

	}
	
	public void dispose() {
		texture.dispose();
		weapon.dispose();
	}

}
