package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonNivel7 extends Boton {

	public BotonNivel7(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/7.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		adventures.setNivel(7);
		adventures.setScreen(adventures.NIVEL7);
	}
}
