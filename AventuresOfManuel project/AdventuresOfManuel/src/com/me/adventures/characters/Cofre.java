package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Cofre extends ObjetoDelJuego{
	private static final int CERRADO = 0;
	private static final int ABIERTO = 1;
	private static final int VACIO = 2;
	private int corazonesNecesarios;

	private TextureRegion [] cofreVectorFrames;
	private TextureRegion frameActual;
	
	public Cofre(AdventuresOfManuel adventures, Vector2 posicion, int corazonesNecesarios){
		super(adventures, posicion);
		this.corazonesNecesarios = corazonesNecesarios;
		Textura = adventures.getManager().get("Miscelanea/Cofre.png", Texture.class);
		
		cofreVectorFrames = new TextureRegion[3];
		cofreVectorFrames[0] = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
		cofreVectorFrames[1] = new TextureRegion(Textura, Constant.ANCHURA_OBJETO, 0, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
		cofreVectorFrames[2] = new TextureRegion(Textura, Constant.ANCHURA_OBJETO * 2, 0, Constant.ANCHURA_OBJETO, Constant.ALTURA_OBJETO);
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
}