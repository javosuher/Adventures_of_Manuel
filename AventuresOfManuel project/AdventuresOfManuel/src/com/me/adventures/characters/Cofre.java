package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.Constant;

public class Cofre extends ObjetoDelJuego{
	private static final int CERRADO = 0;
	private static final int ABIERTO = 1;
	private static final int VACIO = 2;
	private int estado = 0;
	
	private Vector2 posicion;
	private Rectangle bordes;
	private Texture TexturaCofre;

	private TextureRegion [][] cofreMatrizFrames;
	private TextureRegion frameActual;
	private Animation cofreAnimationAbierto, cofreAnimationCerrado, cofreAnimationVacio;
	
	public Cofre(Vector2 posicion){
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
		TexturaCofre = new Texture("Miscelanea/Cofre.png");
		TexturaCofre.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(TexturaCofre, posicion.x, posicion.y, bordes.height, bordes.width);
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
	
	public int getEstado(){
		return estado;
	}
}