package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonModoHistoria extends Boton {

	public BotonModoHistoria(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/BotonModoHistoria.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		mainScreen.menuModoHistoria();
	}
}
