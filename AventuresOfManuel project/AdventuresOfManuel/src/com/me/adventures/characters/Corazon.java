package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.Constant;

public class Corazon extends ObjetoDelJuego
{
	private Vector2 posicion;
	private Rectangle bordes;
	private Texture TexturaCorazon;
	private boolean mostrar = true;
	
	public Corazon(Vector2 posicion)
	{
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
		TexturaCorazon = new Texture("Miscelanea/Corazon.png");
		TexturaCorazon.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		if(mostrar == true)
			batch.draw(TexturaCorazon, posicion.x, posicion.y, bordes.height, bordes.width);
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
	
	public boolean getEstado(){
		return mostrar;
	}
	
	public void setEstado(){
		mostrar = false;
	}
}