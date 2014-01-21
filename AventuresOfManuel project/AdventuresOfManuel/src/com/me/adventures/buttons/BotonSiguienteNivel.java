package com.me.adventures.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.screens.Nivel1;
import com.me.adventures.screens.Nivel3;
import com.me.adventures.screens.Nivel4;
import com.me.adventures.screens.Nivel5;
import com.me.adventures.screens.Nivel6;
import com.me.adventures.screens.Nivel7;
import com.me.adventures.screens.Nivel8;

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
		if(nivelActual == 1){
			adventures.NIVEL1 = new Nivel1(adventures, new Vector2(193, 464));
			adventures.setScreen(adventures.NIVEL1);
		}			
	
		else if(nivelActual == 2){
			adventures.NIVEL1.dispose();
			adventures.NIVEL2 = new Nivel3(adventures, new Vector2(425, 116));
			adventures.setScreen(adventures.NIVEL2);
			
		}
		else if(nivelActual == 3){
			adventures.NIVEL2.dispose();
			adventures.NIVEL3 = new Nivel4(adventures, new Vector2(541, 174));
			adventures.setScreen(adventures.NIVEL3);
			
		}
		else if(nivelActual == 4){
			adventures.NIVEL3.dispose();
			adventures.NIVEL4 = new Nivel5(adventures, new Vector2(483, 58));
			adventures.setScreen(adventures.NIVEL4);
		}
		else if(nivelActual == 5){
			adventures.NIVEL4.dispose();
			adventures.NIVEL5 = new Nivel6(adventures, new Vector2(483, 58));
			adventures.setScreen(adventures.NIVEL5);
		}
		else if(nivelActual == 6){
			adventures.NIVEL5.dispose();
			adventures.NIVEL6 = new Nivel7(adventures, new Vector2(193, 232));
			adventures.setScreen(adventures.NIVEL6);
		}
		
		else if(nivelActual == 7){
			adventures.NIVEL6.dispose();
			adventures.NIVEL7 = new Nivel8(adventures, new Vector2(773, 58));
			adventures.setScreen(adventures.NIVEL7);
		}	
		/*else if(nivelActual == 8)
			adventures.setScreen(adventures.NIVEL8);
		else if(nivelActual == 9)
			adventures.setScreen(adventures.NIVEL9);
		else if(nivelActual == 10)
			adventures.setScreen(adventures.NIVEL10);*/
	}
}
