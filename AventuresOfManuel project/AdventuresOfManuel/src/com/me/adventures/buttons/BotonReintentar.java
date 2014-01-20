package com.me.adventures.buttons;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonReintentar extends Boton {
	private Sound sonidoGameOver;

	public BotonReintentar(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		sonidoGameOver = adventures.getManager().get("Musica/Perder.mp3", Sound.class);
		Textura = adventures.getManager().get("Pantallas/BotonReintentar.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		if(adventures.isSonidoActivado())
			sonidoGameOver.play();
		adventures.reintentarNivel();
	}
}
