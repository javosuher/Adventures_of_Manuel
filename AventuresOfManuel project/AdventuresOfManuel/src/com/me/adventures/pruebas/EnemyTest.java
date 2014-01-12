package com.me.adventures.pruebas;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.characters.*;
import com.me.adventures.screens.Nivel;

public class EnemyTest extends Nivel {
	//private MainTest adventurasDeManuel;
	private Texture TexturaFondo;
	private SpriteBatch batch;
	private Manuel manuel;
	private List<ObjetoDelJuego> objetos;
	private List<PersonajeDelJuego> personajes;
	private List<PersonajeDelJuego> personajesMovibles;
	private Colision colisiones;
	private Cofre cofre;
	private List<Corazon> corazones;
	private Salida salida;
	private BitmapFont font;
	private int eleccion;
	private boolean serpienteDerecha, serpienteIzquierda;

	public EnemyTest(MainTest adventuras_del_manuel) {
		font = new BitmapFont(Gdx.files.internal("arial.fnt"), Gdx.files.internal("arial.png"), false);
		serpienteIzquierda = true;
		serpienteDerecha = false;
		//this.adventurasDeManuel = adventuras_del_manuel;
		TexturaFondo = new Texture("Miscelanea/Nivel.png");
		TexturaFondo.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		manuel = new Manuel(new Vector2(541,348));
		
		objetosDelNivel();
		personajesDelNivel();
		personajesMovibles = new ArrayList<PersonajeDelJuego>();
		colisiones = new Colision(manuel, personajes, objetos, personajesMovibles, corazones, cofre, salida);
		
		manuel.setColision(colisiones);
		for(PersonajeDelJuego p : personajes){
			p.setColision(colisiones);
		}
		
		eleccion = 0;
		
		batch = new SpriteBatch();
	}
	
	@Override
	protected void objetosDelNivel() {
		objetos = new ArrayList<ObjetoDelJuego>();
		corazones = new ArrayList<Corazon>();

		//Se introducen las paredes del nivel
		objetos.add(new Pared(new Vector2(0, 0), 1024, 58));
		objetos.add(new Pared(new Vector2(135, 0), 58, 754));
		objetos.add(new Pared(new Vector2(135, 696), 406, 58));
		objetos.add(new Pared(new Vector2(541, 725), 58, 29));
		salida = new Salida(new Vector2(483,696), "PUERTA");
		objetos.add(new Pared(new Vector2(599, 696), 290, 58));
		objetos.add(new Pared(new Vector2(831, 0), 58, 754));

		corazones.add(new Corazon(new Vector2(773,406), 2)); //otorga 2 proyectiles
		cofre = new Cofre(new Vector2(425,116), 2);
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes = new ArrayList<PersonajeDelJuego>();
		personajes.add(new Serpiente(new Vector2(541, 522), manuel));
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
		
		manuel.draw(batch);

		batch.end();
	}

	private void serpiente() {        
		if(serpienteIzquierda){
			font.draw(batch, "Colócate a la izquierda de la serpiente", 207, 638);
			font.draw(batch, "Ella te seguirá con la mirada", 207, 588);
			for(PersonajeDelJuego personaje : personajes) 
				personaje.draw(batch);
			if(Gdx.input.isKeyPressed(Keys.LEFT)){
				  dibujar();
			}
		}
		if(serpienteDerecha){
			font.draw(batch, "Ahora prueba a colocarte a su derecha", 207, 638);
			font.draw(batch, "Pulsa espacio para el siguiente enemigo", 207, 588);
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
		      eleccion = 1;
		      break;
		  case 1:
			  font.draw(batch, "Medusi", 367, 638);
			  serpienteDerecha = false;
			  //xxx = true;
			  //eleccion = 2;
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
}
