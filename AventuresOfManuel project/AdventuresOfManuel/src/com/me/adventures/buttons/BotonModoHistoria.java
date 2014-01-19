package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class BotonModoHistoria extends Boton {
	private boolean mostrar;

	public BotonModoHistoria(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		Textura = adventures.getManager().get("Pantallas/BotonNoTransparente.png", Texture.class);
		asignarBordes();
		mostrar = true;
	}
	
	@Override
	protected void funcionamiento() {
		if(mostrar) {
			mostrar = false;
			mainScreen.menuModoHistoria();
		}
		else {
			mostrar = true;
			mainScreen.borrarMenuModoHistoria();
		}
	}
}
