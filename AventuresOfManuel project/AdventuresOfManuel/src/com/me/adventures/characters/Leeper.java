//Bicho verde
package com.me.adventures.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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
	private boolean dormido;
	private int tiempoParaMovimiento;
	
	//Atributos para pintar
	private TextureRegion [][] leeperMatrizFrames;

	public Leeper(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel, int direccion) {
		super(adventures, posicion, manuel);
		dormido = false;
		ataqueActivado = true;
		tiempoParaMovimiento = 0;
		this.direccion = direccion;
		actual = 0;
		
		Textura = adventures.getManager().get("Enemigos/TablaBichoVerde.png", Texture.class);
		
		leeperMatrizFrames = new TextureRegion[4][4];
		leeperMatrizFrames[ABAJO][0] = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ABAJO][1] = new TextureRegion(Textura, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ABAJO][2] = new TextureRegion(Textura, 0, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ABAJO][3] = new TextureRegion(Textura, 58, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);

		leeperMatrizFrames[IZQUIERDA][0] = new TextureRegion(Textura, 116, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[IZQUIERDA][1] = new TextureRegion(Textura, 174, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[IZQUIERDA][2] = new TextureRegion(Textura, 116, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[IZQUIERDA][3] = new TextureRegion(Textura, 174, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);

		leeperMatrizFrames[DERECHA][0] = new TextureRegion(Textura, 232, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[DERECHA][1] = new TextureRegion(Textura, 290, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[DERECHA][2] = new TextureRegion(Textura, 232, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[DERECHA][3] = new TextureRegion(Textura, 290, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);

		leeperMatrizFrames[ARRIBA][0] = new TextureRegion(Textura, 348, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ARRIBA][1] = new TextureRegion(Textura, 406, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ARRIBA][2] = new TextureRegion(Textura, 348, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ARRIBA][3] = new TextureRegion(Textura, 406, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		
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
		boolean colisionManuel = colisiones.colisionConManuel(this);
		
		if(dormido == false && !colisionManuel){
			if(direccion == ARRIBA){
				if(!colisionArriba) {
					if(tiempoParaMovimiento == 0){
						posicion.y = (float) (posicion.y + Constant.SPEED);
						stateTime = stateTime + Gdx.graphics.getDeltaTime();
						if(actual == 0)
							actual = 1;
						else
							actual = 0;
						frameActual = leeperMatrizFrames[direccion][actual];
						tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO;
					}
				}
				else{
					if(!colisionDerecha)
						direccion = DERECHA;
					else if(!colisionIzquierda)
						direccion = IZQUIERDA;
					else
						direccion = ABAJO;
				}
			}
			else if(direccion == IZQUIERDA){
				if(!colisionIzquierda){
					if(tiempoParaMovimiento == 0){
						posicion.x = (float) (posicion.x - Constant.SPEED);
						stateTime = stateTime + Gdx.graphics.getDeltaTime();
						if(actual == 0)
							actual = 1;
						else
							actual = 0;
						frameActual = leeperMatrizFrames[direccion][actual];
						tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO;
					}
				}
				else{
					if(!colisionAbajo)
						direccion = ABAJO;
					else if(!colisionArriba)
						direccion = ARRIBA;
					else
						direccion = DERECHA;
				}
			}
			else if(direccion == DERECHA){
				if(!colisionDerecha) {
					if(tiempoParaMovimiento == 0){
						posicion.x = (float) (posicion.x + Constant.SPEED);
						stateTime = stateTime + Gdx.graphics.getDeltaTime();
						if(actual == 0)
							actual = 1;
						else
							actual = 0;
						frameActual = leeperMatrizFrames[direccion][actual];
						tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO;
					}
				}
				else{
					if(!colisionAbajo)
						direccion = ABAJO;
					else if(!colisionArriba)
						direccion = ARRIBA;
					else
						direccion = IZQUIERDA;
				}
			}
			else {
				if(!colisionAbajo) {
					if(tiempoParaMovimiento == 0){
						posicion.y = (float) (posicion.y - Constant.SPEED);
						stateTime = stateTime + Gdx.graphics.getDeltaTime();
						if(actual == 0)
							actual = 1;
						else
							actual = 0;
						frameActual = leeperMatrizFrames[direccion][actual];
						tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO;
					}
				}
				else{
					if(!colisionDerecha)
						direccion = DERECHA;
					else if(!colisionIzquierda)
						direccion = IZQUIERDA;
					else
						direccion = ARRIBA;
				}
			}
			ajustarLeeper(colisionDerecha, colisionIzquierda, colisionArriba, colisionAbajo);
		}
		else { //leeper esta dormido
			dormido = true;
			if(actual == 0 || actual == 1)
				tiempoParaMovimiento = 0;
			if(tiempoParaMovimiento == 0){
				if(actual != 2)
					actual = 2;
				else
					actual = 3;
				tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO;
			}
			frameActual = leeperMatrizFrames[direccion][actual];			
		}

		if(tiempoParaMovimiento > 0)
			tiempoParaMovimiento--;
		super.update();
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		super.draw(batch);
	}

	public void ajustarLeeper(boolean colisionDerecha, boolean colisionIzquierda, boolean colisionArriba, boolean colisionAbajo) {
		if(direccion == ABAJO) {
			int nuevaPosicion = (int) posicion.y;
			while(nuevaPosicion % 29 != 0) // Ajusta la posición
				nuevaPosicion--;
				posicion.y = nuevaPosicion;
				frameActual = leeperMatrizFrames[direccion][actual];
			}
		else if(direccion == IZQUIERDA) {
			int nuevaPosicion = (int) posicion.x;
			while(nuevaPosicion % 29 != 19) // Ajusta la posición
				nuevaPosicion--;
			posicion.x = nuevaPosicion;
			frameActual = leeperMatrizFrames[direccion][actual];
		}
		else if(direccion == DERECHA) {
			int nuevaPosicion = (int) posicion.x;
			while(nuevaPosicion % 29 != 19) // Ajusta la posición
			nuevaPosicion++;
			posicion.x = nuevaPosicion;
			frameActual = leeperMatrizFrames[direccion][actual];
		}
 		else if(direccion == ARRIBA) {
			int nuevaPosicion = (int) posicion.y;
			while(nuevaPosicion % 29 != 0) // Ajusta la posición
				nuevaPosicion++;
			posicion.y = nuevaPosicion;
			frameActual = leeperMatrizFrames[direccion][actual];
		}
				
		if(colisionDerecha || colisionIzquierda || colisionArriba || colisionAbajo) {
			detectaColisionInminente();
		}
	}
	
	private void detectaColisionInminente() {
		if(colisiones.colisionObjetoEnemigoMovible(this)) {
			if(direccion == DERECHA)
				posicion.x -= 29;
			if(direccion == IZQUIERDA)
				posicion.x += 29;
			if(direccion == ARRIBA)
				posicion.y -= 29;
			if(direccion == ABAJO)
				posicion.y += 29;
		}
	}
	// Getters and Setters -----------------------------------------------------------------------
}