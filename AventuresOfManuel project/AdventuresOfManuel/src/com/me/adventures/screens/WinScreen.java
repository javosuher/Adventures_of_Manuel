package com.me.adventures.screens;

import com.badlogic.gdx.Gdx;
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
		
		batch.begin();
		batch.draw(adventures.getManager().get("Pantallas/NextLevel.png", Texture.class), 0, 410, 630, 410);
		batch.end();
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