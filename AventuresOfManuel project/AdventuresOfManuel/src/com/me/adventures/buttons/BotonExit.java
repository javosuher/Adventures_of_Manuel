package com.me.adventures.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonExit extends Boton {

	public BotonExit(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/BotonExit.png", Texture.class);
		asignarBordes();
	}
	public BotonExit(AdventuresOfManuel adventures, Vector2 posicion, boolean sePuedeVisualizar) {
		super(adventures, posicion, sePuedeVisualizar);
		Textura = adventures.getManager().get("Pantallas/BotonExit.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		Gdx.app.exit();
	}
}
