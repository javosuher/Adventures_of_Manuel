package com.me.adventures;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.pruebas.MainTest;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Adventures Of Manuel";
		cfg.useGL20 = true;
		cfg.width = 1024;
		cfg.height = 754;
		
		new LwjglApplication(new MainTest(), cfg);
	}
}
