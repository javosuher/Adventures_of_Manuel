package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class Arbol extends ObjetoDelJuego { 
	
	public Arbol(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Miscelanea/Arbol.png", Texture.class);
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Textura, posicion.x, posicion.y, bordes.height, bordes.width);
	}
	
	@Override
	public void update() {}
	
	// Getters and Setters ------------------------------------------------------------------------

}
