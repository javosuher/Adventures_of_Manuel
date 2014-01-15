package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Calavera extends PersonajeDelJuegoEnemigo {
	private static int MAX = 4;
	private int actual;

	//Atributos para pintar
	private TextureRegion [] calaveraMatrizFrames;
	
	public Calavera(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel) {
		super(adventures, posicion, manuel);
		this.actual = 0;
		this.ataqueActivado = false;
		
		Textura = adventures.getManager().get("Enemigos/TablaCalaveraFinal.png", Texture.class);

		calaveraMatrizFrames = new TextureRegion[MAX];
		calaveraMatrizFrames[0] = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		calaveraMatrizFrames[1] = new TextureRegion(Textura, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		calaveraMatrizFrames[2] = new TextureRegion(Textura, 116, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		calaveraMatrizFrames[3] = new TextureRegion(Textura, 174, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		frameActual = calaveraMatrizFrames[actual];
	}
	
	public void activarAtaque() {
		ataqueActivado = true;
	}
	
	public void update() {
		if(ataqueActivado == true){
			//moverse
			if(tiempoParaMovimiento == 0){
				tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO;
				if(actual == MAX - 1)
					actual = 0;
				else
					actual++;
				frameActual = calaveraMatrizFrames[actual];
			}
			else
				tiempoParaMovimiento--;
		}
	}
	
	// Getters and Setters ------------------------------------------------------------------------
	
}
