package com.maxproplus.mygdx.starcomm.gamehelpers;

import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {

	public static Texture background;
	public static Texture textureStar;

	public static Texture start;
	public static Texture hero;
	public static Texture asteroid;
	public static Texture bullet;

	public static void load() {
		background = new Texture("staticback.jpg");
		textureStar = new Texture("star12.tga");
		start = new Texture("Start_game.png");
		hero = new Texture("ship64.png");
		asteroid = new Texture("asteroid64.png");
	}

}
