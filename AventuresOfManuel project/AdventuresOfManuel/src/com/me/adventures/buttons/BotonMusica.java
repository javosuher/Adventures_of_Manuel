package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonMusica extends Boton {
	private Texture TexturaApagado;

	public BotonMusica(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/BotonMusica.png", Texture.class);
		TexturaApagado = adventures.getManager().get("Pantallas/BotonNoMusica.png", Texture.class);
		asignarBordes();
	}
	
	public void draw(SpriteBatch batch) {
		if(adventures.isMusicaActivada())
			batch.draw(Textura, posicion.x, posicion.y, bordes.width, bordes.height);
		else
			batch.draw(TexturaApagado, posicion.x, posicion.y, bordes.width, bordes.height);
	}
	
	@Override
	protected void funcionamiento() {
		adventures.pressMusica();
		if(adventures.getMusicaMenu().isPlaying())
			adventures.getMusicaMenu().stop();
		if(adventures.getMusicaNivel().isPlaying())
			adventures.getMusicaNivel().stop();
	}
}
