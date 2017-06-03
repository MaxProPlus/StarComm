package com.maxproplus.mygdx.starcomm.gameworld;

import com.maxproplus.mygdx.starcomm.gameobjects.Background;
import com.maxproplus.mygdx.starcomm.gameobjects.Level;

public class GameWorld {

	Background bg;
	Level level;

	public GameWorld() {
		bg = new Background();
		level = new Level();

	}

	public void update() {
		bg.update();
		level.update();
	}
	
	public void dispose() {
		bg.dispose();
		level.dispose();
	}

}
