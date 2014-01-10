package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

class Proyectil extends ObjetoDelJuego{
	private static final int ABAJO = 0;
	private static final int IZQUIERDA = 1;
	private static final int DERECHA = 2;
	private static final int ARRIBA = 3;
	
	private TextureRegion disparoArribaAbajo, disparoDerechaIzquierda, disparoDireccion;
	private int direccion;
	
	public Proyectil(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		bordes = new Rectangle(0, 0, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
		Textura = adventures.getManager().get("Miscelanea/ProyectilManolito.png", Texture.class);
		disparoArribaAbajo = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		disparoDerechaIzquierda = new TextureRegion(Textura, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
	}
	
	public void inicializaPosicion(Vector2 posicion, int direccion){
		this.direccion = direccion;
		if(direccion == ABAJO) {
			this.posicion.x = posicion.x;
			this.posicion.y = posicion.y - 58;
		}
		if(direccion == ARRIBA) {
			this.posicion.x = posicion.x;
			this.posicion.y = posicion.y + 58;
		}
		if(direccion == DERECHA) {
			this.posicion.x = posicion.x + 58;
			this.posicion.y = posicion.y;
		}
		if(direccion == IZQUIERDA) {
			this.posicion.x = posicion.x - 58;
			this.posicion.y = posicion.y;
		}
		
		if(direccion == DERECHA || direccion == IZQUIERDA) // Se verá de forma distinta dependiendo la dirección que se dispare
			disparoDireccion = disparoDerechaIzquierda;
		else
			disparoDireccion = disparoArribaAbajo;
		
		// Actualizar bordes
		bordes.x = posicion.x;
		bordes.y = posicion.y;
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(disparoDireccion, posicion.x, posicion.y, bordes.height, bordes.width);
	}
	
	@Override
	public void update() {
		if(direccion == ABAJO) 
			posicion.y -= Constant.BOLA_SPEED;
		if(direccion == ARRIBA)
			posicion.y += Constant.BOLA_SPEED;
		if(direccion == DERECHA)
			posicion.x += Constant.BOLA_SPEED;
		if(direccion == IZQUIERDA)
			posicion.x -= Constant.BOLA_SPEED;
		
		// Actualizar bordes
		bordes.x = posicion.x;
		bordes.y = posicion.y;
	}
	
	// Getters and Setters ------------------------------------------------------------------------
	
}