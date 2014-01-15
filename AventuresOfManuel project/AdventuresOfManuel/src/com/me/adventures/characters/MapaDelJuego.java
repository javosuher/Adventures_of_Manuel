package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public abstract class MapaDelJuego implements Entidad {
	protected AdventuresOfManuel adventures;
	protected Vector2 posicion;
	protected Rectangle bordes;
	protected Texture Textura;
	
	public MapaDelJuego(AdventuresOfManuel adventures, Vector2 posicion) {
		this.adventures = adventures;
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
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
}
