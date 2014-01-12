package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonSiguienteNivel extends Boton {

	public BotonSiguienteNivel(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/BotonSiguienteNivel.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		
	}
}
