package com.maxproplus.mygdx.starcomm.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.maxproplus.mygdx.starcomm.gamehelpers.AssetLoader;

public class Hero {

	
	protected Vector2 position;
	Rectangle rectangle;
	protected float speed;
	protected int hp;
	public Weapon weapon;

	protected Hero() {
		
		position = new Vector2(0, 720 / 2);
		rectangle = new Rectangle(position.x, position.y, AssetLoader.hero.getWidth(), AssetLoader.hero.getHeight());
		speed = 10f;
		hp = 100;
		weapon = new Weapon(1, 200);
	}

	protected void render(SpriteBatch batch) {
		batch.draw(AssetLoader.hero, position.x, position.y);
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
	
	public void takeDamege(int dmg) {
		hp -= dmg;
		position.x=50;
		if (hp <= 0) {
			dispose();
			return;
		}
	}
	
	public void dispose() {
		weapon.dispose();
	}

}
