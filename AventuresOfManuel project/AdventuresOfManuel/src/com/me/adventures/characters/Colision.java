package com.me.adventures.characters;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.me.adventures.main.Constant;

public class Colision {
	private Manuel manuel;
	private List<PersonajeDelJuegoEnemigo> personajes;
	private List<ObjetoDelJuego> objetos;
	private List<Corazon> corazones;
	private List<PersonajeDelJuegoEnemigo> personajesMovibles;
	private Cofre cofre;
	private Salida salida;
	
	public Colision(Manuel manuel, List<PersonajeDelJuegoEnemigo> personajes, List<ObjetoDelJuego> objetos, List<PersonajeDelJuegoEnemigo> personajesMovibles, List<Corazon> corazones, Cofre cofre, Salida salida) {
		this.manuel = manuel;
		this.personajes = personajes;
		this.objetos = objetos;
		this.personajesMovibles = personajesMovibles;
		this.corazones = corazones;
		this.cofre = cofre;
		this.salida = salida;
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
		if(salida.salidaAbierta() == true && comprobarSalida())
			return false;
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.x = auxiliar.x + (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionObjeto(auxiliar);
	}
	public boolean colisionIzquierdaObjeto(PersonajeDelJuego personaje) {
		if(salida.salidaAbierta() == true && comprobarSalida())
			return false;
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.x = auxiliar.x - (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionObjeto(auxiliar);
	}
	public boolean colisionArribaObjeto(PersonajeDelJuego personaje) {
		if(salida.salidaAbierta() == true && comprobarSalida())
			return false;
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.y = auxiliar.y + (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionObjeto(auxiliar);
	}
	public boolean colisionAbajoObjeto(PersonajeDelJuego personaje) {
		if(salida.salidaAbierta() == true && comprobarSalida())
			return false;
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.y = auxiliar.y - (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionObjeto(auxiliar);
	}
	
	private boolean comprobarSalida(){
		if(salida.getTipo() == Constant.PUERTA){
			if((salida.getBordes().x + 58)  == manuel.getBordes().x && salida.getBordes().y == (manuel.getBordes().y + Constant.ALTURA_PERSONAJE))
				return true;
			else
				return false;
		}
		return comprobarCoordenada(salida, manuel);
	}
	
	public boolean colisionCorazon(PersonajeDelJuego personaje) {
		boolean colisiones = false;
		for(int i = 0; i < corazones.size() && !colisiones; i++){
			Corazon c = corazones.get(i);
			if(c.getEstado() == true){ //el coraz�n no se ha cogido
				colisiones = comprobarCoordenada(c, personaje);
				if(colisiones == true){
					c.setEstado();
					manuel.obtenerCorazon();
					manuel.obtenerProyectil(c.getProyectilesOtorga());
					if(cofre.getCorazonesNecesarios() == manuel.getCorazonesObtenidos())
						cofre.abrirCofre();
				}
			}
		}
		return colisiones;
	}
	
	private boolean comprobarCoordenada(ObjetoDelJuego objeto, PersonajeDelJuego personaje){
		if(personaje.getBordes().x == objeto.getBordes().x && personaje.getBordes().y == objeto.getBordes().y)
			return true;
		return false;
	}
	
	public void colisionCofre(PersonajeDelJuego personaje){
		if(cofre.getCorazonesNecesarios() == manuel.getCorazonesObtenidos() && comprobarCoordenada(cofre, personaje) == true){
			cofre.cogerGema();
			salida.abrirSalida();
		}
	}
	//-----------------------------
	private boolean colisionEnemigo(Rectangle auxiliar) {
		boolean ningunaColision = true;
		for(int i = 0; i < personajes.size() && ningunaColision; i++) {
			if(colisiona(auxiliar, personajes.get(i).getBordes())){
				if(personajes.get(i).estaEnBola()) {
					personajesMovibles.add(personajes.get(i));
					personajes.remove(i);
				}
				else
					ningunaColision = false;
			}
		}
		return !ningunaColision;
	}
	
	public boolean colisionDerechaEnemigo(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.x = auxiliar.x + (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionEnemigo(auxiliar);
	}
	public boolean colisionIzquierdaEnemigo(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.x = auxiliar.x - (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionEnemigo(auxiliar);
	}
	public boolean colisionArribaEnemigo(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.y = auxiliar.y + (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionEnemigo(auxiliar);
	}
	public boolean colisionAbajoEnemigo(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.y = auxiliar.y - (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionEnemigo(auxiliar);
	}
	//----------------------------
	
	public boolean colisionObjetoEnemigoMovible(PersonajeDelJuego personaje) {
		return colisionObjeto(personaje.getBordes()) || colisionEnemigo(personaje.getBordes()) || colisionEnemigoMovible(personaje.getBordes());
	}
	
	private boolean colisionObjetoEnemigo(Rectangle auxiliar) {
		return colisionObjeto(auxiliar) /*|| colisionEnemigo(auxiliar)*/;
	}
	public boolean colisionObjetoEnemigoArriba(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.y = auxiliar.y + (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionObjetoEnemigo(auxiliar);
	}
	public boolean colisionObjetoEnemigoAbajo(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.y = auxiliar.y - (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionObjetoEnemigo(auxiliar);
	}
	public boolean colisionObjetoEnemigoDerecha(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.x = auxiliar.x + (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionObjetoEnemigo(auxiliar);
	}
	public boolean colisionObjetoEnemigoIzquierda(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.x = auxiliar.x - (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionObjetoEnemigo(auxiliar);
	}
	
	public boolean colisionDisparoObjeto(Proyectil disparo) {
		return colisionObjeto(disparo.getBordes());
	}
	public boolean colisionDisparoEnemigo(Proyectil disparo) {
		boolean ningunaColision = true;
		for(int i = 0; i < personajes.size() && ningunaColision; i++) {
			if(colisiona(disparo.getBordes(), personajes.get(i).getBordes())) {
				personajes.get(i).convertirEnBola();
				ponerEnHuevo(i);
				ningunaColision = false;
			}
		}
		for(int i = 0; i < personajesMovibles.size() && ningunaColision; i++) {
			if(colisiona(disparo.getBordes(), personajesMovibles.get(i).getBordes()) && personajesMovibles.get(i).estaEnBola()) {
				personajesMovibles.get(i).desaparecer();
				finHuevo(personajesMovibles.get(i));
				ningunaColision = false;
			}
		}
		return !ningunaColision;
	}

	public boolean colisionManuelConHuevo(PersonajeDelJuego personaje) {
		return colisiona(personaje.getBordes(), manuel.getBordes());
	}
	
	public boolean colisionEnemigoMovible(PersonajeDelJuego personaje) {
		boolean ningunaColision = true;
		for(int i = 0; i < personajesMovibles.size() && ningunaColision; i++) {
			if(colisiona(personaje.getBordes(), personajesMovibles.get(i).getBordes())){
				ningunaColision = false;
			}
		}
		return !ningunaColision;
	}
	public boolean colisionEnemigoMovible(Rectangle auxiliar) {
		boolean ningunaColision = true;
		for(int i = 0; i < personajesMovibles.size() && ningunaColision; i++) {
			if(colisiona(auxiliar, personajesMovibles.get(i).getBordes())){
				ningunaColision = false;
			}
		}
		return !ningunaColision;
	}
	
	public void finHuevo(PersonajeDelJuego personaje) {
		int i = personajesMovibles.indexOf(personaje);
		personajes.add(personajesMovibles.get(i));
		personajesMovibles.remove(i);
	}
	private void ponerEnHuevo(int i) {
		personajesMovibles.add(personajes.get(i));
		personajes.remove(i);
	}
	
	public boolean colisionMovible(Rectangle auxiliar) {
		boolean ningunaColision = true;
		for(int i = 0; i < personajesMovibles.size() && ningunaColision; i++) {
			if(colisiona(auxiliar, personajesMovibles.get(i).getBordes())){
				ningunaColision = false;
			}
		}
		return !ningunaColision;
	}
	
	public boolean colisionMovibleArriba(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.y = auxiliar.y + (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionMovible(auxiliar);
	}
	public boolean colisionMovibleAbajo(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.y = auxiliar.y - (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionMovible(auxiliar);
	}
	public boolean colisionMovibleDerecha(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.x = auxiliar.x + (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionMovible(auxiliar);
	}
	public boolean colisionMovibleIzquierda(PersonajeDelJuego personaje) {
		Rectangle auxiliar = new Rectangle(personaje.getBordes().x, personaje.getBordes().y, personaje.getBordes().width, personaje.getBordes().height);
		auxiliar.x = auxiliar.x - (Gdx.graphics.getDeltaTime() * Constant.SPEED);
		return colisionMovible(auxiliar);
	}
}
