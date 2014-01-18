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
	private boolean dormido;
	private int tiempoParaDormir;
	
	//Atributos para pintar
	private TextureRegion [][] leeperMatrizFrames;
	private Animation leeperAnimationAbajoDespierto, leeperAnimationArribaDespierto, leeperAnimationDerechaDespierto, leeperAnimationIzquierdaDespierto;
	private Animation leeperAnimationAbajoDormido, leeperAnimationArribaDormido, leeperAnimationDerechaDormido, leeperAnimationIzquierdaDormido;
	
	public Leeper(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel, int direccion) {
		super(adventures, posicion, manuel);
		dormido = false;
		ataqueActivado = true;
		this.direccion = direccion;
		
		Textura = adventures.getManager().get("Enemigos/TablaBichoVerde.png", Texture.class);
		
		leeperMatrizFrames = new TextureRegion[8][2];
		leeperMatrizFrames[ABAJO][0] = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ABAJO][1] = new TextureRegion(Textura, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ABAJO+4][0] = new TextureRegion(Textura, 0, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ABAJO+4][1] = new TextureRegion(Textura, 58, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);

		leeperMatrizFrames[IZQUIERDA][0] = new TextureRegion(Textura, 116, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[IZQUIERDA][1] = new TextureRegion(Textura, 174, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[IZQUIERDA+4][0] = new TextureRegion(Textura, 116, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[IZQUIERDA+4][1] = new TextureRegion(Textura, 174, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);

		leeperMatrizFrames[DERECHA][0] = new TextureRegion(Textura, 232, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[DERECHA][1] = new TextureRegion(Textura, 290, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[DERECHA+4][0] = new TextureRegion(Textura, 232, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[DERECHA+4][1] = new TextureRegion(Textura, 290, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);

		leeperMatrizFrames[ARRIBA][0] = new TextureRegion(Textura, 348, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ARRIBA][1] = new TextureRegion(Textura, 406, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ARRIBA+4][0] = new TextureRegion(Textura, 348, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		leeperMatrizFrames[ARRIBA+4][1] = new TextureRegion(Textura, 406, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);

		leeperAnimationAbajoDespierto = new Animation(0.05f, leeperMatrizFrames[ABAJO]);
		leeperAnimationArribaDespierto = new Animation(0.05f, leeperMatrizFrames[ARRIBA]);
		leeperAnimationIzquierdaDespierto = new Animation(0.05f, leeperMatrizFrames[IZQUIERDA]);
		leeperAnimationDerechaDespierto = new Animation(0.05f, leeperMatrizFrames[DERECHA]);
		leeperAnimationAbajoDormido = new Animation(0.05f, leeperMatrizFrames[ABAJO+4]);
		leeperAnimationArribaDormido = new Animation(0.05f, leeperMatrizFrames[ARRIBA+4]);
		leeperAnimationIzquierdaDormido = new Animation(0.05f, leeperMatrizFrames[IZQUIERDA+4]);
		leeperAnimationDerechaDormido = new Animation(0.05f, leeperMatrizFrames[DERECHA+4]);
		
		frameActual = leeperMatrizFrames[direccion][0];
	}
	
	public void activarAtaque() {
	}
	
	@Override
	public void update() {
		boolean colisionDerecha = colisiones.colisionDerechaObjeto(this) || colisiones.colisionDerechaEnemigo(this) || colisiones.colisionMovibleDerecha(this);
		boolean colisionIzquierda = colisiones.colisionIzquierdaObjeto(this) || colisiones.colisionIzquierdaEnemigo(this) || colisiones.colisionMovibleIzquierda(this);
		boolean colisionArriba = colisiones.colisionArribaObjeto(this) || colisiones.colisionArribaEnemigo(this) || colisiones.colisionMovibleArriba(this);
		boolean colisionAbajo = colisiones.colisionAbajoObjeto(this) || colisiones.colisionAbajoEnemigo(this) || colisiones.colisionMovibleAbajo(this);
		boolean colisionManuel = colisiones.colisionAbajoConManuel(this) || colisiones.colisionArribaConManuel(this) || colisiones.colisionDerechaConManuel(this) || colisiones.colisionIzquierdaConManuel(this);
		
		if(dormido == false && !colisionManuel){
			if(direccion == ARRIBA){
				if(!colisionArriba) {
					if(tiempoParaMovimiento == 0){
						posicion.y = (float) (posicion.y + Constant.SPEED);
						stateTime = stateTime + Gdx.graphics.getDeltaTime();
						frameActual = leeperAnimationArribaDespierto.getKeyFrame(stateTime, true);
						tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO_LEEPER;
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
						frameActual = leeperAnimationIzquierdaDespierto.getKeyFrame(stateTime, true);
						tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO_LEEPER;
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
						frameActual = leeperAnimationDerechaDespierto.getKeyFrame(stateTime, true);
						tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO_LEEPER;
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
						frameActual = leeperAnimationAbajoDespierto.getKeyFrame(stateTime, true);
						tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO_LEEPER;
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
		}
		else { //leeper esta dormido
			dormido = true;
			
			if(tiempoParaDormir == 0){
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
				if(direccion == ARRIBA)
					frameActual = leeperAnimationArribaDormido.getKeyFrame(stateTime, true);
				else if(direccion == ABAJO)
					frameActual = leeperAnimationAbajoDormido.getKeyFrame(stateTime, true);
				else if(direccion == IZQUIERDA)
					frameActual = leeperAnimationIzquierdaDormido.getKeyFrame(stateTime, true);
				else
					frameActual = leeperAnimationDerechaDormido.getKeyFrame(stateTime, true);
				tiempoParaDormir = Constant.TIEMPO_DORMIDO;
			}
			if(tiempoParaDormir > 0)
				tiempoParaDormir--;
		}
		
		if(tiempoParaMovimiento > 0)
			tiempoParaMovimiento--;
		super.update();
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		super.draw(batch);
	}
	
	// Getters and Setters -----------------------------------------------------------------------
}