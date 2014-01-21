package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.screens.Nivel4;

public class BotonNivel3 extends Boton {

	public BotonNivel3(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/3.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		adventures.NIVEL3 = new Nivel4(adventures, new Vector2(541, 174));
		adventures.setNivel(3);
		adventures.setScreen(adventures.NIVEL3);
	}
}
