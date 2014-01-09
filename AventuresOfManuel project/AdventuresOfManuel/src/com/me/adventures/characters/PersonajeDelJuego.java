package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.Constant;

public abstract class PersonajeDelJuego implements Entidad {
	protected Vector2 posicion;
	protected Rectangle bordes;
	protected float stateTime;
	protected Colision colisiones;
	protected int direccion;

	//Atributos para pintar
	protected Texture Textura;
	protected TextureRegion frameActual;
	
	public PersonajeDelJuego(Vector2 posicion) {
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		stateTime = 0f;
	}
	
	// Metodos abstractos
	public abstract void activarAtaque();
	
	// Getters and Setters ------------------------------------------------------------------------
	@Override
	public Vector2 getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Vector2 posicion) {
		this.posicion = posicion;
	}
	
	public Colision getColision() {
		return colisiones;
	}
	
	public void setColision(Colision colisiones) {
		this.colisiones = colisiones;
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
	
	public int getDireccion() {
		return direccion;
	}
}
