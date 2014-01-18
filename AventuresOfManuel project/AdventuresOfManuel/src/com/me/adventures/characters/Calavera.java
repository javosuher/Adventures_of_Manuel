package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Calavera extends PersonajeDelJuegoEnemigo {
	private static int MAX = 4;

	//Atributos para pintar
	private TextureRegion [] calaveraMatrizFrames;
	private Animation calaveraAnimation;
	
	public Calavera(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel) {
		super(adventures, posicion, manuel);
		this.ataqueActivado = false;
		
		Textura = adventures.getManager().get("Enemigos/TablaCalaveraFinal.png", Texture.class);

		calaveraMatrizFrames = new TextureRegion[MAX];
		calaveraMatrizFrames[0] = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		calaveraMatrizFrames[1] = new TextureRegion(Textura, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		calaveraMatrizFrames[2] = new TextureRegion(Textura, 116, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		calaveraMatrizFrames[3] = new TextureRegion(Textura, 174, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		
		calaveraAnimation = new Animation(0.05f, calaveraMatrizFrames);
		frameActual = calaveraMatrizFrames[0];
	}
	
	public void activarAtaque() {
		ataqueActivado = true;
	}
	
	public void update() {
		if(ataqueActivado == true){
			if(tiempoParaMovimiento == 0){
				frameActual = calaveraAnimation.getKeyFrame(stateTime, true);
				tiempoParaMovimiento = Constant.TIEMPO_MOVIMIENTO_CALAVERA;
			}
			else
				tiempoParaMovimiento--;
		}
	}
	
	// Getters and Setters ------------------------------------------------------------------------
	
}
