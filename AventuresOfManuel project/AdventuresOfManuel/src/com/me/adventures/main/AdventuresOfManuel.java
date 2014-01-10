package com.me.adventures.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.screens.*;

public class AdventuresOfManuel extends Game {
	public AbstractScreen LOADING, NIVEL1, NIVEL2, NIVEL3;
	private AssetManager manager;
	private SpriteBatch batch;
	
	@Override
	public void create() {
		manager = new AssetManager();
		batch = new SpriteBatch();
		
		// Pantallas del juego
		/*PRINCIPAL = new GameScreen(this);*/
		NIVEL1 = new Nivel1(this, new Vector2(193, 464));
		NIVEL2 = new Nivel2(this, new Vector2(425,116));
		NIVEL3 = new Nivel3(this, new Vector2(541, 174));
		
		LOADING = new LoadingScreen(this);
		
		// Cargamos todos los elementos externos que usará el juego, como son las texturas y los sonidos.
		// Pantalla de cargado
		manager.load("Manolito/TablaSpritesManolitoTransparencia.png", Texture.class);
		manager.load("Enemigos/TablaCalaveraFinal.png", Texture.class);
		manager.load("Enemigos/TablaMedusa.png", Texture.class);
		manager.load("Enemigos/TablaSerpiente.png", Texture.class);
		manager.load("Miscelanea/Arbol.png", Texture.class);
		manager.load("Miscelanea/Bordes.png", Texture.class);
		manager.load("Miscelanea/Cofre.png", Texture.class);
		manager.load("Miscelanea/Corazon.png", Texture.class);
		manager.load("Miscelanea/Ganar.png", Texture.class);
		manager.load("Miscelanea/Huevo.png", Texture.class);
		manager.load("Miscelanea/Murallas.png", Texture.class);
		manager.load("Miscelanea/Nivel.png", Texture.class);
		manager.load("Miscelanea/ProyectilManolito.png", Texture.class);
		manager.load("Miscelanea/ProyectilMedusa.png", Texture.class);
		manager.load("Miscelanea/Roca.png", Texture.class);
		manager.load("Miscelanea/Suelo.png", Texture.class);
		manager.load("Miscelanea/TablaAgua.png", Texture.class);
		manager.load("Miscelanea/TablaPuente.png", Texture.class);
		manager.load("Miscelanea/TablaPuerta.png", Texture.class);
		manager.load("arial.png", Texture.class);
		
		//setScreen(LOADING);
		setScreen(NIVEL1);
	}
	
	public SpriteBatch getBatch() {
		return batch;
	}
	
	public AssetManager getManager() {
		return manager;
	}

	@Override
	public void dispose() {
		super.dispose();
		manager.dispose();
		batch.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
