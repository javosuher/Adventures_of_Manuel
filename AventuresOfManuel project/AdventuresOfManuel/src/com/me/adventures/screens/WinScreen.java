package com.me.adventures.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.me.adventures.main.AdventuresOfManuel;

public class WinScreen extends AbstractScreen {

	public WinScreen(AdventuresOfManuel adventures) {
		super(adventures);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.input.isTouched())
			adventures.pasarSiguienteNivel();
		
		if(Gdx.app.getType() == ApplicationType.Android) {
			adventures.getCamera().update();
			batch.setProjectionMatrix(adventures.getCamera().combined);
		}
		
		batch.begin();
		batch.draw(adventures.getManager().get("Pantallas/NextLevel.png", Texture.class), 0, 410, 630, 410);
		batch.end();
	}

	@Override
	public void show() {
		// Para reescalar
        
		if(Gdx.app.getType() == ApplicationType.Android) {
			adventures.getCamera().position.set((135 + Gdx.graphics.getWidth()) / 2, Gdx.graphics.getHeight() / 2, 0);
	        adventures.getCamera().zoom = 1;	
		}
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