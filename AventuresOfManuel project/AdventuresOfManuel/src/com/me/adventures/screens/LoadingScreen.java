package com.me.adventures.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.me.adventures.main.AdventuresOfManuel;

public class LoadingScreen extends AbstractScreen {

	public LoadingScreen(AdventuresOfManuel adventures) {
		super(adventures);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		if(adventures.getManager().update()) { // Si han cargado todas las imagenes
			adventures.crearNiveles();
			adventures.setScreen(adventures.MAIN);
		}
		
		if(adventures.getManager().isLoaded("Pantallas/Loading.png", Texture.class)) { // Si se ha cargado la imagen Loading.png
			float ancho = 0;
			float alto = 0;
			if(Gdx.graphics.getWidth() < adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth()) {
				float div = (float) ((float) Gdx.graphics.getWidth()) / ((float) adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth());
				ancho = adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth() * div;
				alto = adventures.getManager().get("Pantallas/Loading.png", Texture.class).getHeight() * div;
			}
			float altura = Gdx.graphics.getHeight() - alto;
			batch.begin();
			batch.draw(adventures.getManager().get("Pantallas/Loading.png", Texture.class), 0, altura, ancho, alto);
			batch.end();
		}
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
	public void dispose() {
		// TODO Auto-generated method stub
	}
}
