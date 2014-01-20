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

public class NivelTest extends Nivel {
	private BitmapFont font;
	private int eleccion, disparos;
	private boolean primerMovimientoDerecha, primerMovimientoIzquierda, primerMovimientoArriba, primerMovimientoAbajo, colisionRoca,
	corazonPrimero, disparar, cofreAbierto, terminar;

	public NivelTest(AdventuresOfManuel adventures, Vector2 posicionManuel) {
		super(adventures, posicionManuel);
		font = new BitmapFont(Gdx.files.internal("arial.fnt"), Gdx.files.internal("arial.png"), false);
		primerMovimientoDerecha = true;
		terminar = cofreAbierto = disparar = corazonPrimero = primerMovimientoIzquierda = primerMovimientoArriba = primerMovimientoAbajo = colisionRoca = false;
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
		salida = new Salida(adventures, new Vector2(483,696), 0, 0); // El 0 es Puerta
		objetos.add(new Pared(adventures, new Vector2(599, 696), 290, 58));
		objetos.add(new Pared(adventures, new Vector2(831, 0), 58, 754));
		objetos.add(new Roca(adventures, new Vector2(657, 522)));
		corazones.add(new Corazon(adventures, new Vector2(773,406), 2)); //otorga 2 proyectiles
		cofre = new Cofre(adventures, new Vector2(425,116), 2);
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes = new ArrayList<PersonajeDelJuegoEnemigo>();
		
		//personajes.add(new Serpiente(new Vector2(541,348), manuel));
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

		movimientos();
		
		rocaColision();
		
		corazon();
		
		disparar();
		
		gema();
		
		terminar();
		manuel.draw(batch);

		batch.end();
	}

	private void terminar() {
		if(terminar){
			for(ObjetoDelJuego objeto : objetos) 
				objeto.draw(batch);
			salida.draw(batch);
			cofre.draw(batch);
			if(manuel.getPosicion().x == salida.getPosicion().x + 58 && manuel.getPosicion().y == salida.getPosicion().y - 29){
				terminar = false;
				adventures.pruebaSuperada();
			}
		}
		
	}

	private void gema() {
		if(cofreAbierto){
			for(ObjetoDelJuego objeto : objetos) 
				objeto.draw(batch);
			font.draw(batch, "Coge la gema", 367, 638);
			salida.draw(batch);
			cofre.draw(batch);
			if(cofre.getBordes().overlaps(manuel.getBordes())){
				cofre.cogerGema();
				salida.abrirSalida();
				dibujar();
			}
		}
		
	}

	private void disparar() {
		if(disparar){
			for(ObjetoDelJuego objeto : objetos) 
				objeto.draw(batch);
			salida.draw(batch);
			cofre.draw(batch);
			font.draw(batch, "Corazon cogido! Dispara proyectiles", 367, 638);
			if(disparos != 0){
				if(Gdx.input.isKeyPressed(Keys.SPACE)){
					disparos--;
				}
			}
			else{
				dibujar();
			}
			
		}
		
	}

	private void corazon() {
		if(corazonPrimero){
			for(ObjetoDelJuego objeto : objetos) 
				objeto.draw(batch);
			salida.draw(batch);
			cofre.draw(batch);
			font.draw(batch, "Colisionaste! Ahora coge el corazon", 367, 638);
			for(Corazon corazon : corazones)
				corazon.draw(batch);
			if(colisiones.colisionCorazon(manuel)){
				dibujar();
			}
			
		}
	}

	private void rocaColision() {
		if(colisionRoca){
			font.draw(batch, "Muevete y atraviesa la roca", 367, 638);
			for(ObjetoDelJuego objeto : objetos) 
				objeto.draw(batch);
			if(colisiones.colisionDerechaObjeto(manuel) || colisiones.colisionIzquierdaObjeto(manuel) || colisiones.colisionArribaObjeto(manuel) || colisiones.colisionAbajoObjeto(manuel)){
				eleccion = 3;
				dibujar();
			}
		}
	}

	private void movimientos() {
		if(primerMovimientoDerecha){
			font.draw(batch, "Muevete a la derecha", 367, 638);
			if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			  dibujar();
			}
		}
		
		if(primerMovimientoIzquierda){
			font.draw(batch, "Muevete a la izquierda", 367, 638);
			if(Gdx.input.isKeyPressed(Keys.LEFT)){
			  dibujar();
			}
		}
		
		if(primerMovimientoArriba){
			font.draw(batch, "Muevete arriba", 367, 638);
			if(Gdx.input.isKeyPressed(Keys.UP)){
			  dibujar();
			}
		}
		
		if(primerMovimientoAbajo){
			font.draw(batch, "Muevete abajo", 367, 638);
			if(Gdx.input.isKeyPressed(Keys.DOWN)){
			  dibujar();
			  primerMovimientoAbajo = false;
			  colisionRoca = true;
			}
		}
	}
	
	private void dibujar(){
		switch(eleccion){
		  case 0: 
			  font.draw(batch, "Muevete a la izquierda", 367, 638);
		      primerMovimientoDerecha = false;
		      primerMovimientoIzquierda = true;
		      eleccion = 1;
		      break;
		  case 1:
			  font.draw(batch, "Muevete arriba", 367, 638);
			  primerMovimientoIzquierda = false;
			  primerMovimientoArriba = true;
			  eleccion = 2;
			  break;
		  case 2:
			  font.draw(batch, "Muevete abajo", 367, 638);
			  primerMovimientoArriba = false;
			  primerMovimientoAbajo = true;
			  break;
		  case 3:
			  font.draw(batch, "Colisionaste! Ahora coge el corazon", 367, 638);
			  colisionRoca = false;
			  corazonPrimero = true;
			  for(Corazon corazon : corazones)
					corazon.draw(batch);

              colisiones = new Colision(adventures, manuel, personajes, objetos, personajesMovibles, corazones, cofre, salida, objetosEnemigos);
			  eleccion = 4;
			  break;
		  case 4:
			  font.draw(batch, "Corazon cogido! Dispara proyectiles", 367, 638);
			  corazonPrimero = false;
			  cofre.abrirCofre();
			  disparar = true;
			  eleccion = 5;
			  disparos = 2;
			  break;
		  case 5:
			  disparar = false;
			  cofreAbierto = true;
			  font.draw(batch, "Coge la gema.", 367, 638);
			  eleccion = 6;
			  break;
		  case 6:
			  cofreAbierto = false;
			  terminar = true;
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
