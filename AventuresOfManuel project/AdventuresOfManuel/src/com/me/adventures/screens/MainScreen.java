package com.me.adventures.screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.buttons.*;
import com.me.adventures.main.AdventuresOfManuel;

public class MainScreen extends AbstractScreen {
	private List<Boton> botones;

	public MainScreen(AdventuresOfManuel adventures) {
		super(adventures);
	}
	
	@Override
	public void show() {
		botones = new ArrayList<Boton>();
		botones.add(new BotonModoHistoria(adventures, new Vector2(100, Gdx.graphics.getHeight() - 100)));
		botones.add(new BotonModoMustDie(adventures, new Vector2(100, Gdx.graphics.getHeight() - 150)));
		botones.add(new BotonOpciones(adventures, new Vector2(100, Gdx.graphics.getHeight() - 200)));
		botones.add(new BotonExit(adventures, new Vector2(100, Gdx.graphics.getHeight() - 250)));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		for(Boton boton : botones)
			boton.update();
		
		batch.begin();
		for(Boton boton : botones)
			boton.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
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
