package com.me.adventures.screens;

import com.badlogic.gdx.math.Vector2;
import com.me.adventures.characters.*;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;


public class Nivel5 extends Nivel {
	public Nivel5(AdventuresOfManuel adventures, Vector2 posicionManuel) {
		super(adventures, posicionManuel);
	}
	
	@Override
	protected void mapaDelNivel() {
	}
	
	@Override
	protected void objetosDelNivel() {
		//Se introducen las paredes del nivel
		objetos.add(new Pared(adventures, new Vector2(0, 0), 1024, 58));
		objetos.add(new Pared(adventures, new Vector2(135, 0), 58, 754));
		objetos.add(new Pared(adventures, new Vector2(0, 696), 1024, 58));
		salida = new Salida(adventures, new Vector2(483, 116), Constant.ESCALERA);
		objetos.add(new Pared(adventures, new Vector2(831, 0), 58, 754));
		
		//Se introducen los demas objetos por fila
		objetos.add(new Roca(adventures, new Vector2(193, 638)));
		objetos.add(new Roca(adventures, new Vector2(251, 638)));
		objetos.add(new Roca(adventures, new Vector2(309, 638)));
		objetos.add(new Roca(adventures, new Vector2(367, 638)));
		objetos.add(new Bloque(adventures, new Vector2(599, 638)));
		objetos.add(new Roca(adventures, new Vector2(773, 638)));

		objetos.add(new Roca(adventures, new Vector2(193, 580)));
		corazones.add(new Corazon(adventures, new Vector2(251, 580), 0));
		objetos.add(new Bloque(adventures, new Vector2(367, 580)));
		objetos.add(new Roca(adventures, new Vector2(599, 580)));
		corazones.add(new Corazon(adventures, new Vector2(657, 580), 0));
		objetos.add(new Roca(adventures, new Vector2(715, 580)));
		objetos.add(new Roca(adventures, new Vector2(773, 580)));

		objetos.add(new Roca(adventures, new Vector2(193, 522)));
		objetos.add(new Roca(adventures, new Vector2(251, 522)));
		objetos.add(new Roca(adventures, new Vector2(367, 522)));
		objetos.add(new Roca(adventures, new Vector2(599, 522)));
		objetos.add(new Roca(adventures, new Vector2(657, 522)));
		objetos.add(new Roca(adventures, new Vector2(715, 522)));
		objetos.add(new Roca(adventures, new Vector2(773, 522)));

		objetos.add(new Roca(adventures, new Vector2(657, 464)));
		objetos.add(new Roca(adventures, new Vector2(715, 464)));
		objetos.add(new Roca(adventures, new Vector2(773, 464)));
		
		cofre = new Cofre(adventures, new Vector2(483, 348), 4);

		objetos.add(new Roca(adventures, new Vector2(193, 232)));
		objetos.add(new Bloque(adventures, new Vector2(251, 232)));
		objetos.add(new Roca(adventures, new Vector2(309, 232)));

		objetos.add(new Roca(adventures, new Vector2(193, 174)));
		objetos.add(new Roca(adventures, new Vector2(309, 174)));
		objetos.add(new Roca(adventures, new Vector2(367, 174)));
		objetos.add(new Roca(adventures, new Vector2(599, 174)));
		objetos.add(new Roca(adventures, new Vector2(657, 174)));
		objetos.add(new Bloque(adventures, new Vector2(715, 174)));
		objetos.add(new Roca(adventures, new Vector2(773, 174)));

		objetos.add(new Bloque(adventures, new Vector2(367, 116)));
		objetos.add(new Roca(adventures, new Vector2(599, 116)));
		corazones.add(new Corazon(adventures, new Vector2(657, 116), 0));
		objetos.add(new Roca(adventures, new Vector2(773, 116)));

		objetos.add(new Roca(adventures, new Vector2(193, 58)));
		corazones.add(new Corazon(adventures, new Vector2(251, 58), 0));
		objetos.add(new Roca(adventures, new Vector2(309, 58)));
		objetos.add(new Roca(adventures, new Vector2(367, 58)));
		objetos.add(new Roca(adventures, new Vector2(599, 58)));
		objetos.add(new Roca(adventures, new Vector2(657, 58)));
		objetos.add(new Roca(adventures, new Vector2(773, 58)));
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes.add(new Serpiente(adventures, new Vector2(367, 348), manuel));//Fantasma
		personajes.add(new Serpiente(adventures, new Vector2(599, 348), manuel));//Fantasma
	}
}