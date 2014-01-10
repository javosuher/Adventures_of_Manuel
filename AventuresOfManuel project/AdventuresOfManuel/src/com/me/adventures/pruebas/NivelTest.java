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
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.screens.Nivel;

public class NivelTest extends Nivel {
	private MainTest adventurasDeManuel;
	private Texture TexturaFondo;
	private SpriteBatch batch;
	private Manuel manuel;
	private Cofre cofre;
	private List<Corazon> corazones;
	private List<ObjetoDelJuego> objetos;
	private List<PersonajeDelJuego> personajes;
	private List<PersonajeDelJuego> personajesMovibles;
	private Colision colisiones;
	private Salida salida;
	private BitmapFont font;
	private int eleccion;
	private Roca roca;
	private boolean primerMovimientoDerecha, primerMovimientoIzquierda, primerMovimientoArriba, primerMovimientoAbajo, colisionRoca,
	corazonPrimero;

	public NivelTest(MainTest adventuras_del_manuel) {
		font = new BitmapFont(Gdx.files.internal("arial.fnt"), Gdx.files.internal("arial.png"), false);
		primerMovimientoDerecha = true;
		corazonPrimero = primerMovimientoIzquierda = primerMovimientoArriba = primerMovimientoAbajo = colisionRoca = false;
		this.adventurasDeManuel = adventuras_del_manuel;
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
		
		roca = new Roca(new Vector2(483, 58));
		
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
		
		//Se introducen los demas objetos por fila
		/*objetos.add(new Roca(new Vector2(193, 638)));
		objetos.add(new Roca(new Vector2(251, 638)));
		objetos.add(new Roca(new Vector2(309, 638)));
		objetos.add(new Roca(new Vector2(367, 638)));*/
		/*objetos.add(new Roca(new Vector2(425, 638)));
		objetos.add(new Roca(new Vector2(483, 638)));
		objetos.add(new Roca(new Vector2(599, 638)));
		objetos.add(new Roca(new Vector2(657, 638)));
		objetos.add(new Arbol(new Vector2(715, 638)));
		objetos.add(new Arbol(new Vector2(773, 638)));
		
		objetos.add(new Roca(new Vector2(193, 580)));
		objetos.add(new Arbol(new Vector2(251, 580)));
		objetos.add(new Arbol(new Vector2(309, 580)));
		objetos.add(new Roca(new Vector2(367, 580)));
		*/corazones.add(new Corazon(new Vector2(425,580), 0)); //no da proyectiles
		/*objetos.add(new Roca(new Vector2(599, 580)));
		objetos.add(new Roca(new Vector2(657, 580)));
		objetos.add(new Arbol(new Vector2(715, 580)));
		objetos.add(new Arbol(new Vector2(773, 580)));
		
		objetos.add(new Arbol(new Vector2(251, 522)));
		objetos.add(new Arbol(new Vector2(309, 522)));
		objetos.add(new Roca(new Vector2(367, 522)));
		objetos.add(new Roca(new Vector2(425, 522)));
		objetos.add(new Roca(new Vector2(483, 522)));
		objetos.add(new Roca(new Vector2(599, 522)));*/
		objetos.add(new Roca(new Vector2(657, 522)));
		/*objetos.add(new Roca(new Vector2(715, 522)));
		objetos.add(new Arbol(new Vector2(773, 522)));
		
		objetos.add(new Arbol(new Vector2(309, 464)));
		objetos.add(new Arbol(new Vector2(367, 464)));
		objetos.add(new Roca(new Vector2(425, 464)));
		objetos.add(new Roca(new Vector2(483, 464)));
		objetos.add(new Roca(new Vector2(599, 464)));
		objetos.add(new Roca(new Vector2(657, 464)));
		objetos.add(new Roca(new Vector2(715, 464)));
		objetos.add(new Arbol(new Vector2(773, 464)));
		
		objetos.add(new Roca(new Vector2(425, 406)));
		objetos.add(new Roca(new Vector2(483, 406)));
		objetos.add(new Roca(new Vector2(599, 406)));
		objetos.add(new Roca(new Vector2(657, 406)));
		objetos.add(new Arbol(new Vector2(715, 406)));
		corazones.add(new Corazon(new Vector2(773,406), 2)); //otorga 2 proyectiles
		
		objetos.add(new Roca(new Vector2(657, 348)));
		
		objetos.add(new Arbol(new Vector2(251, 290)));
		objetos.add(new Arbol(new Vector2(309, 290)));
		
		objetos.add(new Arbol(new Vector2(193, 232)));
		objetos.add(new Arbol(new Vector2(251, 232)));
		objetos.add(new Arbol(new Vector2(309, 232)));
		objetos.add(new Arbol(new Vector2(367, 232)));
		objetos.add(new Arbol(new Vector2(599, 232)));
		objetos.add(new Arbol(new Vector2(657, 232)));
		
		objetos.add(new Arbol(new Vector2(193, 174)));
		objetos.add(new Arbol(new Vector2(251, 174)));
		objetos.add(new Arbol(new Vector2(309, 174)));
		objetos.add(new Arbol(new Vector2(367, 174)));
		objetos.add(new Arbol(new Vector2(599, 174)));
		objetos.add(new Arbol(new Vector2(657, 174)));
		objetos.add(new Arbol(new Vector2(715, 174)));
		
		objetos.add(new Roca(new Vector2(193, 116)));
		objetos.add(new Arbol(new Vector2(251, 116)));
		objetos.add(new Arbol(new Vector2(309, 116)));
		objetos.add(new Roca(new Vector2(367, 116)));*/
		cofre = new Cofre(new Vector2(425,116), 2);
		/*objetos.add(new Arbol(new Vector2(657, 116)));
		objetos.add(new Arbol(new Vector2(715, 116)));
		
		objetos.add(new Roca(new Vector2(193, 58)));
		objetos.add(new Roca(new Vector2(251, 58)));
		objetos.add(new Roca(new Vector2(309, 58)));
		objetos.add(new Roca(new Vector2(367, 58)));
		objetos.add(new Roca(new Vector2(425, 58)));
		objetos.add(new Roca(new Vector2(483, 58)));*/
		
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes = new ArrayList<PersonajeDelJuego>();
		
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
		//salida.draw(batch);

		/*for(Corazon corazon : corazones){
			corazon.draw(batch);
		}*/
		//cofre.draw(batch);
		manuel.draw(batch);
		
		
		movimientos();
		
		rocaColision();
		
		corazon();
		
		if(eleccion == 4){
			font.draw(batch, "Colision!", 367, 638);
			for(ObjetoDelJuego objeto : objetos) 
				objeto.draw(batch);
		}
		
		/*if(salida.salidaAbierta() == false){
			for(PersonajeDelJuego personaje : personajes){
				personaje.draw(batch);
			}
		}
		if(salida.salidaAbierta() == false){
			for(PersonajeDelJuego personaje : personajesMovibles){
				personaje.draw(batch);
			}
		}*/
		
		/*for(ObjetoDelJuego objeto : objetos) {
			objeto.draw(batch);
		}*/
		batch.end();
	}

	private void corazon() {
		if(corazonPrimero){
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
			  eleccion = 4;
			  break;
		  case 4:
			  font.draw(batch, "Corazon cogido!", 367, 638);
			  corazonPrimero = false;
			  eleccion = 5;
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
