package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonNivel10 extends Boton {

	public BotonNivel10(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/10.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		adventures.setScreen(adventures.NIVEL10);
	}
}
