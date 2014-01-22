package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonInstrucciones extends Boton {

	public BotonInstrucciones(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/BotonT.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		
	}
}
