package com.me.adventures.screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.buttons.*;
import com.me.adventures.main.AdventuresOfManuel;

public class GameOverScreen extends AbstractScreen {
	private List<Boton> botonesGameOver;
	private float ancho, alto;
	
	public GameOverScreen(AdventuresOfManuel adventures) {
		super(adventures);
		
		botonesGameOver = new ArrayList<Boton>();
	}
	
	@Override
	public void render(float delta) {
		if(botonesGameOver.isEmpty()){
			if(adventures.getTipoJuegoMustDie() == false){
				botonesGameOver.add(new BotonReintentar(adventures, new Vector2(370, 250)));
				botonesGameOver.add(new BotonMenu(adventures, new Vector2(470, 250)));
				botonesGameOver.add(new BotonExit(adventures, new Vector2(570, 250), false));
			}
			else{
				botonesGameOver.add(new BotonMenu(adventures, new Vector2(420, 250)));
				botonesGameOver.add(new BotonExit(adventures, new Vector2(520, 250), false));
			}
		}
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.app.getType() == ApplicationType.Android) {
			adventures.getCamera().update();
			batch.setProjectionMatrix(adventures.getCamera().combined);
		}
		
		for(Boton boton : botonesGameOver)
			boton.update();
		
		batch.begin();
		batch.draw(adventures.getManager().get("Pantallas/GameOver.png", Texture.class), 200, 100, 630, 410);
		for(Boton boton : botonesGameOver)
			boton.draw(batch);
		batch.end();
	}

	@Override
	public void show() {
		// Para reescalar
		ancho = adventures.getManager().get("Pantallas/GameOver.png", Texture.class).getWidth();
		alto = adventures.getManager().get("Pantallas/GameOver.png", Texture.class).getHeight();
		if(Gdx.graphics.getWidth() < adventures.getManager().get("Pantallas/GameOver.png", Texture.class).getWidth()) {
			float div = (float) ((float) Gdx.graphics.getWidth()) / ((float) adventures.getManager().get("Pantallas/GameOver.png", Texture.class).getWidth());
			ancho = adventures.getManager().get("Pantallas/GameOver.png", Texture.class).getWidth() * div;
			alto = adventures.getManager().get("Pantallas/GameOver.png", Texture.class).getHeight() * div;
		}
		adventures.getCamera().position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
		adventures.getCamera().zoom = 1;
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