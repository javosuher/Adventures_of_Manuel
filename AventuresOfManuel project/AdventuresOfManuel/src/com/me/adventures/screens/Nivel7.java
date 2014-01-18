package com.me.adventures.screens;

import com.badlogic.gdx.math.Vector2;
import com.me.adventures.characters.Arbol;
import com.me.adventures.characters.Bloque;
import com.me.adventures.characters.Cofre;
import com.me.adventures.characters.Corazon;
import com.me.adventures.characters.Leeper;
import com.me.adventures.characters.Pared;
import com.me.adventures.characters.Roca;
import com.me.adventures.characters.Salida;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Nivel7 extends Nivel{
	public Nivel7(AdventuresOfManuel adventures, Vector2 posicionManuel) {
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
		objetos.add(new Pared(adventures, new Vector2(135, 696), 348, 58));
		objetos.add(new Pared(adventures, new Vector2(483, 725), 58, 29));
		
		objetos.add(new Pared(adventures, new Vector2(483, 696), 58, 29));//
		salida = new Salida(adventures, new Vector2(425, 696), Constant.PUERTA, objetos.size()-1);
		objetos.add(new Pared(adventures, new Vector2(541, 696), 290, 58));
		objetos.add(new Pared(adventures, new Vector2(831, 0), 58, 754));
		
		//Se introducen los demas objetos por fila
		cofre = new Cofre(adventures, new Vector2(193, 638), 9);
		
		objetos.add(new Arbol(adventures, new Vector2(251, 580)));
		objetos.add(new Arbol(adventures, new Vector2(483, 580)));
		objetos.add(new Roca(adventures, new Vector2(541, 580)));
		objetos.add(new Roca(adventures, new Vector2(599, 580)));
		objetos.add(new Roca(adventures, new Vector2(657, 580)));

		corazones.add(new Corazon(adventures, new Vector2(309, 522), 0));
		objetos.add(new Roca(adventures, new Vector2(367, 522)));
		objetos.add(new Roca(adventures, new Vector2(483, 522)));
		corazones.add(new Corazon(adventures, new Vector2(657, 522), 0));

		objetos.add(new Roca(adventures, new Vector2(309, 464)));
		objetos.add(new Roca(adventures, new Vector2(367, 464)));
		objetos.add(new Arbol(adventures, new Vector2(483, 464)));
		corazones.add(new Corazon(adventures, new Vector2(541, 464), 0));
		objetos.add(new Roca(adventures, new Vector2(599, 464)));
		objetos.add(new Roca(adventures, new Vector2(657, 464)));
		objetos.add(new Roca(adventures, new Vector2(715, 464)));

		objetos.add(new Roca(adventures, new Vector2(541, 406)));
		objetos.add(new Roca(adventures, new Vector2(599, 406)));

		objetos.add(new Arbol(adventures, new Vector2(251, 348)));
		objetos.add(new Roca(adventures, new Vector2(309, 348)));
		objetos.add(new Arbol(adventures, new Vector2(367, 348)));
		objetos.add(new Arbol(adventures, new Vector2(483, 348)));
		objetos.add(new Roca(adventures, new Vector2(541, 348)));
		corazones.add(new Corazon(adventures, new Vector2(599, 348), 0));
		
		objetos.add(new Roca(adventures, new Vector2(251, 290)));
		corazones.add(new Corazon(adventures, new Vector2(367, 290), 0));
		objetos.add(new Roca(adventures, new Vector2(425, 290)));
		objetos.add(new Roca(adventures, new Vector2(483, 290)));
		objetos.add(new Roca(adventures, new Vector2(541, 290)));
		objetos.add(new Roca(adventures, new Vector2(599, 290)));
		objetos.add(new Roca(adventures, new Vector2(657, 290)));
		objetos.add(new Roca(adventures, new Vector2(715, 290)));

		objetos.add(new Roca(adventures, new Vector2(251, 232)));
		objetos.add(new Roca(adventures, new Vector2(367, 232)));
		objetos.add(new Roca(adventures, new Vector2(425, 232)));
		corazones.add(new Corazon(adventures, new Vector2(483, 232), 0));
		objetos.add(new Roca(adventures, new Vector2(541, 232)));
		objetos.add(new Arbol(adventures, new Vector2(599, 232)));
		corazones.add(new Corazon(adventures, new Vector2(715, 232), 2));

		objetos.add(new Roca(adventures, new Vector2(251, 174)));
		corazones.add(new Corazon(adventures, new Vector2(309, 174), 0));
		objetos.add(new Roca(adventures, new Vector2(367, 174)));
		objetos.add(new Roca(adventures, new Vector2(541, 174)));
		objetos.add(new Arbol(adventures, new Vector2(657, 174)));
		objetos.add(new Arbol(adventures, new Vector2(715, 174)));
		
		objetos.add(new Roca(adventures, new Vector2(367, 116)));
		objetos.add(new Roca(adventures, new Vector2(541, 116)));
		corazones.add(new Corazon(adventures, new Vector2(599, 116), 0));
		objetos.add(new Arbol(adventures, new Vector2(657, 116)));
		objetos.add(new Arbol(adventures, new Vector2(715, 116)));
		
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes.add(new Leeper(adventures, new Vector2(193, 464), manuel, 2));
		personajes.add(new Leeper(adventures, new Vector2(367, 638), manuel, 0));
		
		personajesMovibles.add(new Bloque(adventures, new Vector2(715, 580), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(251, 116), manuel));
	}
}
