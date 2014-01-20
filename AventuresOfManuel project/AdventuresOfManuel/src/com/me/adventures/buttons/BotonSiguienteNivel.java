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
		adventures.siguienteNivel();
		int nivelActual = adventures.getNivelActual();
		if(nivelActual == 1)
			adventures.setScreen(adventures.NIVEL1);
		else if(nivelActual == 2)
			adventures.setScreen(adventures.NIVEL2);
		else if(nivelActual == 3)
			adventures.setScreen(adventures.NIVEL3);
		else if(nivelActual == 4)
			adventures.setScreen(adventures.NIVEL4);
		else if(nivelActual == 5)
			adventures.setScreen(adventures.NIVEL5);
		else if(nivelActual == 6)
			adventures.setScreen(adventures.NIVEL6);
		else if(nivelActual == 7)
			adventures.setScreen(adventures.NIVEL7);
		else if(nivelActual == 8)
			adventures.setScreen(adventures.NIVEL8);
		else if(nivelActual == 9)
			adventures.setScreen(adventures.NIVEL9);
		else if(nivelActual == 10)
			adventures.setScreen(adventures.NIVEL10);
	}
}
