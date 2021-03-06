package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonNivel2 extends Boton {

	public BotonNivel2(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/2.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		adventures.setNivel(2);
		adventures.setScreen(adventures.NIVEL2);
	}
}
