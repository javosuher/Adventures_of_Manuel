package com.me.adventures.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonExit extends Boton {

	public BotonExit(AdventuresOfManuel adventures, Vector2 posicion, boolean principal) {
		super(adventures, posicion);
		if(principal == true)
			Textura = adventures.getManager().get("Pantallas/BotonT.png", Texture.class);
		else
			Textura = adventures.getManager().get("Pantallas/BotonSalir.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		adventures.getPreferencias().putBoolean("Sonido", adventures.isSonidoActivado());
		adventures.getPreferencias().putBoolean("Musica", adventures.isMusicaActivada());
		adventures.getPreferencias().flush();
		Gdx.app.exit();
		//System.exit(0);
	}
}
