package com.me.adventures.characters;

public abstract class PersonajeDelJuego implements Entidad {
	public abstract void setColision(Colision colisiones);
	public abstract void activarAtaque();
	public abstract void convertirEnBola();
	public abstract boolean estaEnBola();
	public abstract void moverEnBola();
}
