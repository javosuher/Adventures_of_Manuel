package com.me.adventures.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.Constant;

public class Serpiente extends PersonajeDelJuego {
	private static final int IZQUIERDA = 0;
    private static final int DERECHA = 1;
	
	private Vector2 posicion;
	private Rectangle bordes;
	private float stateTime;
	private Colision colisiones;
	private Manuel manuel;
	private int direccion;
	private boolean ataqueActivado;

	//Atributos para pintar
	private Texture TexturaSerpiente, TexturaBola;
	private TextureRegion [][] serpienteMatrizFrames;
	private TextureRegion frameActual, huevoNormal, huevoRompiendose, huevoFrameActual;
	private boolean esBola;
	private int tiempoEnBola;
	
	public Serpiente(Vector2 posicion, Manuel manuel) {
		this.ataqueActivado = false;
		this.manuel = manuel;
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		
		TexturaSerpiente = new Texture("Enemigos/TablaSerpiente.png");
		TexturaBola = new Texture("Miscelanea/Huevo.png");

		serpienteMatrizFrames = new TextureRegion[2][2];
		serpienteMatrizFrames[0][0] = new TextureRegion(TexturaSerpiente, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		serpienteMatrizFrames[0][1] = new TextureRegion(TexturaSerpiente, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		serpienteMatrizFrames[1][0] = new TextureRegion(TexturaSerpiente, 0, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		serpienteMatrizFrames[1][1] = new TextureRegion(TexturaSerpiente, 58, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		frameActual = serpienteMatrizFrames[IZQUIERDA][1];
		direccion = IZQUIERDA;
		
		huevoFrameActual = huevoNormal = new TextureRegion(TexturaBola, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		huevoRompiendose = new TextureRegion(TexturaBola, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		
		esBola = false;
		tiempoEnBola = Constant.TIEMPO_BOLA;
		stateTime = 0f;
	}
	
	public void activarAtaque() {
		ataqueActivado = true; // este enemigo no ataca a manuel
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		if(esBola)
			batch.draw(huevoFrameActual, posicion.x, posicion.y, bordes.height, bordes.width);
		else
			batch.draw(frameActual, posicion.x, posicion.y, bordes.height, bordes.width);
	}
	
	@Override
	public void update() {
		if(esBola)
			tiempoEnBola--;
		if(tiempoEnBola < Constant.TIEMPO_BOLA_CAMBIO)
			huevoFrameActual = huevoRompiendose;
		if(tiempoEnBola == 0) {
			esBola = false;
			tiempoEnBola = Constant.TIEMPO_BOLA;
			huevoFrameActual = huevoNormal;
		}
		
		else if(manuel.getBordes().x == posicion.x)
			if(direccion == IZQUIERDA)
				frameActual = serpienteMatrizFrames[direccion][0];
			else
				frameActual = serpienteMatrizFrames[direccion][1];
		  	else if(manuel.getBordes().x < posicion.x) {
		  		direccion = IZQUIERDA;
		  		frameActual = serpienteMatrizFrames[direccion][1];
		  	}
		  	else if(manuel.getBordes().x > posicion.x) {
		  		direccion = DERECHA;
		  		frameActual = serpienteMatrizFrames[direccion][0];   
		  	}
		
		// Actualizar bordes
		bordes.x = posicion.x;
		bordes.y = posicion.y;
	}
	
	@Override
	public void convertirEnBola() {
		esBola = true;
	}
	
	public void moverEnBola() {
		//boolean colisionHuevo = colisiones.colisionHuevo(this);
		if(manuel.getDireccion() == manuel.ARRIBA && Gdx.input.isKeyPressed(Keys.UP)) {
			if(colisiones.colisionManuelConHuevo(this) && !colisiones.colisionObjetoEnemigoArriba(this)) {
				posicion.y = posicion.y + Gdx.graphics.getDeltaTime() * Constant.SPEED;
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
			}
		}
		if(manuel.getDireccion() == manuel.ABAJO && Gdx.input.isKeyPressed(Keys.DOWN)) {
			if(colisiones.colisionManuelConHuevo(this) && !colisiones.colisionObjetoEnemigoAbajo(this)) {
				posicion.y = posicion.y - Gdx.graphics.getDeltaTime() * Constant.SPEED;
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
			}
		}
		if(manuel.getDireccion() == manuel.DERECHA && Gdx.input.isKeyPressed(Keys.RIGHT)) {
			if(colisiones.colisionManuelConHuevo(this) && !colisiones.colisionObjetoEnemigoDerecha(this)) {
				posicion.x = posicion.x + Gdx.graphics.getDeltaTime() * Constant.SPEED;
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
			}
		}
		if(manuel.getDireccion() == manuel.IZQUIERDA && Gdx.input.isKeyPressed(Keys.LEFT)) {
			if(colisiones.colisionManuelConHuevo(this) && !colisiones.colisionObjetoEnemigoIzquierda(this)) {
				posicion.x = posicion.x - Gdx.graphics.getDeltaTime() * Constant.SPEED;
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
			}
		}
		
		// Actualizar bordes
		bordes.x = posicion.x;
		bordes.y = posicion.y;
		
	}
	
	// Getters and Setters ------------------------------------------------------------------------
	
	@Override
	public boolean estaEnBola() {
		return esBola;
	}
	
	@Override
	public Vector2 getPosicion() {
		return posicion;
	}

	public void setPosicion(Vector2 posicion) {
		this.posicion = posicion;
	}

	@Override
	public Rectangle getBordes() {
		return bordes;
	}

	public void setBordes(Rectangle bordes) {
		this.bordes = bordes;
	}
	
	public float getStateTime() {
		return stateTime;
	}

	@Override
	public void setColision(Colision colisiones) {
		this.colisiones = colisiones;		
	}
}
