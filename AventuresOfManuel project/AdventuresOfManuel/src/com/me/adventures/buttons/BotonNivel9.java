package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonNivel9 extends Boton {

	public BotonNivel9(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/9.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		//adventures.setNivel(9);
		//adventures.setScreen(adventures.NIVEL9);
	}
}
