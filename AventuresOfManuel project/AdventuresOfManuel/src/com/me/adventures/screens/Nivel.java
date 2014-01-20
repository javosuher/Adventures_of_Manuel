package com.me.adventures.screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.characters.Cofre;
import com.me.adventures.characters.Colision;
import com.me.adventures.characters.Corazon;
import com.me.adventures.characters.Manuel;
import com.me.adventures.characters.MapaDelJuego;
import com.me.adventures.characters.ObjetoDelJuego;
import com.me.adventures.characters.PersonajeDelJuego;
import com.me.adventures.characters.PersonajeDelJuegoEnemigo;
import com.me.adventures.characters.Salida;
import com.me.adventures.main.AdventuresOfManuel;

public abstract class Nivel extends AbstractScreen {
	protected Texture TexturaFondo;
	protected Manuel manuel;
	protected Cofre cofre;
	protected List<Corazon> corazones;
	protected List<ObjetoDelJuego> objetos;
	protected List<ObjetoDelJuego> objetosEnemigos;
	protected List<PersonajeDelJuegoEnemigo> personajes;
	protected List<PersonajeDelJuegoEnemigo> personajesMovibles;
	protected List<MapaDelJuego> mapaNivel;
	protected Colision colisiones;
	protected Salida salida;
	
	public Nivel(AdventuresOfManuel adventures, Vector2 posicionManuel) {
		super(adventures);
		TexturaFondo = adventures.getManager().get("Miscelanea/Nivel.png", Texture.class);
		
		TexturaFondo.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		objetos = new ArrayList<ObjetoDelJuego>();
		objetosEnemigos = new ArrayList<ObjetoDelJuego>();
		corazones = new ArrayList<Corazon>();
		mapaNivel = new ArrayList<MapaDelJuego>();
		personajes = new ArrayList<PersonajeDelJuegoEnemigo>();
		
		manuel = new Manuel(adventures, posicionManuel);
		personajesMovibles = new ArrayList<PersonajeDelJuegoEnemigo>();
		objetosDelNivel();
		personajesDelNivel();
		mapaDelNivel();
		iniciarColisiones();
	}
	
	@Override
	public void show() {
		// Para reescalar
        if(Gdx.graphics.getHeight() < adventures.getManager().get("Miscelanea/Nivel.png", Texture.class).getHeight() && Gdx.app.getType() == ApplicationType.Android) {
                float div = (float) ((float) Gdx.graphics.getHeight()) / ((float) adventures.getManager().get("Miscelanea/Nivel.png", Texture.class).getHeight());
                adventures.getCamera().position.set((135 + Gdx.graphics.getWidth()) / 2, TexturaFondo.getHeight() / 2, 0);
                adventures.getCamera().zoom = div + 1;
        }
        else
                adventures.getCamera().position.set(Gdx.graphics.getWidth() / 2, TexturaFondo.getHeight() / 2, 0);
	}
	
	protected abstract void objetosDelNivel();
	protected abstract void personajesDelNivel();
	protected abstract void mapaDelNivel();
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		if(adventures.isMusicaActivada()) { // Poner musica Nivel
			if(adventures.getMusicaMenu().isPlaying())
				adventures.getMusicaMenu().stop();
			if(!adventures.getMusicaNivel().isPlaying())
				adventures.getMusicaNivel().play();
		}
		
		if(Gdx.app.getType() == ApplicationType.Android) {
			adventures.getCamera().update();
			batch.setProjectionMatrix(adventures.getCamera().combined);
		}
		
		// Actualizamos personajes pantalla
		manuel.update();

		for(ObjetoDelJuego objeto: objetos){
			objeto.update();
		}
		
		for(MapaDelJuego mapa : mapaNivel){
			mapa.update();
		}
		for(PersonajeDelJuego personaje : personajes){
			personaje.update();
		}
		for(int i = 0; i < personajesMovibles.size(); i++){
			personajesMovibles.get(i).moverEnBola();
			personajesMovibles.get(i).update();
		}
		
		if(Gdx.input.isKeyPressed(Keys.MENU)) {
			adventures.destruirNiveles();
			adventures.setScreen(adventures.MAIN);
		}
		
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)){
			adventures.setScreen(adventures.PAUSE);
		}
		
		// Pintamos la pantalla
		batch.begin();
		batch.draw(TexturaFondo, 135, 0, TexturaFondo.getWidth(), TexturaFondo.getHeight());
		salida.draw(batch);
		
		for(int i = 0; i < corazones.size(); i++){
			if(corazones.get(i).getEstado() == false){
				corazones.remove(i);
				i--;
			}
		}
		
		for(Corazon corazon : corazones){
			corazon.draw(batch);
		}
		cofre.draw(batch);
		
		if(salida.salidaAbierta() == true){
			personajes.clear();
			personajesMovibles.clear();
		}
		
		for(ObjetoDelJuego objeto : objetos) {
			objeto.draw(batch);
		}

		for(MapaDelJuego mapa : mapaNivel){
			mapa.draw(batch);
		}
		
		for(PersonajeDelJuego personaje : personajes){
			personaje.draw(batch);
		}
		
		for(PersonajeDelJuego personaje : personajesMovibles){
			personaje.draw(batch);
		}
	
		if(salida.salidaAbierta() == true){
			if(manuel.getPosicion().x == (salida.getPosicion().x + 58) && manuel.getPosicion().y == (salida.getPosicion().y - 29)){
				adventures.setScreen(adventures.WIN);
			}
		}
		manuel.draw(batch);
		batch.end();
	}
	
	protected void iniciarColisiones(){
		colisiones = new Colision(adventures, manuel, personajes, objetos, personajesMovibles, corazones, cofre, salida, objetosEnemigos);
		manuel.setColision(colisiones);
		for(PersonajeDelJuego p : personajes){
			p.setColision(colisiones);
		}
		for(PersonajeDelJuego p : personajesMovibles){
			p.setColision(colisiones);
		}
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
