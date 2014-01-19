package com.me.adventures.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.me.adventures.main.AdventuresOfManuel;

public class LoadingScreen extends AbstractScreen {
	private boolean aplicaZoom;

	public LoadingScreen(AdventuresOfManuel adventures) {
		super(adventures);
		aplicaZoom = true;
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
			float ancho = adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth();
			float alto = adventures.getManager().get("Pantallas/Loading.png", Texture.class).getHeight();
			float altura = 0;
			if(Gdx.graphics.getWidth() < adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth()) {
				float div = (float) ((float) Gdx.graphics.getWidth()) / ((float) adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth());
				adventures.setDivMenu(div);
				if(Gdx.app.getType() == ApplicationType.Desktop) {
					ancho = ancho * div;
					alto = alto * div;
					altura = Gdx.graphics.getHeight() - alto;
				}
				else if(Gdx.app.getType() == ApplicationType.Android) {
					adventures.getCamera().position.set(adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth() / 2, adventures.getManager().get("Pantallas/Loading.png", Texture.class).getHeight() / 2, 0);
					if(aplicaZoom) {
						adventures.getCamera().zoom = 1 / div;
						aplicaZoom = false;
					}
				}
			}
			if(Gdx.app.getType() == ApplicationType.Android) {
				adventures.getCamera().update();
				batch.setProjectionMatrix(adventures.getCamera().combined);
			}
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
