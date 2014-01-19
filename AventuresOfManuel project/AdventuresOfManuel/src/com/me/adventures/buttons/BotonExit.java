package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonExit extends Boton {

	public BotonExit(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/BotonNoTransparente.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		adventures.getPreferencias().putBoolean("Sonido", adventures.isSonidoActivado());
		adventures.getPreferencias().putBoolean("Musica", adventures.isMusicaActivada());
		adventures.getPreferencias().flush();
		System.exit(0);
	}
}
