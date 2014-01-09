package com.me.adventures.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.adventures.main.AdventuresOfManuel;

public abstract class AbstractScreen implements Screen {
	protected AdventuresOfManuel adventures;
	protected SpriteBatch batch;

	public AbstractScreen(AdventuresOfManuel adventures) {
		this.adventures = adventures;
		this.batch = adventures.getBatch();
	}
	
	public AdventuresOfManuel getAdventures() {
		return adventures;
	}
	public SpriteBatch getBatch() {
		return batch;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}
}
