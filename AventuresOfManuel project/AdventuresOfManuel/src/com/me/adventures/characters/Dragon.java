package com.me.adventures.characters;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Dragon extends PersonajeDelJuegoEnemigo {
	public static final int ABAJO = 0;
	public static final int IZQUIERDA = 1;
	public static final int DERECHA = 2;
	public static final int ARRIBA = 3;
	private static final int DORMIDO = 0;
	private static final int DESPIERTO = 1;
	
	private boolean disparando;
	private Proyectil disparo;
	private Sound sonidoDisparo;
	
	//Atributos para pintar
	private TextureRegion [][] dragonMatrizFrames;
	
	public Dragon(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel, int direccion) {
		super(adventures, posicion, manuel);
		this.disparando = false;
		this.ataqueActivado = false;
		this.direccion = direccion;
		sonidoDisparo = adventures.getManager().get("Musica/DisparoDragon.mp3", Sound.class);
		
		Textura = adventures.getManager().get("Enemigos/TablaDragon.png", Texture.class);

		dragonMatrizFrames = new TextureRegion[4][2];
		dragonMatrizFrames[ABAJO][DORMIDO] = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		dragonMatrizFrames[IZQUIERDA][DORMIDO] = new TextureRegion(Textura, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		dragonMatrizFrames[DERECHA][DORMIDO] = new TextureRegion(Textura, 116, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		dragonMatrizFrames[ARRIBA][DORMIDO] = new TextureRegion(Textura, 174, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		dragonMatrizFrames[ARRIBA][DESPIERTO] = new TextureRegion(Textura, 174, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		dragonMatrizFrames[ABAJO][DESPIERTO] = new TextureRegion(Textura, 232, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		dragonMatrizFrames[IZQUIERDA][DESPIERTO] = new TextureRegion(Textura, 290, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		dragonMatrizFrames[DERECHA][DESPIERTO] = new TextureRegion(Textura, 348, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		frameActual = dragonMatrizFrames[direccion][DORMIDO];
	}
	
	public void activarAtaque() {
		ataqueActivado = true;
		frameActual = dragonMatrizFrames[direccion][DESPIERTO];
		if(!disparando && tiempoParaSiguienteProyectil == 0){
			disparo = new ProyectilEnemigo(adventures, new Vector2(), direccion);
			disparo.inicializaPosicion(posicion, direccion);
			if(direccion == IZQUIERDA){
				if(manuel.getPosicion().x < posicion.x && (manuel.getPosicion().y <= posicion.y+29 && manuel.getPosicion().y >= posicion.y - 29)){
					disparando = true;
					if(adventures.isSonidoActivado())
						sonidoDisparo.play();
					disparar();
					tiempoParaSiguienteProyectil = Constant.TIEMPO_PROYECTIL;
				}
			}
			else if(direccion == DERECHA){
				if(manuel.getPosicion().x > posicion.x && (manuel.getPosicion().y <= posicion.y+29 && manuel.getPosicion().y >= posicion.y - 29)){
					disparando = true;
					if(adventures.isSonidoActivado())
						sonidoDisparo.play();
					disparar();
					tiempoParaSiguienteProyectil = Constant.TIEMPO_PROYECTIL;
				}
			}
			else if(direccion == ARRIBA){
				if(manuel.getPosicion().y > posicion.y && (manuel.getPosicion().x <= posicion.x+29 && manuel.getPosicion().x >= posicion.x - 29)){
					disparando = true;
					if(adventures.isSonidoActivado())
						sonidoDisparo.play();
					disparar();
					tiempoParaSiguienteProyectil = Constant.TIEMPO_PROYECTIL;
				}
			}
			else if(direccion == ABAJO){
				if(manuel.getPosicion().y < posicion.y && (manuel.getPosicion().x <= posicion.x+29 && manuel.getPosicion().x >= posicion.x - 29)){
					disparando = true;
					if(adventures.isSonidoActivado())
						sonidoDisparo.play();
					disparar();
					tiempoParaSiguienteProyectil = Constant.TIEMPO_PROYECTIL;
				}
			}
		}
		else{
			disparar();
		}
	}
	
	public void disparar(){
		if(colisiones.colisionDisparoAManuel(disparo) || colisiones.colisionDisparoEnemigoObjeto(disparo) || colisiones.colisionDisparoEnemigoEnemigoMovible(disparo))
			disparando = false;
		else
			disparo.update();
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		super.draw(batch);
		if(disparando)
			disparo.draw(batch);
	}
	// Getters and Setters -----------------------------------------------------------------------
}
