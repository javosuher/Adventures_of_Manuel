package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

class ProyectilEnemigo extends Proyectil{
	
	public ProyectilEnemigo(AdventuresOfManuel adventures, Vector2 posicion, int direccion) {
		super(adventures, posicion);
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
		Textura = new Texture("Enemigos/TablaProyectilDragon.png");
		disparoAbajo = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		disparoDerecha = new TextureRegion(Textura, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		disparoArriba = new TextureRegion(Textura, 116, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		disparoIzquierda = new TextureRegion(Textura, 174, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
	}	
}