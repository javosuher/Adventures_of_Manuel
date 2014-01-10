package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;

public class Corazon extends ObjetoDelJuego
{
	private boolean mostrar = true;
	private int proyectilesOtorga;
	
	public Corazon(AdventuresOfManuel adventures, Vector2 posicion, int proyectilesOtorga)
	{
		super(adventures, posicion);
		this.proyectilesOtorga = proyectilesOtorga;
		Textura = new Texture("Miscelanea/Corazon.png");
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		if(mostrar == true)
			batch.draw(Textura, posicion.x, posicion.y, bordes.height, bordes.width);
	}
	
	@Override
	public void update() {
	}
	
	// Getters and Setters ------------------------------------------------------------------------
	
	public int getProyectilesOtorga(){
		return proyectilesOtorga;
	}
	
	public boolean getEstado(){
		return mostrar;
	}
	
	public void setEstado(){
		mostrar = false;
	}
}