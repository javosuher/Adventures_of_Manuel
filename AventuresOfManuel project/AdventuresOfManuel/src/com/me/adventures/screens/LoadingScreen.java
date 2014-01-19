package com.me.adventures.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.me.adventures.main.AdventuresOfManuel;

public class LoadingScreen extends AbstractScreen {
	private boolean zoomDeLosCojones;

	public LoadingScreen(AdventuresOfManuel adventures) {
		super(adventures);
		zoomDeLosCojones = true;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		if(adventures.getManager().update()) { // Si han cargado todas los recursos
			adventures.crearNiveles();
			adventures.setScreen(adventures.START);
		}
		
		if(adventures.getManager().isLoaded("Pantallas/Loading.png", Texture.class)) { // Si se ha cargado la imagen Loading.png
			/*float ancho = 0;
			float alto = 0;
			if(Gdx.graphics.getWidth() < adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth()) {
				float div = (float) ((float) Gdx.graphics.getWidth()) / ((float) adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth());
				ancho = adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth() * div;
				alto = adventures.getManager().get("Pantallas/Loading.png", Texture.class).getHeight() * div;
				adventures.setDiv(div);
			}
			float altura = Gdx.graphics.getHeight() - alto;
			batch.begin();
			batch.draw(adventures.getManager().get("Pantallas/Loading.png", Texture.class), 0, altura, ancho, alto);
			batch.end();*/
			
			float div = (float) ((float) Gdx.graphics.getWidth()) / ((float) adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth());
			adventures.setDiv(div);
			adventures.getCamera().position.set(adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth() / 2, adventures.getManager().get("Pantallas/Loading.png", Texture.class).getHeight() / 2, 0);
			float valorZoom = (float) Gdx.graphics.getWidth() / (float) adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth();
			
			if(zoomDeLosCojones) {
				adventures.getCamera().zoom = 1 / valorZoom;
				zoomDeLosCojones = false;
			}
			
			adventures.getCamera().update();
			batch.setProjectionMatrix(adventures.getCamera().combined);
			
			batch.begin();
			batch.draw(adventures.getManager().get("Pantallas/Loading.png", Texture.class), 0, 0, adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth(), adventures.getManager().get("Pantallas/Loading.png", Texture.class).getHeight());
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
