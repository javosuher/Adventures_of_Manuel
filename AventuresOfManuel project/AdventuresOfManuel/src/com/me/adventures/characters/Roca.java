package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.Constant;

public class Roca extends ObjetoDelJuego { 
	private Vector2 posicion;
	private Rectangle bordes;
	private Texture TexturaRoca;
	
	public Roca(Vector2 posicion) {
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
		TexturaRoca = new Texture("Miscelanea/Roca.png");
		TexturaRoca.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(TexturaRoca, posicion.x, posicion.y, bordes.height, bordes.width);
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
