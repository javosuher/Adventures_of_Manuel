package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.screens.Nivel6;

public class BotonNivel5 extends Boton {

	public BotonNivel5(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/5.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		adventures.NIVEL5 = new Nivel6(adventures, new Vector2(483, 58));
		adventures.setNivel(5);
		adventures.setScreen(adventures.NIVEL5);
	}
}
