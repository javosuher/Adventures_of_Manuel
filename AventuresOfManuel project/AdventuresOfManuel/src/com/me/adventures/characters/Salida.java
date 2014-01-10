package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Salida extends ObjetoDelJuego{
	private int estado;
	private int tipo;

	private TextureRegion frameActual;
	
	public Salida(AdventuresOfManuel adventures, Vector2 posicion, int tipo){
		super(adventures, posicion);
		bordes = new Rectangle(posicion.x, posicion.y, 58, 174);
		this.tipo = tipo;
		estado = 0;
		if(this.tipo == Constant.PUERTA)
			Textura = new Texture("Miscelanea/TablaPuerta.png");
		else
			Textura = new Texture("Miscelanea/TablaPuerta.png"); //--------- CAMBIAR A ESCALERA
		
		frameActual = new TextureRegion(Textura, 0, 0, 174, 58);
	}
	
	public void abrirSalida(){
		estado = 1;
		if(tipo == Constant.PUERTA)
			frameActual = new TextureRegion(Textura, 0, 58, 174, 58);
	}
	
	public boolean salidaAbierta(){
		if(estado == 0) //cerrada
			return false;
		else
			return true;
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		if(tipo == Constant.PUERTA || (tipo == Constant.ESCALERA && estado == 1))
		batch.draw(frameActual, posicion.x, posicion.y, bordes.height, bordes.width);
	}
	
	@Override
	public void update() {
		
	}
	
	// Getters and Setters ------------------------------------------------------------------------

	public int getTipo() {
		return tipo;
	}
}
