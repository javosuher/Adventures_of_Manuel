package com.me.adventures.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class Pared extends ObjetoDelJuego {
	
	public Pared(AdventuresOfManuel adventures, Vector2 posicion, int anchura, int altura) {
		super(adventures, posicion);
		bordes = new Rectangle(posicion.x, posicion.y, anchura, altura);
	}

	@Override
	public void draw(SpriteBatch batch) {}

	@Override
	public void update() {}	
}
