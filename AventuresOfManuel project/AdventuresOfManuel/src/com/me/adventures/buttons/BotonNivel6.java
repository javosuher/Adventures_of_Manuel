package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.screens.Nivel7;

public class BotonNivel6 extends Boton {

	public BotonNivel6(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/6.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		adventures.NIVEL6 = new Nivel7(adventures, new Vector2(193, 232));
		adventures.setNivel(6);
		adventures.setScreen(adventures.NIVEL6);
	}
}
