//Bicho verde
package com.me.adventures.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Leeper extends PersonajeDelJuegoEnemigo {
	public static final int ABAJO = 0;
	public static final int IZQUIERDA = 1;
	public static final int DERECHA = 2;
	public static final int ARRIBA = 3;
	private int actual;
	
	//Atributos para pintar
	private TextureRegion [][] leeperMatrizFrames;
	//private Animation leeperAnimationAbajo, leeperAnimationIzquierda, leeperAnimationDerecha, leeperAnimationArriba;

	public Leeper(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel, int direccion) {
		super(adventures, posicion, manuel);
		this.ataqueActivado = true;
		this.direccion = direccion;
		actual = 0;
		Textura = new Texture("Enemigos/TablaBichoVerde.png");
		
		leeperMatrizFrames = new TextureRegion[4][4];
		leeperMatrizFrames[ABAJO][0] = new TextureRegion(Textura, 0, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ABAJO][1] = new TextureRegion(Textura, 58, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ABAJO][2] = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ABAJO][3] = new TextureRegion(Textura, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);

		leeperMatrizFrames[IZQUIERDA][0] = new TextureRegion(Textura, 116, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[IZQUIERDA][1] = new TextureRegion(Textura, 174, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[IZQUIERDA][2] = new TextureRegion(Textura, 116, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[IZQUIERDA][3] = new TextureRegion(Textura, 174, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);

		leeperMatrizFrames[DERECHA][0] = new TextureRegion(Textura, 232, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[DERECHA][1] = new TextureRegion(Textura, 290, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[DERECHA][2] = new TextureRegion(Textura, 232, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[DERECHA][3] = new TextureRegion(Textura, 290, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);

		leeperMatrizFrames[ARRIBA][0] = new TextureRegion(Textura, 348, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ARRIBA][1] = new TextureRegion(Textura, 406, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ARRIBA][2] = new TextureRegion(Textura, 348, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ARRIBA][3] = new TextureRegion(Textura, 406, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);

		//leeperAnimationAbajo = new Animation(0.05f, leeperMatrizFrames[ABAJO]);
		//leeperAnimationIzquierda = new Animation(0.05f, leeperMatrizFrames[IZQUIERDA]);
		//leeperAnimationDerecha= new Animation(0.05f, leeperMatrizFrames[DERECHA]);
		//leeperAnimationArriba = new Animation(0.05f, leeperMatrizFrames[ARRIBA]);
		
		frameActual = leeperMatrizFrames[direccion][actual];
	}
	
	public void activarAtaque() {
	}
	
	@Override
	public void update() {
		boolean colisionDerecha = colisiones.colisionDerechaObjeto(this) || colisiones.colisionDerechaEnemigo(this) || colisiones.colisionMovibleDerecha(this);
		boolean colisionIzquierda = colisiones.colisionIzquierdaObjeto(this) || colisiones.colisionIzquierdaEnemigo(this) || colisiones.colisionMovibleIzquierda(this);
		boolean colisionArriba = colisiones.colisionArribaObjeto(this) || colisiones.colisionArribaEnemigo(this) || colisiones.colisionMovibleArriba(this);
		boolean colisionAbajo = colisiones.colisionAbajoObjeto(this) || colisiones.colisionAbajoEnemigo(this) || colisiones.colisionMovibleAbajo(this);
		boolean colision = false;
		
		if(ataqueActivado == true){
			if(direccion == ARRIBA){
				if(!colisionArriba) {
					posicion.y = (float) (posicion.y + Constant.SPEED);
					stateTime = stateTime + Gdx.graphics.getDeltaTime();
					if(actual == 0)
						actual++;
					else
						actual = 0;
					frameActual = leeperMatrizFrames[direccion][actual];
				}
				else
					colision = true;
			}
			else if(direccion == IZQUIERDA){
				if(!colisionIzquierda) {
					posicion.x = (float) (posicion.x - Constant.SPEED);
					stateTime = stateTime + Gdx.graphics.getDeltaTime();
					if(actual == 0)
						actual++;
					else
						actual = 0;
					frameActual = leeperMatrizFrames[direccion][actual];
				}
				else
					colision = true;
			}
			else if(direccion == DERECHA){
				if(!colisionDerecha){
					posicion.x = (float) (posicion.x + Constant.SPEED);
					stateTime = stateTime + Gdx.graphics.getDeltaTime();
					if(actual == 0)
						actual++;
					else
						actual = 0;
					frameActual = leeperMatrizFrames[direccion][actual];
				}
				else
					colision = true;
			}
			else {
				if(!colisionAbajo) {
					posicion.y = (float) (posicion.y - Constant.SPEED);
					stateTime = stateTime + Gdx.graphics.getDeltaTime();
					if(actual == 0)
						actual++;
					else
						actual = 0;
					frameActual = leeperMatrizFrames[direccion][actual];
				}
				else
					colision = true;
			}
			if(colision == true){
				if(direccion == DERECHA){
					if(!colisionAbajo)
						direccion = ABAJO;
					else if(!colisionArriba)
						direccion = ARRIBA;
					else
						direccion = IZQUIERDA;
				}
				else if(direccion == IZQUIERDA){
					if(!colisionAbajo)
						direccion = ABAJO;
					else if(!colisionArriba)
						direccion = ARRIBA;
					else
						direccion = DERECHA;
				}
				else if(direccion == ARRIBA){
					if(!colisionDerecha)
						direccion = DERECHA;
					else if(!colisionIzquierda)
						direccion = IZQUIERDA;
					else
						direccion = ABAJO;
				}
				else {
					if(!colisionDerecha)
						direccion = DERECHA;
					else if(!colisionIzquierda)
						direccion = IZQUIERDA;
					else
						direccion = ARRIBA;
				}
			}
		}
		else { //leeper est� dormido
			
		}

		super.update();
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		super.draw(batch);
	}
	// Getters and Setters -----------------------------------------------------------------------
}
