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

public class Manuel {
	// Constantes
	private static final float SPEED = 100;
    private static final int ANCHURA = 58;
    private static final int ALTURA = 58;
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
	
	//Atributos para pintar a Manuel
	private Texture TexturaManuel;
	private TextureRegion [][] manuelMatrizFrames;
	private TextureRegion frameActual;
	private Animation manuelAnimationAbajo, manuelAnimationIzquierda, manuelAnimationDerecha, manuelAnimationArriba;
	
	public Manuel(Vector2 posicion) {
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, ANCHURA, ALTURA);
		stateTime = 0f;
		direccion = ABAJO;
		
		TexturaManuel = new Texture("Manolito/TablaSpritesManolitoTransparencia.png");
		TexturaManuel.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		manuelMatrizFrames = TextureRegion.split(TexturaManuel, ANCHURA, ALTURA);
		
		// Asignamos las animaciones de las direcciones de Manuel
		manuelAnimationAbajo = new Animation(0.05f, manuelMatrizFrames[ABAJO]);
		manuelAnimationIzquierda = new Animation(0.05f, manuelMatrizFrames[IZQUIERDA]);
		manuelAnimationDerecha= new Animation(0.05f, manuelMatrizFrames[DERECHA]);
		manuelAnimationArriba = new Animation(0.05f, manuelMatrizFrames[ARRIBA]);
	}
	
	public void draw(SpriteBatch batch) {
		batch.draw(frameActual, posicion.x, posicion.y, ANCHURA, ALTURA);
	}

	public void update() {
		// Determina movimiento de Manuel
		boolean soloUnaTeclaPresionada = true;
		boolean manuelSeQuedaQuieto = false;
		if(Gdx.input.isKeyPressed(Keys.RIGHT) && soloUnaTeclaPresionada) {
			soloUnaTeclaPresionada = false;
			posicion.x = posicion.x + Gdx.graphics.getDeltaTime() * SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccion = DERECHA;
		}
		else if(Gdx.input.isKeyPressed(Keys.LEFT) && soloUnaTeclaPresionada) {
			soloUnaTeclaPresionada = false;
			posicion.x = posicion.x - Gdx.graphics.getDeltaTime() * SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccion = IZQUIERDA;
		}
		else if(Gdx.input.isKeyPressed(Keys.UP) && soloUnaTeclaPresionada) {
			soloUnaTeclaPresionada = false;
			posicion.y = posicion.y + Gdx.graphics.getDeltaTime() * SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccion = ARRIBA;
		}
		else if(Gdx.input.isKeyPressed(Keys.DOWN) && soloUnaTeclaPresionada) {
			soloUnaTeclaPresionada = false;
			posicion.y = posicion.y - Gdx.graphics.getDeltaTime() * SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccion = ABAJO;
		}
		else
			manuelSeQuedaQuieto = true;
		
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

	public Vector2 getPosicion() {
		return posicion;
	}

	public void setPosicion(Vector2 posicion) {
		this.posicion = posicion;
	}
	
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
