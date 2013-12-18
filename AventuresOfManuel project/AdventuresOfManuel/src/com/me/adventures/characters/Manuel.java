package com.me.adventures.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.Constant;

public class Manuel extends PersonajeDelJuego {
	//Constantes locales
	private static final int ABAJO = 0;
	private static final int IZQUIERDA = 1;
	private static final int DERECHA = 2;
	private static final int ARRIBA = 3;
	private static final int SPRITE_QUIETO = 2;
    
	// Atributos básicos
	private Vector2 posicion;
	private Rectangle bordes;
	private float stateTime;
	private int direccion;
	private Colision colisiones;
	
	//Atributos para pintar a Manuel
	private Texture TexturaManuel;
	private TextureRegion [][] manuelMatrizFrames;
	private TextureRegion frameActual;
	private Animation manuelAnimationAbajo, manuelAnimationIzquierda, manuelAnimationDerecha, manuelAnimationArriba;
	
	public Manuel(Vector2 posicion) {
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		stateTime = 0f;
		direccion = ABAJO;
		
		TexturaManuel = new Texture("Manolito/TablaSpritesManolitoTransparencia.png");
		TexturaManuel.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		manuelMatrizFrames = TextureRegion.split(TexturaManuel, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		
		// Asignamos las animaciones de las direcciones de Manuel
		manuelAnimationAbajo = new Animation(0.05f, manuelMatrizFrames[ABAJO]);
		manuelAnimationIzquierda = new Animation(0.05f, manuelMatrizFrames[IZQUIERDA]);
		manuelAnimationDerecha= new Animation(0.05f, manuelMatrizFrames[DERECHA]);
		manuelAnimationArriba = new Animation(0.05f, manuelMatrizFrames[ARRIBA]);
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(frameActual, posicion.x, posicion.y, bordes.height, bordes.width);
	}
	
	@Override
	public void update() {
		// Determina movimiento de Manuel
		boolean soloUnaTeclaPresionada = true;
		boolean manuelSeQuedaQuieto = false;
		if(Gdx.input.isKeyPressed(Keys.RIGHT) && soloUnaTeclaPresionada && !colisiones.colisionDerechaObjeto(this)) {
			soloUnaTeclaPresionada = false;
			posicion.x = posicion.x + /*Gdx.graphics.getDeltaTime() */ Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccion = DERECHA;
		}
		else if(Gdx.input.isKeyPressed(Keys.LEFT) && soloUnaTeclaPresionada && !colisiones.colisionIzquierdaObjeto(this)) {
			soloUnaTeclaPresionada = false;
			posicion.x = posicion.x - /*Gdx.graphics.getDeltaTime() */ Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccion = IZQUIERDA;
		}
		else if(Gdx.input.isKeyPressed(Keys.UP) && soloUnaTeclaPresionada && !colisiones.colisionArribaObjeto(this)) {
			soloUnaTeclaPresionada = false;
			posicion.y = posicion.y + /*Gdx.graphics.getDeltaTime() */ Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccion = ARRIBA;
		}
		else if(Gdx.input.isKeyPressed(Keys.DOWN) && soloUnaTeclaPresionada && !colisiones.colisionAbajoObjeto(this)) {
			soloUnaTeclaPresionada = false;
			posicion.y = posicion.y - /*Gdx.graphics.getDeltaTime() */ Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccion = ABAJO;
		}
		else
			manuelSeQuedaQuieto = true;
		
		colisiones.colisionCorazon(this);
		
		// Actualizar bordes
		bordes.x = posicion.x;
		bordes.y = posicion.y;
		
		//Direccion frame Manuel
		if(direccion == ABAJO) {
			if(manuelSeQuedaQuieto)
				frameActual = manuelMatrizFrames[direccion][SPRITE_QUIETO];
			else 
				frameActual = manuelAnimationAbajo.getKeyFrame(stateTime, true);
		}
		else if(direccion == IZQUIERDA) {
			if(manuelSeQuedaQuieto)
				frameActual = manuelMatrizFrames[direccion][SPRITE_QUIETO];
			else 
				frameActual = manuelAnimationIzquierda.getKeyFrame(stateTime, true);
		}
		else if(direccion == DERECHA) {
			if(manuelSeQuedaQuieto)
				frameActual = manuelMatrizFrames[direccion][SPRITE_QUIETO];
			else 
				frameActual = manuelAnimationDerecha.getKeyFrame(stateTime, true);
		}
		else if(direccion == ARRIBA) {
			if(manuelSeQuedaQuieto)
				frameActual = manuelMatrizFrames[direccion][SPRITE_QUIETO];
			else 
				frameActual = manuelAnimationArriba.getKeyFrame(stateTime, true);
		}
	}
	
	// Getters and Setters ------------------------------------------------------------------------
	
	@Override
	public void setColision(Colision colisiones) {
		this.colisiones = colisiones;
	}
	
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
	
	public float getStateTime() {
		return stateTime;
	}
}
