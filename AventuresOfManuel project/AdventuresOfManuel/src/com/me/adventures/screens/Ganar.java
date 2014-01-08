package com.me.adventures.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.adventures.main.AdventuresOfManuel;

public class Ganar implements Screen{
	private AdventuresOfManuel adventurasDeManuel;
	private Texture TexturaGanar;
	private SpriteBatch batch;
	
	public Ganar(AdventuresOfManuel adventurasDeManuel){
		this.adventurasDeManuel = adventurasDeManuel;
		TexturaGanar = new Texture("Miscelanea/Ganar.png");
		TexturaGanar.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		batch = new SpriteBatch();
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		batch.begin();
		batch.draw(TexturaGanar, 167, 182, TexturaGanar.getWidth(), TexturaGanar.getHeight());
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