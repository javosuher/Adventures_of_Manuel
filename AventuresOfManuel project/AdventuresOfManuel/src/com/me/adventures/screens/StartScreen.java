package com.me.adventures.screens;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.pruebas.*;

public class StartScreen extends AbstractScreen {
	private boolean pruebas; // Sirve para ver las pruebas

	public StartScreen(AdventuresOfManuel adventures) {
		super(adventures);
		pruebas = true;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.input.isTouched()) {
			if(pruebas)
				adventures.setScreen(new NivelTest(adventures, new Vector2(541,348)));
			else
				adventures.setScreen(adventures.MAIN);
		}
		
		float ancho = adventures.getManager().get("Pantallas/Start.png", Texture.class).getWidth();
		float alto = adventures.getManager().get("Pantallas/Start.png", Texture.class).getHeight();
		float altura = 0;
		if(Gdx.app.getType() == ApplicationType.Desktop) {
			if(Gdx.app.getType() == ApplicationType.Desktop) {
				if(Gdx.graphics.getWidth() < adventures.getManager().get("Pantallas/Start.png", Texture.class).getWidth()) {
					float div = (float) ((float) Gdx.graphics.getWidth()) / ((float) adventures.getManager().get("Pantallas/Start.png", Texture.class).getWidth());
					ancho = ancho * div;
					alto = alto * div;
				}
				altura = Gdx.graphics.getHeight() - alto;
			}
		}
		if(Gdx.app.getType() == ApplicationType.Android) {
			adventures.getCamera().update();
			batch.setProjectionMatrix(adventures.getCamera().combined);
		}
		batch.begin();
		batch.draw(adventures.getManager().get("Pantallas/Start.png", Texture.class), 0, altura, ancho, alto);
		batch.end();/*
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
        if(Gdx.input.isTouched()) {
        	adventures.setScreen(adventures.MAIN);
        }
        
        float ancho = 0;
        float alto = 0;
        if(Gdx.graphics.getWidth() < adventures.getManager().get("Pantallas/Start.png", Texture.class).getWidth()) {
                float div = (float) ((float) Gdx.graphics.getWidth()) / ((float) adventures.getManager().get("Pantallas/Start.png", Texture.class).getWidth());
                ancho = adventures.getManager().get("Pantallas/Start.png", Texture.class).getWidth() * div;
                alto = adventures.getManager().get("Pantallas/Start.png", Texture.class).getHeight() * div;
        }
        float altura = Gdx.graphics.getHeight() - alto;
        batch.begin();
        batch.draw(adventures.getManager().get("Pantallas/Start.png", Texture.class), 0, altura, ancho, alto);
        batch.end();*/
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
