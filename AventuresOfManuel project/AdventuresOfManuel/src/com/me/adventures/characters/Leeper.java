//Bicho verde
package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Leeper extends PersonajeDelJuegoEnemigo {
	public static final int ABAJO = 0;
	public static final int IZQUIERDA = 1;
	public static final int DERECHA = 2;
	public static final int ARRIBA = 3;
	private static final int DORMIDO = 0;
	private static final int DESPIERTO = 1;
	
	
	//Atributos para pintar
	private TextureRegion [][] leeperMatrizFrames;
	private Animation leeperAnimationAbajo, leeperAnimationIzquierda, leeperAnimationDerecha, leeperAnimationArriba;

	public Leeper(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel, int direccion) {
		super(adventures, posicion, manuel);
		this.ataqueActivado = false;
		this.direccion = direccion;
		
		Textura = new Texture("Enemigos/TablaBichoVerde.png");
		
		leeperMatrizFrames = new TextureRegion[4][4];
		leeperMatrizFrames[0][0] = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		
		frameActual = leeperMatrizFrames[direccion][DORMIDO];
	}
	
	public void activarAtaque() {
		ataqueActivado = true;
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		super.draw(batch);
	}
	// Getters and Setters -----------------------------------------------------------------------
}
