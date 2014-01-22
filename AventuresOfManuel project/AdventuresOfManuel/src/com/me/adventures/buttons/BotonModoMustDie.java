package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.screens.Nivel1;

public class BotonModoMustDie extends Boton {

	public BotonModoMustDie(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/BotonT.png", Texture.class);
		asignarBordes();
	}
	
	@Override
	protected void funcionamiento() {
		adventures.NIVEL1 = new Nivel1(adventures, new Vector2(193, 464));
		adventures.setTipoJuegoMustDie(true);
		adventures.iniciarMustDie();
	}
}
