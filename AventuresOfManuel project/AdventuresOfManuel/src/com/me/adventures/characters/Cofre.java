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
	private int corazonesNecesarios;
	
	private Vector2 posicion;
	private Rectangle bordes;
	private Texture TexturaCofre;

	private TextureRegion [] cofreVectorFrames;
	private TextureRegion frameActual;
	
	public Cofre(Vector2 posicion, int corazonesNecesarios){
		this.corazonesNecesarios = corazonesNecesarios;
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
		TexturaCofre = new Texture("Miscelanea/Cofre.png");
		TexturaCofre.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		cofreVectorFrames = new TextureRegion[3];
		cofreVectorFrames[0] = new TextureRegion(TexturaCofre, 0, 0, Constant.ANCHURA_OBJETO, Constant.ANCHURA_OBJETO);
		cofreVectorFrames[1] = new TextureRegion(TexturaCofre, Constant.ANCHURA_OBJETO, 0, Constant.ANCHURA_OBJETO, Constant.ANCHURA_OBJETO);
		cofreVectorFrames[2] = new TextureRegion(TexturaCofre, Constant.ANCHURA_OBJETO * 2, 0, Constant.ANCHURA_OBJETO, Constant.ANCHURA_OBJETO);
		frameActual = cofreVectorFrames[CERRADO];
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(frameActual, posicion.x, posicion.y, bordes.height, bordes.width);
	}
	
	@Override
	public void update() {
		
	}
	
	// Getters and Setters ------------------------------------------------------------------------
	
	public int getCorazonesNecesarios(){
		return corazonesNecesarios;
	}
	
	public void abrirCofre(){
		frameActual = cofreVectorFrames[ABIERTO];
	}
	
	public void cogerGema(){
		frameActual = cofreVectorFrames[VACIO];
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
}