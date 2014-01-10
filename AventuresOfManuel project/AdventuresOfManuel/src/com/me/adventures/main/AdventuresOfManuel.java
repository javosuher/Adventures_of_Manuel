package com.me.adventures.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.me.adventures.screens.*;

public class AdventuresOfManuel extends Game {
	private Screen nivel;
	private Screen ganar;
	
	@Override
	public void create() {
		nivel = new Nivel1(this);
		ganar = new Ganar(this);
		setScreen(nivel);
	}
	
	public void haGanado(){
		nivel.dispose();
		setScreen(ganar);
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
