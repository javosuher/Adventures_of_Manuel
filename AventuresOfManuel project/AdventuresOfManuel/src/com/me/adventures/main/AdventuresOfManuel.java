package com.me.adventures.main;

import com.badlogic.gdx.Game;
import com.me.adventures.screens.*;

public class AdventuresOfManuel extends Game {
	
	@Override
	public void create() {		
		setScreen(new Level1Screen(this));
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
