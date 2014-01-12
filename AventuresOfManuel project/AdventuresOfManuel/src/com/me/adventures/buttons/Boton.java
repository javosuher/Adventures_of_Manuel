package com.me.adventures.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public abstract class Boton {
	protected AdventuresOfManuel adventures;
	protected Vector2 posicion;
	protected Rectangle bordes;
	protected boolean sePuedeVisualizar;
	protected float xMinima;
	protected float yMinima;
	protected float xMaxima;
	protected float yMaxima;

	//Atributos para pintar
	protected Texture Textura;
	
	public Boton(AdventuresOfManuel adventures, Vector2 posicion) {
		this.adventures = adventures;
		this.posicion = posicion;
		this.sePuedeVisualizar = true;
	}
	public Boton(AdventuresOfManuel adventures, Vector2 posicion, boolean sePuedeVisualizar) {
		this.adventures = adventures;
		this.posicion = posicion;
		this.sePuedeVisualizar = sePuedeVisualizar;
	}
	
	protected void asignarBordes() {
		bordes = new Rectangle(posicion.x, posicion.y, Textura.getWidth(), Textura.getHeight());
		
		int altoPantalla = 0;
		if(Gdx.app.getType() == ApplicationType.Desktop)
			altoPantalla = 754;
		else if(Gdx.app.getType() == ApplicationType.Android)
			altoPantalla = Gdx.graphics.getHeight();
		xMinima = posicion.x;
		yMaxima = altoPantalla - posicion.y;
		xMaxima = posicion.x + bordes.width;
		yMinima = altoPantalla - (posicion.y + bordes.height);
	}
	
	public void draw(SpriteBatch batch) {
		batch.draw(Textura, posicion.x, posicion.y, bordes.width, bordes.height);
	}
	
	public void update() {
		if(sePulsaElBoton() && sePuedeVisualizar)
			funcionamiento();
	}
	
	private boolean sePulsaElBoton() {
		return Gdx.input.isTouched() && Gdx.input.getX() >= xMinima && Gdx.input.getX() <= xMaxima 
				&& Gdx.input.getY() >= yMinima && Gdx.input.getY() <= yMaxima;
	}
	
	public void cambiarVisualizacion() {
		if(sePuedeVisualizar)
			sePuedeVisualizar = false;
		else
			sePuedeVisualizar = true;
	}
	
	protected abstract void funcionamiento();
	
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
