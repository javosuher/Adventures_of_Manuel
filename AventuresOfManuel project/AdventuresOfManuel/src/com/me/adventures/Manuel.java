package com.me.adventures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Manuel {
	private Vector2 posicion; //Un vector2 es un vector de 2 elementos
	private float anchura;
	private float altura;
	private Rectangle bordes;
	private float SPEED;
	private float stateTime;
	
	public Manuel(Vector2 posicion, float anchura, float altura) {
		this.posicion = posicion;
		this.anchura = anchura;
		this.altura = altura;
		bordes = new Rectangle(posicion.x, posicion.y, anchura, altura);
		SPEED = 1000;
		stateTime = 0f;
	}	

	public void update() {
		
		if(Gdx.input.isKeyPressed(Keys.D)) {
			posicion.x = posicion.x + Gdx.graphics.getDeltaTime() * SPEED;
			stateTime = (stateTime + Gdx.graphics.getDeltaTime());
		}
		if(Gdx.input.isKeyPressed(Keys.A)) {
			posicion.x = posicion.x - Gdx.graphics.getDeltaTime() * SPEED;
			stateTime = (stateTime + Gdx.graphics.getDeltaTime());
		}
		if(Gdx.input.isKeyPressed(Keys.W)) {
			posicion.y = posicion.y + Gdx.graphics.getDeltaTime() * SPEED;
			stateTime = (stateTime + Gdx.graphics.getDeltaTime());
		}
		if(Gdx.input.isKeyPressed(Keys.S)) {
			posicion.y = posicion.y - Gdx.graphics.getDeltaTime() * SPEED;
			stateTime = (stateTime + Gdx.graphics.getDeltaTime());
		}

		bordes.x = posicion.x;
		bordes.y = posicion.y;
	}

	public Vector2 getPosicion() {
		return posicion;
	}

	public void setPosicion(Vector2 posicion) {
		this.posicion = posicion;
	}

	public float getAnchura() {
		return anchura;
	}

	public void setAnchura(float anchura) {
		this.anchura = anchura;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
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
