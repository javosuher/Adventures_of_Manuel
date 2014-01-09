package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.Constant;

public class Bloque extends ObjetoDelJuego {
	private Vector2 posicion;
	private Rectangle bordes;
	private Texture TexturaBloque;
	
	public Bloque(Vector2 posicion){
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
		TexturaBloque = new Texture("Miscelanea/Bloque.png");
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(TexturaBloque, posicion.x, posicion.y, bordes.height, bordes.width);
	}

	@Override
	public Vector2 getPosicion() {
		return posicion;
	}

	@Override
	public Rectangle getBordes() {
		return bordes;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}
}