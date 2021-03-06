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
	private boolean serpienteDerecha, serpienteIzquierda, finSerpiente, dragon, matarDragon, 
					leeper, leeperDormido, fantasma, fantasmaQuieto, calavera, calaveraAtaca,
					finPruebas;
	
	Dragon dr = new Dragon(adventures, new Vector2(541, 522), manuel, Dragon.ABAJO);
	Leeper le = new Leeper(adventures, new Vector2(541, 522), manuel, Leeper.ARRIBA);
	Fantasma fa = new Fantasma(adventures, new Vector2(541, 522), manuel, 0);
	Calavera ca = new Calavera(adventures, new Vector2(541, 522), manuel);
	Corazon corazon2 = new Corazon(adventures, new Vector2(773,406), 2);

	public EnemyTest(AdventuresOfManuel adventures, Vector2 posicionManuel) {
		super(adventures, posicionManuel);
		font = new BitmapFont(Gdx.files.internal("arial.fnt"), Gdx.files.internal("arial.png"), false);
		serpienteIzquierda = true;
		serpienteDerecha = false;
		finPruebas = false;
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
		salida = new Salida(adventures, new Vector2(483,696), 0, 0);
		objetos.add(new Pared(adventures, new Vector2(599, 696), 290, 58));
		objetos.add(new Pared(adventures, new Vector2(831, 0), 58, 754));
		corazones.add(new Corazon(adventures, new Vector2(773,406), 0));
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
		
		// Pruebas de enemigos
		serpiente();
		dragon();		
		leeper();
		fantasma();	
		calavera();
		
		if(finPruebas) adventures.pruebasFinalizadas();
		
		manuel.draw(batch);

		batch.end();
	}
	
	private void calavera(){
		if(calavera){
			font.draw(batch, "La calavera no atacara hasta que", 207, 638);
			font.draw(batch, "hayas recogido el corazon.", 207, 588);
			
			// Resetear personajes, corazones, cofre y salida
			personajes.clear();
			corazones.clear();
			salida = new Salida(adventures, new Vector2(483,696), 0, 0);
			corazones.add(new Corazon(adventures, new Vector2(773,406), 2));
			cofre = new Cofre(adventures, new Vector2(425,116), 2);
			
			personajes.add(ca);
			iniciarColisiones();
			for(PersonajeDelJuego personaje : personajes) 
				personaje.draw(batch);
			for(Corazon corazon : corazones)
				corazon.draw(batch);
			salida.draw(batch);
			cofre.draw(batch);
			if(colisiones.colisionCorazon(manuel))
				manuel.obtenerCorazon(); 
			if(manuel.getCorazonesObtenidos() > 2){
				cofre.abrirCofre();
				ca.activarAtaque();
				dibujar();
			}
		}
		if(calaveraAtaca){
			cofre.draw(batch);
			salida.draw(batch);
			iniciarColisiones();
			font.draw(batch, "Coge la gema o dispara para finalizar", 207, 588);
		    font.draw(batch, "Ahora la calavera ataca", 207, 638);
			for(PersonajeDelJuego personaje : personajes) 
				personaje.draw(batch);
			if(cofre.getBordes().overlaps(manuel.getBordes()) || ca.estaEnBola()){
				dibujar();
			}
		}
	}
	
	private void fantasma(){
		if(fantasma){
			font.draw(batch, "Ahora el enemigo es un fantasma", 207, 638);
			font.draw(batch, "Colsiona con el", 207, 588);
			// Resetear personajes
			personajes.clear();
			personajes.add(fa);
			iniciarColisiones();
			for(PersonajeDelJuego personaje : personajes) 
				personaje.draw(batch);
			if(colisiones.colisionAbajoEnemigo(manuel) || colisiones.colisionIzquierdaEnemigo(manuel) || colisiones.colisionArribaEnemigo(manuel) || colisiones.colisionDerechaEnemigo(manuel))
				dibujar();
		}
		if(fantasmaQuieto){
			font.draw(batch, "El fantasma se ha quedado quieto", 207, 638);
			font.draw(batch, "Pulsa espacio para el siguiente.", 207, 588);
			for(PersonajeDelJuego personaje : personajes) 
				personaje.draw(batch);
			if(Gdx.input.isKeyPressed(Keys.SPACE)){
				  dibujar();
			}
		}
	}
	private void dragon(){
		if(dragon){
			font.draw(batch, "El dragon no atacara hasta que", 207, 638);
			font.draw(batch, "hayas recogido el corazon.", 207, 588);
			personajes.clear();
			personajes.add(dr);
			iniciarColisiones();
			for(PersonajeDelJuego personaje : personajes) 
				personaje.draw(batch);
			for(Corazon corazon : corazones)
				corazon.draw(batch);
			salida.draw(batch);
			cofre.draw(batch);
			if(colisiones.colisionCorazon(manuel))
				manuel.obtenerCorazon(); 
			if(manuel.getCorazonesObtenidos() > 0){
				cofre.abrirCofre();
				dr.activarAtaque();
				dibujar();
			}
		}
		if(matarDragon){
			cofre.draw(batch);
			salida.draw(batch);
			font.draw(batch, "Ahora el dragon ataca", 207, 588);
		    font.draw(batch, "Coge la gema para pasar al siguiente", 207, 638);
			for(PersonajeDelJuego personaje : personajes) 
				personaje.draw(batch);
			if(cofre.getBordes().overlaps(manuel.getBordes())){
				cofre.cogerGema();
				salida.abrirSalida();
				dibujar();
			}
		}
	}
	
	private void leeper(){
		if(leeper){
			font.draw(batch, "Colisiona con el leeper para que se duerma", 207, 638);
			personajes.clear();
			personajes.add(le);
			iniciarColisiones();
			for(PersonajeDelJuego personaje : personajes)
				personaje.draw(batch);
			if(colisiones.colisionAbajoEnemigo(manuel) || colisiones.colisionIzquierdaEnemigo(manuel) || colisiones.colisionArribaEnemigo(manuel) || colisiones.colisionDerechaEnemigo(manuel)){
				font.draw(batch, "Bien, pulsa espacio para el siguiente", 207, 638);
				le.draw(batch);
				dibujar();
			}
		}
		if(leeperDormido){
			font.draw(batch, "Pulsa espacio para el siguiente enemigo", 207, 638);
			for(PersonajeDelJuego personaje : personajes) 
				personaje.draw(batch);
			if(Gdx.input.isKeyPressed(Keys.SPACE)){
				  dibujar();
			}
		}
	}

	private void serpiente() {        
		if(serpienteIzquierda){
			font.draw(batch, "Colocate a la izquierda de la serpiente", 207, 638);
			font.draw(batch, "Ella te seguira con la mirada", 207, 588);
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
		      serpienteIzquierda = false;
		      serpienteDerecha = true;
		      eleccion++;
		      break;
		  case 1:
			  serpienteDerecha = false;
			  finSerpiente = true;
			  eleccion++;
			  break;
		  case 2:
			  finSerpiente = false;
			  dragon = true;
			  eleccion++;
			  break;
		  case 3: 
		      dragon = false;
		      matarDragon = true;
		      eleccion++;
		      break;
		  case 4:
			  matarDragon = false;
		      leeper = true;
		      eleccion++;
		      break;
		  case 5:
			  leeper = false;
			  eleccion++;
			  leeperDormido = true;
			  break;
		  case 6:
			  leeperDormido = false;
			  fantasma = true;
			  eleccion++;
			  break;
		  case 7:
			  fantasma = false;
			  fantasmaQuieto = true;
			  eleccion++;
			  break;
		  case 8:
			  fantasmaQuieto = false;
			  calavera = true;
			  eleccion++;
			  break;
		  case 9:
			  calavera = false;
			  calaveraAtaca = true;
			  eleccion++;
			  break;
		  case 10:
			  calaveraAtaca = false;
			  finPruebas = true;
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
