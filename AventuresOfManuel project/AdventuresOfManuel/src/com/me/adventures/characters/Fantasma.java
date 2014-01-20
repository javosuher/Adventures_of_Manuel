package com.me.adventures.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Fantasma extends PersonajeDelJuegoEnemigo {
	public static final int ABAJO = 0;
	public static final int IZQUIERDA = 1;
	public static final int DERECHA = 2;
	public static final int ARRIBA = 3;
	public static final int SPRITE_QUIETO = 0;
	private boolean fantasmaSeQuedaQuieto;
	private boolean correr;
	private int tiempoMovimientoCorrer;
	
	//Atributos para pintar
	private TextureRegion [][] fantasmaMatrizFrames;
	private Animation fantasmaAnimationAbajo, fantasmaAnimationIzquierda, fantasmaAnimationDerecha, fantasmaAnimationArriba;
	
	public Fantasma(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel, int direccion) {
		super(adventures, posicion, manuel);
		this.ataqueActivado = false;
		this.direccion = direccion;
		this.fantasmaSeQuedaQuieto = false;
		this.correr = false;
		this.tiempoMovimientoCorrer = 0;
		this.tiempoParaMovimiento = 0;
		
		Textura = adventures.getManager().get("Enemigos/TablaFantasma.png", Texture.class);
		
		fantasmaMatrizFrames = TextureRegion.split(Textura, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		// Asignamos las animaciones de las direcciones del Fantasma
		fantasmaAnimationAbajo = new Animation(0.05f, fantasmaMatrizFrames[ABAJO]);
		fantasmaAnimationIzquierda = new Animation(0.05f, fantasmaMatrizFrames[IZQUIERDA]);
		fantasmaAnimationDerecha= new Animation(0.05f, fantasmaMatrizFrames[DERECHA]);
		fantasmaAnimationArriba = new Animation(0.05f, fantasmaMatrizFrames[ARRIBA]);
		
		frameActual = fantasmaMatrizFrames[direccion][SPRITE_QUIETO];
	}
	
	public void activarAtaque() {
	}
	
	public void update() {
		boolean colisionDerecha = colisiones.colisionDerechaObjeto(this) || colisiones.colisionDerechaEnemigo(this) || colisiones.colisionMovibleDerecha(this);
		boolean colisionIzquierda = colisiones.colisionIzquierdaObjeto(this) || colisiones.colisionIzquierdaEnemigo(this) || colisiones.colisionMovibleIzquierda(this);
		boolean colisionArriba = colisiones.colisionArribaObjeto(this) || colisiones.colisionArribaEnemigo(this) || colisiones.colisionMovibleArriba(this);
		boolean colisionAbajo = colisiones.colisionAbajoObjeto(this) || colisiones.colisionAbajoEnemigo(this) || colisiones.colisionMovibleAbajo(this);
		boolean colisionManuel = colisiones.colisionAbajoConManuel(this) || colisiones.colisionArribaConManuel(this) || colisiones.colisionDerechaConManuel(this) || colisiones.colisionIzquierdaConManuel(this);
		
		if(colisionManuel || esBola){
			fantasmaSeQuedaQuieto = true;
		}
		else{
			fantasmaSeQuedaQuieto = false;
		}
		
		if(!fantasmaSeQuedaQuieto){
			if(direccion == ARRIBA){
				if(!colisionArriba && manuel.getPosicion().x == posicion.x && manuel.getPosicion().y > posicion.y){
					correr = true;
					moverArriba();
				}
				else if(colisionArriba){
					correr = false;
					direccion = DERECHA;
					moverDerecha();
				}
				else{
					correr = false;
					moverArriba();
				}
			}
			else if(direccion == ABAJO){
				if(!colisionAbajo && manuel.getPosicion().x == posicion.x && manuel.getPosicion().y < posicion.y){
					correr = true;
					moverAbajo();
				}
				else if(colisionAbajo){
					correr = false;
					direccion = IZQUIERDA;
					moverIzquierda();
				}
				else{
					correr = false;
					moverAbajo();
				}
			}
			else if(direccion == DERECHA){
				if(!colisionDerecha && manuel.getPosicion().y == posicion.y && manuel.getPosicion().x > posicion.x){
					correr = true;
					moverDerecha();
				}
				else if(colisionDerecha){
					correr = false;
					direccion = ABAJO;
					moverAbajo();
				}
				else{
					correr = false;
					moverDerecha();
				}
			}
			else{ //direccion == IZQUIERDA
				if(!colisionIzquierda && manuel.getPosicion().y == posicion.y && manuel.getPosicion().x < posicion.x){
					correr = true;
					moverIzquierda();
				}
				else if(colisionIzquierda){
					correr = false;
					direccion = ARRIBA;
					moverArriba();
				}
				else{
					correr = false;
					moverIzquierda();
				}
			}
		}
		else{
			correr = false; 
			frameActual = fantasmaMatrizFrames[direccion][SPRITE_QUIETO];
		}
		
		if(correr == false && tiempoParaMovimiento > 0)
			tiempoParaMovimiento--;
		if(correr == true && tiempoMovimientoCorrer > 0)
			tiempoMovimientoCorrer--;
		
		super.update();
	}
	
	private void moverDerecha(){
		if(correr == true){
			if(tiempoMovimientoCorrer == 0){
				posicion.x = (float) (posicion.x + Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
				frameActual = fantasmaAnimationDerecha.getKeyFrame(stateTime, true);
				tiempoMovimientoCorrer = Constant.TIEMPO_MOVIMIENTO_FANTASMA / 4;
			}
		}
		else{
			if(tiempoParaMovimiento == 0){
				posicion.x = (float) (posicion.x + Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
				frameActual = fantasmaAnimationDerecha.getKeyFrame(stateTime, true);
				tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO_FANTASMA;
			}
		}
	}
	
	private void moverIzquierda(){
		if(correr == true){
			if(tiempoMovimientoCorrer == 0){
				posicion.x = (float) (posicion.x - Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
				frameActual = fantasmaAnimationIzquierda.getKeyFrame(stateTime, true);
				tiempoMovimientoCorrer = Constant.TIEMPO_MOVIMIENTO_FANTASMA / 4;
			}
		}
		else{
			if(tiempoParaMovimiento == 0){
				posicion.x = (float) (posicion.x - Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
				frameActual = fantasmaAnimationIzquierda.getKeyFrame(stateTime, true);
				tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO_FANTASMA;
			}
		}
	}
	
	private void moverArriba(){
		if(correr == true){
			if(tiempoMovimientoCorrer == 0){
				posicion.y = (float) (posicion.y + Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
				frameActual = fantasmaAnimationArriba.getKeyFrame(stateTime, true);
				tiempoMovimientoCorrer = Constant.TIEMPO_MOVIMIENTO_FANTASMA / 4;
			}
		}
		else{
			if(tiempoParaMovimiento == 0){
				posicion.y = (float) (posicion.y + Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
				frameActual = fantasmaAnimationArriba.getKeyFrame(stateTime, true);
				tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO_FANTASMA;
			}
		}
	}
	
	private void moverAbajo(){
		if(correr == true){
			if(tiempoMovimientoCorrer == 0){
				posicion.y = (float) (posicion.y - Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
				frameActual = fantasmaAnimationAbajo.getKeyFrame(stateTime, true);
				tiempoMovimientoCorrer = Constant.TIEMPO_MOVIMIENTO_FANTASMA / 4;
			}
		}
		else{
			if(tiempoParaMovimiento == 0){
				posicion.y = (float) (posicion.y - Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
				frameActual = fantasmaAnimationAbajo.getKeyFrame(stateTime, true);
				tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO_FANTASMA;
			}	
		}
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		super.draw(batch);
	}
	
	// Getters and Setters ------------------------------------------------------------------------
	
}
