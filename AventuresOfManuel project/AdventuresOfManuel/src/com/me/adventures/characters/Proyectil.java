package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
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
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
		TexturaProyectil = new Texture("Miscelanea/Proyectil.png");
	}
	
	public void inicializaPosicion(Vector2 posicion, int direccion){
		this.direccion = direccion;
		this.posicion = posicion;
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(TexturaProyectil, posicion.x, posicion.y, bordes.height, bordes.width);
	}

	@Override
	public void update() {}
	
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