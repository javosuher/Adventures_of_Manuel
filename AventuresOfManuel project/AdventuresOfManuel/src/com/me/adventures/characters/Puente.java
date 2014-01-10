package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.Constant;

public class Puente extends MapaDelJuego {
	private Vector2 posicion;
	private Rectangle bordes;
	private Texture TexturaPuente;
	private TextureRegion frameActual;
	private Agua agua;
	
	public Puente(Vector2 posicion, int orientacion){
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		TexturaPuente = new Texture("Miscelanea/TablaPuente.png");
		if(orientacion == Constant.PUENTE_VERTICAL)
			frameActual = new TextureRegion(TexturaPuente, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		else
			frameActual = new TextureRegion(TexturaPuente, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		agua = new Agua(posicion);
	}

	@Override
	public void draw(SpriteBatch batch) {
		agua.draw(batch);
		batch.draw(frameActual, posicion.x, posicion.y, bordes.height, bordes.width);
	}

	@Override
	public void update() {
		agua.update();
	}

	@Override
	public Vector2 getPosicion() {
		return posicion;
	}

	@Override
	public Rectangle getBordes() {
		return bordes;
	}
}