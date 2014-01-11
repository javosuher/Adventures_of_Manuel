package com.me.adventures.pruebas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.me.adventures.screens.Ganar;
import com.me.adventures.screens.*;

public class MainTest extends Game {
	private Screen nivel;
	private Screen ganar;
	
	@Override
	public void create() {
		nivel = new NivelTest(this);
		ganar = new PruebaSuperada(this);
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
