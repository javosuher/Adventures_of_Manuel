package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class Bloque extends PersonajeDelJuegoEnemigo {
	
	public Bloque(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel){
		super(adventures, posicion, manuel);
		Textura = adventures.getManager().get("Enemigos/bloque.png", Texture.class);
		esBola = true;
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Textura, posicion.x, posicion.y, bordes.height, bordes.width);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void activarAtaque() {
		// TODO Auto-generated method stub
	}
}