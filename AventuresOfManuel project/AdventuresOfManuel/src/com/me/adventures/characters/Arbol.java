package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.Constant;

public class Arbol extends ObjetoDelJuego { 
	private Vector2 posicion;
	private Rectangle bordes;
	private Texture TexturaArbol;
	
	public Arbol(Vector2 posicion) {
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
		TexturaArbol = new Texture("Miscelanea/Arbol.png");
		TexturaArbol.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(TexturaArbol, posicion.x, posicion.y, bordes.height, bordes.width);
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
