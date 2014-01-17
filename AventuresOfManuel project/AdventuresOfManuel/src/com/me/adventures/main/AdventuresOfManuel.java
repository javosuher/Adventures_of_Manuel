package com.me.adventures.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.screens.*;

public class AdventuresOfManuel extends Game {
	public AbstractScreen LOADING, START, MAIN, NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5;
	private Music musicaMenu, musicaNivel;
	private AssetManager manager;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Preferences preferencias;
	private boolean sonidoActivado;
	private boolean musicaActivada;
	
	@Override
	public void create() {
		manager = new AssetManager();
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		preferencias = Gdx.app.getPreferences("-_PreferencesManuel-JMDCG-PINF-_");
		sonidoActivado = preferencias.getBoolean("Sonido", true);
		musicaActivada = preferencias.getBoolean("Musica", true);
		
		// Cargamos todos los elementos externos que usará el juego, como son las texturas y los sonidos.
		manager.load("Pantallas/Loading.png", Texture.class);
		manager.load("Pantallas/FondoMenu.png", Texture.class);
		manager.load("Pantallas/Start.png", Texture.class);
		manager.load("Manolito/TablaSpritesManolitoTransparencia.png", Texture.class);
		manager.load("Enemigos/bloque.png", Texture.class);
		manager.load("Enemigos/TablaCalaveraFinal.png", Texture.class);
		manager.load("Enemigos/TablaDragon.png", Texture.class);
		manager.load("Enemigos/TablaBichoVerde.png", Texture.class);
		manager.load("Enemigos/TablaMedusa.png", Texture.class);
		manager.load("Enemigos/TablaSerpiente.png", Texture.class);
		manager.load("Enemigos/TablaFantasma.png", Texture.class);
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
		manager.load("Pantallas/1.png", Texture.class);
		manager.load("Pantallas/2.png", Texture.class);
		manager.load("Pantallas/3.png", Texture.class);
		manager.load("Pantallas/4.png", Texture.class);
		manager.load("Pantallas/5.png", Texture.class);
		manager.load("Pantallas/BotonConfiguracionEfectos.png", Texture.class);
		manager.load("Pantallas/BotonConfiguracionMusica.png", Texture.class);
		manager.load("Pantallas/BotonContinuar.png", Texture.class);
		manager.load("Pantallas/BotonExit.png", Texture.class);
		manager.load("Pantallas/BotonInstrucciones.png", Texture.class);
		manager.load("Pantallas/BotonModoHistoria.png", Texture.class);
		manager.load("Pantallas/BotonModoMustDie.png", Texture.class);
		manager.load("Pantallas/BotonOpciones.png", Texture.class);
		manager.load("Pantallas/BotonReintentar.png", Texture.class);
		manager.load("Pantallas/BotonSiguienteNivel.png", Texture.class);
		manager.load("Musica/Button.mp3", Sound.class);
		manager.load("Musica/DisparoDragon.mp3", Sound.class);
		manager.load("Musica/DisparoManolito.mp3", Sound.class);
		manager.load("Musica/Ganar.mp3", Sound.class);
		manager.load("Musica/Perder.mp3", Sound.class);
		manager.load("Musica/MenuInicial.mp3", Music.class);
		manager.load("Musica/Niveles.mp3", Music.class);
		
		LOADING = new LoadingScreen(this); // Necesario
		setScreen(LOADING);
	}
	
	public void crearNiveles() {
		// Pantallas del juego
		START = new StartScreen(this);
		MAIN = new MainScreen(this);
		NIVEL1 = new Nivel1(this, new Vector2(193, 464));
		NIVEL2 = new Nivel2(this, new Vector2(425,116));
		NIVEL3 = new Nivel3(this, new Vector2(541, 174));
		NIVEL4 = new Nivel4(this, new Vector2(483, 58));
		NIVEL5 = new Nivel5(this, new Vector2(483, 58));
		
		//Musica
		musicaMenu = manager.get("Musica/MenuInicial.mp3", Music.class);
		musicaNivel = manager.get("Musica/Niveles.mp3", Music.class);
	}
	
	public void destruirNiveles() {
		MAIN = new MainScreen(this);
		NIVEL1 = new Nivel1(this, new Vector2(193, 464));
		NIVEL2 = new Nivel2(this, new Vector2(425,116));
		NIVEL3 = new Nivel3(this, new Vector2(541, 174));
		NIVEL4 = new Nivel4(this, new Vector2(483, 58));
		NIVEL5 = new Nivel5(this, new Vector2(483, 58));
	}
	
	public SpriteBatch getBatch() {
		return batch;
	}
	public AssetManager getManager() {
		return manager;
	}
	public OrthographicCamera getCamera() {
		return camera;
	}
	public Preferences getPreferencias() {
		return preferencias;
	}
	public Music getMusicaMenu() {
		return musicaMenu;
	}
	public Music getMusicaNivel() {
		return musicaNivel;
	}
	public boolean isSonidoActivado() {
		return sonidoActivado;
	}
	public void pressSonido() {
		if(sonidoActivado)
			sonidoActivado = false;
		else
			sonidoActivado = true;
	}
	public boolean isMusicaActivada() {
		return musicaActivada;
	}
	public void pressMusica() {
		if(musicaActivada)
			musicaActivada = false;
		else
			musicaActivada = true;
	}

	@Override
	public void dispose() {
		super.dispose();
		preferencias.putBoolean("Sonido", sonidoActivado);
		preferencias.putBoolean("Musica", musicaActivada);
		preferencias.flush();
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
