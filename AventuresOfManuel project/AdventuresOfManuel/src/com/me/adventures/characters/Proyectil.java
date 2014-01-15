package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public abstract class Proyectil extends ObjetoDelJuego{
	protected static final int ABAJO = 0;
	protected static final int IZQUIERDA = 1;
	protected static final int DERECHA = 2;
	protected static final int ARRIBA = 3;
	
	protected int direccion;
	protected TextureRegion disparoAbajo, disparoArriba, disparoDerecha, disparoIzquierda, disparoDireccion;

	public Proyectil(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
	}
	
	public void inicializaPosicion(Vector2 posicion, int direccion){
		this.direccion = direccion;
		if(direccion == ABAJO) {
			this.posicion.x = posicion.x;
			this.posicion.y = posicion.y - 58;
		}
		if(direccion == ARRIBA) {
			this.posicion.x = posicion.x;
			this.posicion.y = posicion.y + 58;
		}
		if(direccion == DERECHA) {
			this.posicion.x = posicion.x + 58;
			this.posicion.y = posicion.y;
		}
		if(direccion == IZQUIERDA) {
			this.posicion.x = posicion.x - 58;
			this.posicion.y = posicion.y;
		}
		
		if(direccion == DERECHA) // Se verá de forma distinta dependiendo la dirección que se dispare
			disparoDireccion = disparoDerecha;
		else if(direccion == IZQUIERDA)
			disparoDireccion = disparoIzquierda;
		else if (direccion == ARRIBA)
			disparoDireccion = disparoArriba;
		else
			disparoDireccion = disparoAbajo;
		
		// Actualizar bordes
		bordes.x = posicion.x;
		bordes.y = posicion.y;
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(disparoDireccion, posicion.x, posicion.y, bordes.height, bordes.width);
	}
	
	@Override
	public void update() {
		if(direccion == ABAJO) 
			posicion.y -= Constant.BOLA_SPEED;
		if(direccion == ARRIBA)
			posicion.y += Constant.BOLA_SPEED;
		if(direccion == DERECHA)
			posicion.x += Constant.BOLA_SPEED;
		if(direccion == IZQUIERDA)
			posicion.x -= Constant.BOLA_SPEED;
		
		// Actualizar bordes
		bordes.x = posicion.x;
		bordes.y = posicion.y;
	}
	
	// Getters and Setters ------------------------------------------------------------------------
	
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
	
}