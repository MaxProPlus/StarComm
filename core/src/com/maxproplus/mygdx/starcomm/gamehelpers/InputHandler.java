package com.maxproplus.mygdx.starcomm.gamehelpers;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.maxproplus.mygdx.starcomm.gamescreen.GameScreen;
import com.maxproplus.mygdx.starcomm.gamescreen.Main;
import com.maxproplus.mygdx.starcomm.gamehelpers.AssetLoader;;

public class InputHandler implements InputProcessor {

	Main main;

	public InputHandler(Main main) {
		this.main = main;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (screenX > 640 - 79 && screenX < 640 + 76 && screenY > 360 - 19 && screenY < 360 + 16) {
			AssetLoader.start = new Texture("Start_game2.png");
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (screenX > 640 - 79 && screenX < 640 + 76 && screenY > 360 - 19 && screenY < 360 + 16) {
			main.setScreen(new GameScreen(main));
			return true;
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		if (screenX > 640 - 79 && screenX < 640 + 76 && screenY > 360 - 19 && screenY < 360 + 16) {
			AssetLoader.start = new Texture("Start_game1.png");
		} else
			AssetLoader.start = new Texture("Start_game.png");
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
