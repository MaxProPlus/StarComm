package com.maxproplus.mygdx.starcomm.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameRender {
	
	private GameWorld world;
	SpriteBatch batch;
	

	public GameRender(GameWorld world, SpriteBatch batch) {
		this.world = world;
		this.batch = batch;
	}
	
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		world.bg.render(batch);
		world.level.render(batch);
		batch.end();
	}
	
	public void dispose() {
		
	}

}
