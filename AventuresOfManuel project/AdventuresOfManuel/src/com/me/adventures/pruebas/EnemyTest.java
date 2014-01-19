package com.me.adventures.pruebas;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.characters.*;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.screens.Nivel;

public class EnemyTest extends Nivel {
	private BitmapFont font;
	private int eleccion;
	private boolean serpienteDerecha, serpienteIzquierda, finSerpiente, dragon;

	public EnemyTest(AdventuresOfManuel adventures, Vector2 posicionManuel) {
		super(adventures, posicionManuel);
		font = new BitmapFont(Gdx.files.internal("arial.fnt"), Gdx.files.internal("arial.png"), false);
		serpienteIzquierda = true;
		serpienteDerecha = false;
		eleccion = 0;
	}
	
	@Override
	protected void objetosDelNivel() {
		objetos = new ArrayList<ObjetoDelJuego>();
		corazones = new ArrayList<Corazon>();

		//Se introducen las paredes del nivel
		objetos.add(new Pared(adventures, new Vector2(0, 0), 1024, 58));
		objetos.add(new Pared(adventures, new Vector2(135, 0), 58, 754));
		objetos.add(new Pared(adventures, new Vector2(135, 696), 406, 58));
		objetos.add(new Pared(adventures, new Vector2(541, 725), 58, 29));
		salida = new Salida(adventures, new Vector2(483,696), 0); // 0 es puerta
		objetos.add(new Pared(adventures, new Vector2(599, 696), 290, 58));
		objetos.add(new Pared(adventures, new Vector2(831, 0), 58, 754));
		corazones.add(new Corazon(adventures, new Vector2(773,406), 2)); //otorga 2 proyectiles
		cofre = new Cofre(adventures, new Vector2(425,116), 2);
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes = new ArrayList<PersonajeDelJuegoEnemigo>();
		personajes.add(new Serpiente(adventures, new Vector2(541, 522), manuel));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		// Actualizamos personajes pantalla
		manuel.update();
		for(PersonajeDelJuego personaje : personajes){
			personaje.update();
		}
		for(int i = 0; i < personajesMovibles.size(); i++){
			personajesMovibles.get(i).moverEnBola();
			personajesMovibles.get(i).update();
		}
		
		// Pintamos la pantalla
		batch.begin();
		batch.draw(TexturaFondo, 135, 0, TexturaFondo.getWidth(), TexturaFondo.getHeight());
		
		serpiente();
		
		dragon();
		
		manuel.draw(batch);

		batch.end();
	}
	
	private void dragon(){
		if(dragon){
			font.draw(batch, "El dragón no atacará hasta que", 207, 638);
			font.draw(batch, "hayas recogido el corazón.", 207, 588);
			for(PersonajeDelJuego personaje : personajes) 
				personaje.draw(batch);
		}
	}

	private void serpiente() {        
		if(serpienteIzquierda){
			font.draw(batch, "Colócate a la izquierda de la serpiente", 207, 638);
			font.draw(batch, "Ella te seguirá con la mirada", 207, 588);
			for(PersonajeDelJuego personaje : personajes) 
				personaje.draw(batch);
			if(Gdx.input.isKeyPressed(Keys.LEFT) && manuel.getPosicion().x <= 541.0){
				  dibujar();
			}
		}
		if(serpienteDerecha){
			font.draw(batch, "Ahora prueba a colocarte a su derecha", 207, 638);
			for(PersonajeDelJuego personaje : personajes) 
				personaje.draw(batch);
			if(Gdx.input.isKeyPressed(Keys.RIGHT) && manuel.getPosicion().x > 541.0){
				  dibujar();
			}
		}
		if(finSerpiente){
			font.draw(batch, "Pulsa espacio para el siguiente enemigo", 207, 638);
			for(PersonajeDelJuego personaje : personajes) 
				personaje.draw(batch);
			if(Gdx.input.isKeyPressed(Keys.SPACE)){
				  dibujar();
			}
		}

	}
	
	private void dibujar(){
		switch(eleccion){
		  case 0: 
			  font.draw(batch, "La serpiente mira a la izquierda", 367, 638);
		      serpienteIzquierda = false;
		      serpienteDerecha = true;
		      eleccion++;
		      break;
		  case 1:
			  font.draw(batch, "La serpiente mira a la derecha", 207, 588);
			  serpienteDerecha = false;
			  finSerpiente = true;
			  eleccion++;
			  break;
		  case 2:
			  break;
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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

	@Override
	protected void mapaDelNivel() {
		// TODO Auto-generated method stub
		
	}
}
