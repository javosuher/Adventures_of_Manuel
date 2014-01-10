package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

class ProyectilManuel extends Proyectil{
	
	public ProyectilManuel(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		bordes = new Rectangle(0, 0, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
		Textura = new Texture("Miscelanea/ProyectilManolito.png");
		disparoArribaAbajo = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		disparoDerechaIzquierda = new TextureRegion(Textura, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
	}
}