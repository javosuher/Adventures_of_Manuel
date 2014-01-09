package com.me.adventures.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.Constant;

public abstract class PersonajeDelJuegoEnemigo extends PersonajeDelJuego {
	protected Vector2 posicionInicial;
	protected boolean ataqueActivado;
	protected Manuel manuel;

	//Atributos para pintar
	protected Texture TexturaBola;
	protected TextureRegion huevoNormal, huevoRompiendose, huevoFrameActual;
	protected boolean esBola;
	protected boolean estaDesaparecido;
	protected int tiempoEnBola;
	protected int tiempoDesaparecido;
	
	public PersonajeDelJuegoEnemigo(Vector2 posicion, Manuel manuel) {
		super(posicion);
		this.manuel = manuel;
		this.posicionInicial = new Vector2(posicion.x, posicion.y);
		esBola = false;
		estaDesaparecido = false;
		tiempoEnBola = Constant.TIEMPO_BOLA;
		tiempoDesaparecido = Constant.TIEMPO_DESAPARECIDO;
		
		// Texturas bola
		TexturaBola = new Texture("Miscelanea/Huevo.png");
		huevoFrameActual = huevoNormal = new TextureRegion(TexturaBola, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		huevoRompiendose = new TextureRegion(TexturaBola, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
	}
	
	@Override
	public void update() {
		if(esBola) {
			tiempoEnBola--;
			if(tiempoEnBola < Constant.TIEMPO_BOLA_CAMBIO)
				huevoFrameActual = huevoRompiendose;
			if(tiempoEnBola == 0) {
				esBola = false;
				tiempoEnBola = Constant.TIEMPO_BOLA;
				huevoFrameActual = huevoNormal;
				colisiones.finHuevo(this);
			}
		}
		if(estaDesaparecido) {
			tiempoDesaparecido--;
			if(tiempoDesaparecido == 0) {
				estaDesaparecido = false;
				tiempoDesaparecido = Constant.TIEMPO_DESAPARECIDO;
				posicion = posicionInicial;
			}
		}	
		
		// Actualizar bordes
		bordes.x = posicion.x;
		bordes.y = posicion.y;
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		if(esBola)
			batch.draw(huevoFrameActual, posicion.x, posicion.y, bordes.height, bordes.width);
		else
			batch.draw(frameActual, posicion.x, posicion.y, bordes.height, bordes.width);
	}
	
	public void convertirEnBola() {
		esBola = true;
	}
	
	public boolean estaEnBola() {
		return esBola;
	}
	
	public void moverEnBola() {
		int direccionHuevo = -1;
		boolean estaQuieto = true;
		if(colisiones.colisionMovibleArriba(manuel) && Gdx.input.isKeyPressed(Keys.UP) && !colisiones.colisionArribaObjeto(this) && !colisiones.colisionArribaEnemigo(this)) {
			posicion.y = posicion.y + Gdx.graphics.getDeltaTime() * Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccionHuevo = manuel.ARRIBA;
			estaQuieto = false;
		}
		else if(colisiones.colisionMovibleAbajo(manuel) && Gdx.input.isKeyPressed(Keys.DOWN) && !colisiones.colisionAbajoObjeto(this) && !colisiones.colisionAbajoEnemigo(this)) {
			posicion.y = posicion.y - Gdx.graphics.getDeltaTime() * Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccionHuevo = manuel.ABAJO;
			estaQuieto = false;
		}
		else if(colisiones.colisionMovibleDerecha(manuel) && Gdx.input.isKeyPressed(Keys.RIGHT) && !colisiones.colisionDerechaObjeto(this) && !colisiones.colisionDerechaEnemigo(this)) {
			posicion.x = posicion.x + Gdx.graphics.getDeltaTime() * Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccionHuevo = manuel.DERECHA;
			estaQuieto = false;
		}
		else if(colisiones.colisionMovibleIzquierda(manuel) && Gdx.input.isKeyPressed(Keys.LEFT) && !colisiones.colisionIzquierdaObjeto(this) && !colisiones.colisionIzquierdaEnemigo(this)) {
			posicion.x = posicion.x - Gdx.graphics.getDeltaTime() * Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccionHuevo = manuel.IZQUIERDA;
			estaQuieto = false;
		}
		
		//if(estaQuieto) {
			if(direccionHuevo == manuel.ABAJO) {
				int nuevaPosicion = (int) posicion.y;
				while(nuevaPosicion % 29 != 0) // Ajusta la posición
					nuevaPosicion--;
				posicion.y = nuevaPosicion;
			}
			else if(direccionHuevo == manuel.IZQUIERDA) {
				int nuevaPosicion = (int) posicion.x;
				while(nuevaPosicion % 29 != 19) // Ajusta la posición
					nuevaPosicion--;
				posicion.x = nuevaPosicion;
			}
			else if(direccionHuevo == manuel.DERECHA) {
				int nuevaPosicion = (int) posicion.x;
				while(nuevaPosicion % 29 != 19) // Ajusta la posición
					nuevaPosicion++;
				posicion.x = nuevaPosicion;
			}
			else if(direccionHuevo == manuel.ARRIBA) {
				int nuevaPosicion = (int) posicion.y;
				while(nuevaPosicion % 29 != 0) // Ajusta la posición
					nuevaPosicion++;
				posicion.y = nuevaPosicion;
			}
		//}
		
		// Actualizar bordes
		bordes.x = posicion.x;
		bordes.y = posicion.y;	
	}
	
	public void desaparecer() {
		posicion.x = posicion.y = -1000;
		bordes.x = bordes.y = -1000;
		estaDesaparecido = true;
		esBola = false;
	}
}
