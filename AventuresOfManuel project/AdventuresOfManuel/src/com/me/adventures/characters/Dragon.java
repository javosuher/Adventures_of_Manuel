package com.me.adventures.characters;

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
	
	//Atributos para pintar
	private TextureRegion [][] dragonMatrizFrames;
	
	public Dragon(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel, int direccion) {
		super(adventures, posicion, manuel);
		this.disparando = false;
		this.ataqueActivado = false;
		this.direccion = direccion;
		
		Textura = new Texture("Enemigos/TablaDragon.png");
		
		dragonMatrizFrames = new TextureRegion[4][4];
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
			tiempoParaSiguienteProyectil = Constant.TIEMPO_PROYECTIL;
			disparo = new ProyectilEnemigo(adventures, new Vector2(), direccion);
			disparo.inicializaPosicion(posicion, direccion);
			if(direccion == IZQUIERDA){
				if(manuel.getPosicion().x < posicion.x && (manuel.getPosicion().y == posicion.y || posicion.y == manuel.getPosicion().y+29 || posicion.y == manuel.getPosicion().y-29 )){
					disparando = true;
					disparar();
				}
			}
			else if(direccion == DERECHA){
				if(manuel.getPosicion().x > posicion.x && (manuel.getPosicion().y == posicion.y || posicion.y == manuel.getPosicion().y+29 || posicion.y == manuel.getPosicion().y-29 )){
					disparando = true;
					disparar();
				}
			}
			else if(direccion == ARRIBA){
				if((manuel.getPosicion().x == posicion.x || posicion.x == manuel.getPosicion().x+29 || posicion.x == manuel.getPosicion().x-29) && manuel.getPosicion().y > posicion.y){
					disparando = true;
					disparar();
				}
			}
			else{
				if((manuel.getPosicion().x == posicion.x || posicion.x == manuel.getPosicion().x+29 || posicion.x == manuel.getPosicion().x-29)  && manuel.getPosicion().y < posicion.y){
					disparando = true;
					disparar();
				}
			}
		}
		else
			disparar();
	}
	
	public void disparar(){
		if(colisiones.colisionDisparoAManuel(disparo) || colisiones.colisionDisparoEnemigoObjeto(disparo))
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
