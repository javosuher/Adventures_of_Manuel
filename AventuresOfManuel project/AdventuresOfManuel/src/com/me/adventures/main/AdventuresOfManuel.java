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
import com.me.adventures.pruebas.EnemyTest;
import com.me.adventures.screens.*;

public class AdventuresOfManuel extends Game {
	public AbstractScreen LOADING, START, MAIN, WIN, GAMEOVER, PAUSE;
	public AbstractScreen NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10;
	private Music musicaMenu, musicaNivel;
	private AssetManager manager;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Preferences preferencias;
	private boolean sonidoActivado;
	private boolean musicaActivada;
	private float div;
	//private float divMenus;
	//private float divNivel;
	private int nivelActual;
	private boolean tipoJuegoMustDie;
	
	@Override
	public void create() {
        Gdx.input.setCatchBackKey(true);
		nivelActual = 1;
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
		manager.load("Pantallas/NextLevel.png", Texture.class);
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
		manager.load("Pantallas/6.png", Texture.class);
		manager.load("Pantallas/7.png", Texture.class);
		manager.load("Pantallas/8.png", Texture.class);
		manager.load("Pantallas/9.png", Texture.class);
		manager.load("Pantallas/10.png", Texture.class);
		manager.load("Pantallas/BotonSFX.png", Texture.class);
		manager.load("Pantallas/BotonNoSFX.png", Texture.class);
		manager.load("Pantallas/BotonMusica.png", Texture.class);
		manager.load("Pantallas/BotonNoMusica.png", Texture.class);
		manager.load("Pantallas/BotonContinuar.png", Texture.class);
		manager.load("Pantallas/BotonMenu.png", Texture.class);
		manager.load("Pantallas/BotonSalir.png", Texture.class);
		manager.load("Pantallas/BotonNoTransparente.png", Texture.class);
		manager.load("Pantallas/BotonT.png", Texture.class);
		manager.load("Pantallas/BotonSiguienteNivel.png", Texture.class);
		manager.load("Pantallas/GameOver.png", Texture.class);
		manager.load("Pantallas/Pausa.png", Texture.class);
		manager.load("Pantallas/Start.png", Texture.class);
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
		WIN = new WinScreen(this);
		GAMEOVER = new GameOverScreen(this);
		PAUSE = new PauseScreen(this);
		iniciarNiveles();
		
		//Musica
		musicaMenu = manager.get("Musica/MenuInicial.mp3", Music.class);
		musicaNivel = manager.get("Musica/Niveles.mp3", Music.class);
	}
	
	public void iniciarNiveles(){
		NIVEL1 = new Nivel1(this, new Vector2(193, 464));
		NIVEL2 = new Nivel2(this, new Vector2(425, 116));
		NIVEL3 = new Nivel3(this, new Vector2(541, 174));
		NIVEL4 = new Nivel4(this, new Vector2(483, 58));
		NIVEL5 = new Nivel5(this, new Vector2(483, 58));
		NIVEL6 = new Nivel6(this, new Vector2(193, 232));
		NIVEL7 = new Nivel7(this, new Vector2(773, 58));
		NIVEL8 = new Nivel8(this, new Vector2(657, 522));
		NIVEL9 = new Nivel9(this, new Vector2(715, 58));
		NIVEL10 = new Nivel10(this, new Vector2(773, 348));
	}
	
	public void destruirNiveles() {
		MAIN = new MainScreen(this);
		NIVEL1 = new Nivel1(this, new Vector2(193, 464));
		NIVEL2 = new Nivel2(this, new Vector2(425, 116));
		NIVEL3 = new Nivel3(this, new Vector2(541, 174));
		NIVEL4 = new Nivel4(this, new Vector2(483, 58));
		NIVEL5 = new Nivel5(this, new Vector2(483, 58));
		NIVEL6 = new Nivel6(this, new Vector2(193, 232));
		NIVEL7 = new Nivel7(this, new Vector2(773, 58));
		NIVEL8 = new Nivel8(this, new Vector2(657, 522));
		NIVEL9 = new Nivel9(this, new Vector2(715, 58));
		NIVEL10 = new Nivel10(this, new Vector2(773, 348));		
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
	public float getDiv() {
		return div;
	}
	public void setDiv(float div) {
		this.div = div;
	}
	/*public float getDivMenu() {
		return divMenus;
	}
	public void setDivMenu(float div) {
		this.divMenus = div;
	}
	public float getDivNivel() {
		return divMenus;
	}
	public void setDivNivel(float div) {
		this.divMenus = div;
	}*/

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
	
	public void setTipoJuegoMustDie(boolean tipo){
		tipoJuegoMustDie = tipo;
	}
	
	public boolean getTipoJuegoMustDie(){
		return tipoJuegoMustDie;
	}
	
	public void siguienteNivel(){
		nivelActual++;
	}
	
	public void pasarSiguienteNivel(){
		nivelActual++;
		if(nivelActual == 1)
			setScreen(NIVEL1);
		else if(nivelActual == 2)
			setScreen(NIVEL2);
		else if(nivelActual == 3)
			setScreen(NIVEL3);
		else if(nivelActual == 4)
			setScreen(NIVEL4);
		else if(nivelActual == 5)
			setScreen(NIVEL5);
		else if(nivelActual == 6)
			setScreen(NIVEL6);
		else if(nivelActual == 7)
			setScreen(NIVEL7);
		else if(nivelActual == 8)
			setScreen(NIVEL8);
		else if(nivelActual == 9)
			setScreen(NIVEL9);
		else if(nivelActual == 10)
			setScreen(NIVEL10);
	}	
	
	public int getNivelActual(){
		return nivelActual;
	}
	
	public void gameOver(){
		setScreen(GAMEOVER);
	}
	
	public void reintentarNivel(){
		if(nivelActual == 1){
			NIVEL1 = new Nivel1(this, new Vector2(193, 464));
			setScreen(NIVEL1);
		}
		else if(nivelActual == 2){
			NIVEL2 = new Nivel2(this, new Vector2(425, 116));
			setScreen(NIVEL2);
		}
		else if(nivelActual == 3){
			NIVEL3 = new Nivel3(this, new Vector2(541, 174));
			setScreen(NIVEL3);
		}
		else if(nivelActual == 4){
			NIVEL4 = new Nivel4(this, new Vector2(483, 58));
			setScreen(NIVEL4);
		}
		else if(nivelActual == 5){
			NIVEL5 = new Nivel5(this, new Vector2(483, 58));
			setScreen(NIVEL5);
		}
		else if(nivelActual == 6){
			NIVEL6 = new Nivel6(this, new Vector2(193, 232));
			setScreen(NIVEL6);
		}
		else if(nivelActual == 7){
			NIVEL7 = new Nivel7(this, new Vector2(773, 58));
			setScreen(NIVEL7);
		}
		else if(nivelActual == 8){
			NIVEL8 = new Nivel8(this, new Vector2(657, 522));
			setScreen(NIVEL8);
		}
		else if(nivelActual == 9){
			NIVEL9 = new Nivel9(this, new Vector2(715, 58));
			setScreen(NIVEL9);
		}
		else if(nivelActual == 10){
			NIVEL10 = new Nivel10(this, new Vector2(773, 348));	
			setScreen(NIVEL10);
		}
	}
	
	public void continuarNivel(){
		if(nivelActual == 1){
			setScreen(NIVEL1);
		}
		else if(nivelActual == 2){
			setScreen(NIVEL2);
		}
		else if(nivelActual == 3){
			setScreen(NIVEL3);
		}
		else if(nivelActual == 4){
			setScreen(NIVEL4);
		}
		else if(nivelActual == 5){
			setScreen(NIVEL5);
		}
		else if(nivelActual == 6){
			setScreen(NIVEL6);
		}
		else if(nivelActual == 7){
			setScreen(NIVEL7);
		}
		else if(nivelActual == 8){
			setScreen(NIVEL8);
		}
		else if(nivelActual == 9){
			setScreen(NIVEL9);
		}
		else if(nivelActual == 10){
			setScreen(NIVEL10);
		}
	}
	
	public void iniciarMustDie(){
		tipoJuegoMustDie = true;
		nivelActual = 1;
		reintentarNivel();
	}
	
	public void setNivel(int nivel){
		nivelActual = nivel;
		reintentarNivel();
	}
	
	public void pruebaSuperada(){
		setScreen(new EnemyTest(this, new Vector2(541,348)));
	}
	
	public void pruebasFinalizadas(){
		setScreen(new PruebaSuperada(this));
	}
}
