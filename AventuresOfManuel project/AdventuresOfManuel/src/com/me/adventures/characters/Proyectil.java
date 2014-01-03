package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.Constant;

class Proyectil extends ObjetoDelJuego{
	private static final int ABAJO = 0;
	private static final int IZQUIERDA = 1;
	private static final int DERECHA = 2;
	private static final int ARRIBA = 3;
	
	private Vector2 posicion;
	private Rectangle bordes;
	private Texture TexturaProyectil;
	private int direccion;
	
	public Proyectil() {
		bordes = new Rectangle(0, 0, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
		TexturaProyectil = new Texture("Miscelanea/Roca.png");
		posicion = new Vector2();
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
		
		// Actualizar bordes
		bordes.x = posicion.x;
		bordes.y = posicion.y;
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(TexturaProyectil, posicion.x, posicion.y, bordes.height, bordes.width);
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