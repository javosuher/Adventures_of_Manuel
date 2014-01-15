package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonMusica extends Boton {

	public BotonMusica(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/BotonConfiguracionMusica.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		
	}
}
