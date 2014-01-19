package com.me.adventures.screens;

import com.badlogic.gdx.math.Vector2;
import com.me.adventures.characters.Bloque;
import com.me.adventures.characters.Calavera;
import com.me.adventures.characters.Cofre;
import com.me.adventures.characters.Corazon;
import com.me.adventures.characters.Pared;
import com.me.adventures.characters.Roca;
import com.me.adventures.characters.Salida;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Nivel8 extends Nivel{
	public Nivel8(AdventuresOfManuel adventures, Vector2 posicionManuel) {
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
		objetos.add(new Pared(adventures, new Vector2(135, 696), 580, 58));
		objetos.add(new Pared(adventures, new Vector2(715, 725), 58, 29));
		
		objetos.add(new Pared(adventures, new Vector2(715, 696), 58, 29));//
		salida = new Salida(adventures, new Vector2(657,696), Constant.PUERTA, objetos.size()-1);
		objetos.add(new Pared(adventures, new Vector2(773, 696), 58, 58));
		objetos.add(new Pared(adventures, new Vector2(831, 0), 58, 754));
		
		//Se introducen los demas objetos por fila
		corazones.add(new Corazon(adventures, new Vector2(309, 638), 0));
		corazones.add(new Corazon(adventures, new Vector2(541, 638), 0));
		objetos.add(new Roca(adventures, new Vector2(599, 638)));
		objetos.add(new Roca(adventures, new Vector2(657, 638)));

		objetos.add(new Roca(adventures, new Vector2(251, 580)));
		objetos.add(new Roca(adventures, new Vector2(367, 580)));
		objetos.add(new Roca(adventures, new Vector2(425, 580)));
		objetos.add(new Roca(adventures, new Vector2(483, 580)));
		objetos.add(new Roca(adventures, new Vector2(599, 580)));

		objetos.add(new Roca(adventures, new Vector2(251, 522)));
		objetos.add(new Roca(adventures, new Vector2(367, 522)));
		objetos.add(new Roca(adventures, new Vector2(483, 522)));
		objetos.add(new Roca(adventures, new Vector2(715, 522)));
		
		objetos.add(new Roca(adventures, new Vector2(251, 464)));
		objetos.add(new Roca(adventures, new Vector2(367, 464)));
		objetos.add(new Roca(adventures, new Vector2(483, 464)));
		objetos.add(new Roca(adventures, new Vector2(599, 464)));
		objetos.add(new Roca(adventures, new Vector2(715, 464)));
		
		objetos.add(new Roca(adventures, new Vector2(251, 406)));
		objetos.add(new Roca(adventures, new Vector2(367, 406)));
		objetos.add(new Roca(adventures, new Vector2(483, 406)));
		objetos.add(new Roca(adventures, new Vector2(599, 406)));
		objetos.add(new Roca(adventures, new Vector2(715, 406)));
		
		objetos.add(new Roca(adventures, new Vector2(251, 348)));
		objetos.add(new Roca(adventures, new Vector2(367, 348)));
		objetos.add(new Roca(adventures, new Vector2(483, 348)));
		
		objetos.add(new Roca(adventures, new Vector2(251, 290)));
		objetos.add(new Roca(adventures, new Vector2(367, 290)));
		corazones.add(new Corazon(adventures, new Vector2(425, 290), 0));
		objetos.add(new Roca(adventures, new Vector2(599, 290)));
		objetos.add(new Roca(adventures, new Vector2(715, 290)));
		
		objetos.add(new Roca(adventures, new Vector2(251, 232)));
		objetos.add(new Roca(adventures, new Vector2(367, 232)));
		objetos.add(new Roca(adventures, new Vector2(483, 232)));
		objetos.add(new Roca(adventures, new Vector2(599, 232)));
		objetos.add(new Roca(adventures, new Vector2(715, 232)));
		
		objetos.add(new Roca(adventures, new Vector2(251, 174)));
		objetos.add(new Roca(adventures, new Vector2(367, 174)));
		objetos.add(new Roca(adventures, new Vector2(483, 174)));
		objetos.add(new Roca(adventures, new Vector2(599, 174)));
		cofre = new Cofre(adventures, new Vector2(657, 174), 5);
		objetos.add(new Roca(adventures, new Vector2(715, 174)));

		corazones.add(new Corazon(adventures, new Vector2(309, 116), 0));
		objetos.add(new Roca(adventures, new Vector2(483, 116)));
		objetos.add(new Roca(adventures, new Vector2(599, 116)));
		objetos.add(new Roca(adventures, new Vector2(657, 116)));
		
		corazones.add(new Corazon(adventures, new Vector2(541, 58), 0));
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes.add(new Calavera(adventures, new Vector2(425, 348), manuel));
		personajes.add(new Calavera(adventures, new Vector2(541, 348), manuel));
		
		personajesMovibles.add(new Bloque(adventures, new Vector2(715, 580), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(599, 522), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(657, 348), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(483, 290), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(309, 174), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(309, 58), manuel));
	}
}
