package com.me.adventures.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.screens.AbstractScreen;

public abstract class Boton {
	protected AdventuresOfManuel adventures;
	protected Vector2 posicion;
	protected Rectangle bordes;

	//Atributos para pintar
	protected Texture Textura;
	
	public Boton(AdventuresOfManuel adventures, Vector2 posicion) {
		this.adventures = adventures;
		this.posicion = posicion;
	}
	
	protected void asignarBordes() {
		bordes = new Rectangle(posicion.x, posicion.y, Textura.getWidth(), Textura.getHeight());
	}
	
	public void draw(SpriteBatch batch) {
		batch.draw(Textura, posicion.x, posicion.y, bordes.width, bordes.height);
	}
	
	public void update() {
		// Si se toca el botón.
		if(Gdx.input.isTouched() && Gdx.input.getX() >= posicion.x && Gdx.input.getX() <= posicion.x + bordes.width && Gdx.input.getY() >= posicion.y && Gdx.input.getY() <= posicion.y + bordes.height)
			adventures.setScreen(pantallaSiguiente());
	}
	
	protected abstract AbstractScreen pantallaSiguiente();
	
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
}
