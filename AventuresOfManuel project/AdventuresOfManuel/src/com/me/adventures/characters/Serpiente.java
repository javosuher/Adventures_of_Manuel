package com.me.adventures.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class Serpiente extends PersonajeDelJuegoEnemigo {
	private static final int IZQUIERDA = 0;
    private static final int DERECHA = 1;

	//Atributos para pintar
	private TextureRegion [][] serpienteMatrizFrames;
	
	public Serpiente(AdventuresOfManuel adventures, Vector2 posicion, Manuel manuel) {
		super(adventures, posicion, manuel);
		tiempoParaSiguienteProyectil = 0;
		this.ataqueActivado = false;
		direccion = IZQUIERDA;
		
		Textura = adventures.getManager().get("Enemigos/TablaSerpiente.png", Texture.class);

		serpienteMatrizFrames = new TextureRegion[2][2];
		serpienteMatrizFrames[0][0] = new TextureRegion(Textura, 0, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		serpienteMatrizFrames[0][1] = new TextureRegion(Textura, 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		serpienteMatrizFrames[1][0] = new TextureRegion(Textura, 0, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		serpienteMatrizFrames[1][1] = new TextureRegion(Textura, 58, 58, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		frameActual = serpienteMatrizFrames[IZQUIERDA][1]; // Necesario
	}
	
	public void activarAtaque() {
		ataqueActivado = true; // este enemigo no ataca a manuel
	}
	
	public void update() {
		super.update();
		if(ataqueActivado == false){
			if(manuel.getBordes().x == posicion.x)
				if(direccion == IZQUIERDA)
					frameActual = serpienteMatrizFrames[direccion][0];
				else
					frameActual = serpienteMatrizFrames[direccion][1];
			else if(manuel.getBordes().x < posicion.x) {
				direccion = IZQUIERDA;
				frameActual = serpienteMatrizFrames[direccion][1];
			}
			else if(manuel.getBordes().x > posicion.x) {
				direccion = DERECHA;
				frameActual = serpienteMatrizFrames[direccion][0];   
			}
		}
		else{
			if(tiempoParaSiguienteProyectil == 0){
				if(direccion == IZQUIERDA){
					direccion = DERECHA;
					frameActual = serpienteMatrizFrames[direccion][0];
				}
				else{
					direccion = IZQUIERDA;
					frameActual = serpienteMatrizFrames[direccion][1];
				}
				tiempoParaSiguienteProyectil = Constant.TIEMPO_PROYECTIL;
			}
			else
				tiempoDesaparecido--;
		}
	}
	
	// Getters and Setters ------------------------------------------------------------------------
	
}
