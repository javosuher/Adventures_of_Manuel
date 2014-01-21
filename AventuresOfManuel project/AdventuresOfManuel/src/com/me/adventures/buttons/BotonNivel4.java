package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.screens.Nivel5;

public class BotonNivel4 extends Boton {

	public BotonNivel4(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/4.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		adventures.NIVEL4 = new Nivel5(adventures, new Vector2(483, 58));
		adventures.setNivel(4);
		adventures.setScreen(adventures.NIVEL4);
	}
}
