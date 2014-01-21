package com.me.adventures.characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Calavera extends PersonajeDelJuegoEnemigo {
	public static final int ABAJO = 0;
	public static final int IZQUIERDA = 1;
	public static final int DERECHA = 2;
	public static final int ARRIBA = 3;
	private static int MAX = 4;
	private int cambio;
	private Random rnd;
	private Sound sonidoGameOver;

	//Atributos para pintar
	private TextureRegion [] calaveraMatrizFrames;
	private Animation calaveraAnimation;
	
	public Calavera(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel) {
		super(adventures, posicion, manuel);
		this.ataqueActivado = false;
		this.cambio = 0;
		sonidoGameOver = adventures.getManager().get("Musica/Perder.mp3", Sound.class);
		rnd = new Random();
		direccion = rnd.nextInt(MAX);
		Textura = adventures.getManager().get("Enemigos/TablaCalaveraFinal.png", Texture.class);

		calaveraMatrizFrames = new TextureRegion[MAX];
		calaveraMatrizFrames[0] = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		calaveraMatrizFrames[1] = new TextureRegion(Textura, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		calaveraMatrizFrames[2] = new TextureRegion(Textura, 116, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		calaveraMatrizFrames[3] = new TextureRegion(Textura, 174, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		
		calaveraAnimation = new Animation(0.05f, calaveraMatrizFrames);
		frameActual = calaveraMatrizFrames[0];
	}
	
	public void activarAtaque() {
		ataqueActivado = true;
	}
	
	public void update() {
		if(ataqueActivado == true){
			boolean colisionDerecha = colisiones.colisionDerechaObjeto(this) || colisiones.colisionDerechaEnemigo(this) || colisiones.colisionMovibleDerecha(this);
			boolean colisionIzquierda = colisiones.colisionIzquierdaObjeto(this) || colisiones.colisionIzquierdaEnemigo(this) || colisiones.colisionMovibleIzquierda(this);
			boolean colisionArriba = colisiones.colisionArribaObjeto(this) || colisiones.colisionArribaEnemigo(this) || colisiones.colisionMovibleArriba(this);
			boolean colisionAbajo = colisiones.colisionAbajoObjeto(this) || colisiones.colisionAbajoEnemigo(this) || colisiones.colisionMovibleAbajo(this);
			boolean colisionManuel = colisiones.colisionAbajoConManuel(this) || colisiones.colisionArribaConManuel(this) || colisiones.colisionDerechaConManuel(this) || colisiones.colisionIzquierdaConManuel(this);
			
			if(!esBola){
				if(colisionManuel){
					if(adventures.isSonidoActivado())
						sonidoGameOver.play();
					adventures.gameOver();
				}
				else{
					if(cambio == 0){
						cambio(colisionAbajo, colisionArriba, colisionDerecha, colisionIzquierda);
					}
					if(tiempoParaMovimiento == 0){
						if(direccion == ARRIBA){
							if(colisionArriba)
								cambio(colisionAbajo, colisionArriba, colisionDerecha, colisionIzquierda);
							mover();
						}
						else if(direccion == ABAJO){
							if(colisionAbajo)
								cambio(colisionAbajo, colisionArriba, colisionDerecha, colisionIzquierda);
							mover();
						}
						else if(direccion == DERECHA){
							if(colisionDerecha)
								cambio(colisionAbajo, colisionArriba, colisionDerecha, colisionIzquierda);
							mover();
						}
						else{
							if(colisionIzquierda)
								cambio(colisionAbajo, colisionArriba, colisionDerecha, colisionIzquierda);
							mover();
						}
					}
				}
			}
		}

		if(tiempoParaMovimiento > 0)
			tiempoParaMovimiento--;
		super.update();
	}
	
	private void cambio(boolean colisionAbajo, boolean colisionArriba, boolean colisionDerecha, boolean colisionIzquierda){
		List<Integer> direccionesPosibles = new ArrayList<Integer>();
		if(direccion == ARRIBA){
			if(!colisionArriba)
				direccionesPosibles.add(3);
			if(!colisionDerecha)
				direccionesPosibles.add(2);
			if(!colisionIzquierda)
				direccionesPosibles.add(1);
			if(direccionesPosibles.size() == 0){
				if(!colisionAbajo)
					direccionesPosibles.add(0);
			}
		}
		else if(direccion == ABAJO){
			if(!colisionAbajo)
				direccionesPosibles.add(0);
			if(!colisionDerecha)
				direccionesPosibles.add(2);
			if(!colisionIzquierda)
				direccionesPosibles.add(1);
			if(direccionesPosibles.size() == 0){
				if(!colisionArriba)
					direccionesPosibles.add(3);
			}
		}
		else if(direccion == DERECHA){
			if(!colisionArriba)
				direccionesPosibles.add(3);
			if(!colisionAbajo)
				direccionesPosibles.add(0);
			if(!colisionDerecha)
				direccionesPosibles.add(2);
			if(direccionesPosibles.size() == 0){
				if(!colisionIzquierda)
					direccionesPosibles.add(1);
			}
		}
		else{
			if(!colisionArriba)
				direccionesPosibles.add(3);
			if(!colisionAbajo)
				direccionesPosibles.add(0);
			if(!colisionIzquierda)
				direccionesPosibles.add(1);
			if(direccionesPosibles.size() == 0){
				if(!colisionDerecha)
					direccionesPosibles.add(2);
			}
		}
		if(direccionesPosibles.size() != 0){
			int rand = rnd.nextInt(direccionesPosibles.size());
			direccion = direccionesPosibles.get(rand);
		}
		cambio = 10;
	}

	private void mover(){
		if(direccion == ARRIBA)
			moverArriba();
		else if(direccion == ABAJO)
			moverAbajo();
		else if(direccion == DERECHA)
			moverDerecha();
		else
			moverIzquierda();
	}
	
	private void moverDerecha(){
			posicion.x = (float) (posicion.x + Constant.SPEED);
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			frameActual = calaveraAnimation.getKeyFrame(stateTime, true);
			tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO_CALAVERA;
			if(cambio > 0) cambio--;
	}
	
	private void moverIzquierda(){
			posicion.x = (float) (posicion.x - Constant.SPEED);
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			frameActual = calaveraAnimation.getKeyFrame(stateTime, true);
			tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO_CALAVERA;
			if(cambio > 0) cambio--;
	}
	
	private void moverArriba(){
			posicion.y = (float) (posicion.y + Constant.SPEED);
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			frameActual = calaveraAnimation.getKeyFrame(stateTime, true);
			tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO_CALAVERA;
			if(cambio > 0) cambio--;
	}
	
	private void moverAbajo(){
			posicion.y = (float) (posicion.y - Constant.SPEED);
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			frameActual = calaveraAnimation.getKeyFrame(stateTime, true);
			tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO_CALAVERA;
			if(cambio > 0) cambio--;
	}
	// Getters and Setters ------------------------------------------------------------------------

	@Override
	public void draw(SpriteBatch batch) {
		super.draw(batch);
	}
}
