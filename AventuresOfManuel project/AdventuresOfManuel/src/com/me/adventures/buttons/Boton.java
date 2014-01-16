package com.me.adventures.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;
import com.me.adventures.screens.MainScreen;

public abstract class Boton {
	protected AdventuresOfManuel adventures;
	protected Vector2 posicion;
	protected MainScreen mainScreen;
	protected Rectangle bordes;
	protected float xMinima;
	protected float yMinima;
	protected float xMaxima;
	protected float yMaxima;
	protected int tiempoPulsacion;
	protected Sound sonidoBoton;

	//Atributos para pintar
	protected Texture Textura;
	
	public Boton(AdventuresOfManuel adventures, Vector2 posicion) {
		this.adventures = adventures;
		this.posicion = posicion;
		tiempoPulsacion = 0;
		sonidoBoton = adventures.getManager().get("Musica/Button.mp3", Sound.class);
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
		if(sePulsaElBoton() && tiempoPulsacion == 0) {
			if(adventures.isSonidoActivado())
				sonidoBoton.play();
			funcionamiento();
			tiempoPulsacion = Constant.TIEMPO_BOTON;
		}
		else if(tiempoPulsacion > 0)
			tiempoPulsacion--;
	}
	
	private boolean sePulsaElBoton() {
		return Gdx.input.isTouched() && Gdx.input.getX() >= xMinima && Gdx.input.getX() <= xMaxima 
				&& Gdx.input.getY() >= yMinima && Gdx.input.getY() <= yMaxima;
	}
	
	public void setMainScreen(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
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
