package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Agua extends ObjetoDelJuego {
	private int oleaje;
	private int tiempo;

	//Atributos para pintar el Agua
	private TextureRegion[] aguaMatrizFrames;
	private TextureRegion frameActual;
	
	public Agua(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		oleaje = 0;
		tiempo = 0;
		
		Textura = new Texture("Miscelanea/TablaAgua.png");
				
		aguaMatrizFrames = new TextureRegion[6];
		aguaMatrizFrames[0] = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		aguaMatrizFrames[1] = new TextureRegion(Textura, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		aguaMatrizFrames[2] = new TextureRegion(Textura, 116, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		aguaMatrizFrames[3] = new TextureRegion(Textura, 174, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		aguaMatrizFrames[4] = new TextureRegion(Textura, 232, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		aguaMatrizFrames[5] = new TextureRegion(Textura, 290, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		frameActual = aguaMatrizFrames[oleaje];
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(frameActual, posicion.x, posicion.y, bordes.height, bordes.width);
	}
	
	@Override
	public void update() {
		if(tiempo < Constant.TIEMPO_AGUA){
			tiempo++;
		}
		else{
			if(oleaje == 5)
				oleaje = 0;
			else
				oleaje++;
			frameActual = aguaMatrizFrames[oleaje];
			tiempo = 0;
		}
		// Actualizar bordes
		bordes.x = posicion.x;
		bordes.y = posicion.y;
	}
	
	// Getters and Setters ------------------------------------------------------------------------

}
