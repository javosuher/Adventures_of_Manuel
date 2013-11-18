package com.me.adventures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainScreen implements Screen {
	private AdventuresOfManuel manuel;
	private Texture TexturaFondo;
	SpriteBatch batch;
	

	public MainScreen(AdventuresOfManuel manuel) {
		this.manuel = manuel;
		TexturaFondo = new Texture("data/TexturaFondo.png");
		TexturaFondo.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		batch = new SpriteBatch(); 
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(TexturaFondo, 0, 0, TexturaFondo.getWidth(), TexturaFondo.getHeight());
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
