package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Puente extends MapaDelJuego {
	private TextureRegion frameActual;
	private Agua agua;
	
	public Puente(AdventuresOfManuel adventures, Vector2 posicion, int orientacion){
		super(adventures, posicion);
		Textura = adventures.getManager().get("Miscelanea/TablaPuente.png", Texture.class);
		if(orientacion == Constant.PUENTE_VERTICAL)
			frameActual = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		else
			frameActual = new TextureRegion(Textura, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		agua = new Agua(adventures, posicion);
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
}