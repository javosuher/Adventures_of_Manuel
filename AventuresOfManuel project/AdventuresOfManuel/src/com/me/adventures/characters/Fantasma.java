package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Fantasma extends PersonajeDelJuegoEnemigo {
	public static final int ABAJO = 0;
	public static final int IZQUIERDA = 1;
	public static final int DERECHA = 2;
	public static final int ARRIBA = 3;
	
	//Atributos para pintar
	private TextureRegion [][] fantasmaMatrizFrames;
	private Animation fantasmaAnimationAbajo, fantasmaAnimationIzquierda, fantasmaAnimationDerecha, fantasmaAnimationArriba;
	
	public Fantasma(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel) {
		super(adventures, posicion, manuel);
		this.ataqueActivado = false;
		
		Textura = adventures.getManager().get("Enemigos/TablaFantasma.png", Texture.class);
		
		fantasmaMatrizFrames = TextureRegion.split(Textura, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		// Asignamos las animaciones de las direcciones del Fantasma
		fantasmaAnimationAbajo = new Animation(0.05f, fantasmaMatrizFrames[ABAJO]);
		fantasmaAnimationIzquierda = new Animation(0.05f, fantasmaMatrizFrames[IZQUIERDA]);
		fantasmaAnimationDerecha= new Animation(0.05f, fantasmaMatrizFrames[DERECHA]);
		fantasmaAnimationArriba = new Animation(0.05f, fantasmaMatrizFrames[ARRIBA]);

	}
	
	public void activarAtaque() {
	}
	
	public void update() {
	}
	
	// Getters and Setters ------------------------------------------------------------------------
	
}
