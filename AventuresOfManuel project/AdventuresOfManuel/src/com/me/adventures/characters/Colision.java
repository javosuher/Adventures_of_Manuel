package com.me.adventures.characters;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.me.adventures.main.Constant;

public class Colision {
	private Manuel manuel;
	private List<PersonajeDelJuego> personajes;
	private List<ObjetoDelJuego> objetos;
	
	
	public Colision(Manuel manuel, List<PersonajeDelJuego> personajes, List<ObjetoDelJuego> objetos) {
		this.manuel = manuel;
		this.personajes = personajes;
		this.objetos = objetos;
	}
	
	private boolean colisiona(Rectangle a, Rectangle b) {
		return a.overlaps(b);
	}
	
	private boolean colisionObjeto(Rectangle auxiliar) {
		boolean ningunaColision = true;
		for(int i = 0; i < objetos.size() && ningunaColision; i++) {
			if(colisiona(auxiliar, objetos.get(i).getBordes())){
				ningunaColision = false;
			}
		}
		return !ningunaColision;
	}
	
	public boolean colisionDerechaObjeto(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.x = auxiliar.x + (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionObjeto(auxiliar);
	}
	public boolean colisionIzquierdaObjeto(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.x = auxiliar.x - (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionObjeto(auxiliar);
	}
	public boolean colisionArribaObjeto(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.y = auxiliar.y + (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionObjeto(auxiliar);
	}
	public boolean colisionAbajoObjeto(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.y = auxiliar.y - (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionObjeto(auxiliar);
	}
}
