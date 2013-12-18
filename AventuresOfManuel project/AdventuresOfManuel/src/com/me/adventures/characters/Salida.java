package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Salida extends ObjetoDelJuego{
	private int estado;
	private String tipo;
	
	private Vector2 posicion;
	private Rectangle bordes;
	private Texture TexturaSalida;

	private TextureRegion frameActual;
	
	public Salida(Vector2 posicion, String tipo){
		this.tipo = tipo;
		estado = 0;
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, 58, 174);
		if(this.tipo == "PUERTA")
			TexturaSalida = new Texture("Miscelanea/TablaPuerta.png");
		else
			TexturaSalida = new Texture("Miscelanea/TablaPuerta.png"); //--------- CAMBIAR A ESCALERA
		TexturaSalida.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		frameActual = new TextureRegion(TexturaSalida, 0, 0, 174, 58);
	}
	
	public void abrirSalida(){
		estado = 1;
		frameActual = new TextureRegion(TexturaSalida, 0, 58, 174, 58);
	}
	
	public boolean salidaAbierta(){
		if(estado == 0)
			return false;
		else
			return true;
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(frameActual, posicion.x, posicion.y, bordes.height, bordes.width);
	}
	
	@Override
	public void update() {
		
	}
	
	// Getters and Setters ------------------------------------------------------------------------
	
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

	public String getTipo() {
		return tipo;
	}
}
