package com.me.adventures.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Pared extends ObjetoDelJuego {
	private Vector2 posicion;
	private Rectangle bordes;
	
	public Pared(Vector2 posicion, int anchura, int altura) {
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, anchura, altura);
	}

	@Override
	public void draw(SpriteBatch batch) {}

	@Override
	public void update() {}

	@Override
	public Vector2 getPosicion() {
		return posicion;
	}

	@Override
	public Rectangle getBordes() {
		return bordes;
	}
	
}
