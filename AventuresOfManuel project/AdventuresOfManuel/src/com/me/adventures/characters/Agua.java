package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.Constant;

public class Agua extends ObjetoDelJuego {
	private Vector2 posicion;
	private Rectangle bordes;
	private int oleaje;
	private int tiempo;

	//Atributos para pintar el Agua
	private Texture TexturaAgua;
	private TextureRegion[] aguaMatrizFrames;
	private TextureRegion frameActual;
	
	public Agua(Vector2 posicion) {
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		oleaje = 0;
		tiempo = 0;
		
		TexturaAgua = new Texture("Miscelanea/TablaAgua.png");
				
		aguaMatrizFrames = new TextureRegion[6];
		aguaMatrizFrames[0] = new TextureRegion(TexturaAgua, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		aguaMatrizFrames[1] = new TextureRegion(TexturaAgua, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		aguaMatrizFrames[2] = new TextureRegion(TexturaAgua, 116, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		aguaMatrizFrames[3] = new TextureRegion(TexturaAgua, 174, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		aguaMatrizFrames[4] = new TextureRegion(TexturaAgua, 232, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		aguaMatrizFrames[5] = new TextureRegion(TexturaAgua, 290, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
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
	@Override
	public Vector2 getPosicion() {
		return posicion;
	}

	public void setPosicion(Vector2 posicion) {
		this.posicion = posicion;
	}

	@Override
	public Rectangle getBordes() {
		return bordes;
	}

	public void setBordes(Rectangle bordes) {
		this.bordes = bordes;
	}
}
