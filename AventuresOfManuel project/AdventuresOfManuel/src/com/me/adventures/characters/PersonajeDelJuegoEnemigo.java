package com.me.adventures.characters;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
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
	
	public PersonajeDelJuegoEnemigo(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel) {
		super(adventures, posicion);
		this.manuel = manuel;
		this.posicionInicial = new Vector2(posicion.x, posicion.y);
		esBola = false;
		estaDesaparecido = false;
		tiempoEnBola = Constant.TIEMPO_BOLA;
		tiempoDesaparecido = Constant.TIEMPO_DESAPARECIDO;
		
		// Texturas bola
		TexturaBola = adventures.getManager().get("Miscelanea/Huevo.png", Texture.class);
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
		if(colisiones.colisionMovibleArriba(manuel) && teclaArriba() && !colisiones.colisionArribaObjeto(this) && !colisiones.colisionArribaEnemigo(this)) {
			posicion.y = posicion.y + Gdx.graphics.getDeltaTime() * Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccionHuevo = manuel.ARRIBA;
			estaQuieto = false;
		}
		else if(colisiones.colisionMovibleAbajo(manuel) && teclaAbajo() && !colisiones.colisionAbajoObjeto(this) && !colisiones.colisionAbajoEnemigo(this)) {
			posicion.y = posicion.y - Gdx.graphics.getDeltaTime() * Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccionHuevo = manuel.ABAJO;
			estaQuieto = false;
		}
		else if(colisiones.colisionMovibleDerecha(manuel) && teclaDerecha() && !colisiones.colisionDerechaObjeto(this) && !colisiones.colisionDerechaEnemigo(this)) {
			posicion.x = posicion.x + Gdx.graphics.getDeltaTime() * Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccionHuevo = manuel.DERECHA;
			estaQuieto = false;
		}
		else if(colisiones.colisionMovibleIzquierda(manuel) && teclaIzquierda() && !colisiones.colisionIzquierdaObjeto(this) && !colisiones.colisionIzquierdaEnemigo(this)) {
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
	
	private boolean teclaArriba() {
		if(Gdx.app.getType() == ApplicationType.Desktop)
			return Gdx.input.isKeyPressed(Keys.UP);
		else if(Gdx.app.getType() == ApplicationType.Android)
			return Gdx.input.isTouched() && Gdx.input.getY() < 50;
		else return false;
	}
	private boolean teclaAbajo() {
		if(Gdx.app.getType() == ApplicationType.Desktop)
			return Gdx.input.isKeyPressed(Keys.DOWN);
		else if(Gdx.app.getType() == ApplicationType.Android)
			return Gdx.input.isTouched() && Gdx.input.getY() > Gdx.graphics.getHeight() - 50;
		else return false;
	}
	private boolean teclaDerecha() {
		if(Gdx.app.getType() == ApplicationType.Desktop)
			return Gdx.input.isKeyPressed(Keys.RIGHT);
		else if(Gdx.app.getType() == ApplicationType.Android)
			return Gdx.input.isTouched() && Gdx.input.getX() > Gdx.graphics.getWidth() - 50;
		else return false;
	}
	private boolean teclaIzquierda() {
		if(Gdx.app.getType() == ApplicationType.Desktop)
			return Gdx.input.isKeyPressed(Keys.LEFT);
		else if(Gdx.app.getType() == ApplicationType.Android)
			return Gdx.input.isTouched() && Gdx.input.getX() < 50;
		else return false;
	}
	
	public void desaparecer() {
		posicion.x = posicion.y = -1000;
		bordes.x = bordes.y = -1000;
		estaDesaparecido = true;
		esBola = false;
	}
}
