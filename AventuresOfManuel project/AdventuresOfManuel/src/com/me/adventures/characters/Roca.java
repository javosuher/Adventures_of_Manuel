package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class Roca extends ObjetoDelJuego { 
	
	public Roca(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = new Texture("Miscelanea/Roca.png");
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Textura, posicion.x, posicion.y, bordes.height, bordes.width);
	}
	
	@Override
	public void update() {}
	
	// Getters and Setters ------------------------------------------------------------------------
	
}
