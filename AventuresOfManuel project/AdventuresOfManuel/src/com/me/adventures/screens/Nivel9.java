package com.me.adventures.screens;

import com.badlogic.gdx.math.Vector2;
import com.me.adventures.characters.Arbol;
import com.me.adventures.characters.Bloque;
import com.me.adventures.characters.Cofre;
import com.me.adventures.characters.Corazon;
import com.me.adventures.characters.Dragon;
import com.me.adventures.characters.Pared;
import com.me.adventures.characters.Roca;
import com.me.adventures.characters.Salida;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Nivel9 extends Nivel{
	public Nivel9(AdventuresOfManuel adventures, Vector2 posicionManuel) {
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
		corazones.add(new Corazon(adventures, new Vector2(425, 638), 0));
		corazones.add(new Corazon(adventures, new Vector2(541, 638), 0));

		objetos.add(new Arbol(adventures, new Vector2(367, 580)));
		objetos.add(new Arbol(adventures, new Vector2(425, 580)));
		objetos.add(new Arbol(adventures, new Vector2(541, 580)));
		objetos.add(new Arbol(adventures, new Vector2(599, 580)));

		objetos.add(new Roca(adventures, new Vector2(251, 522)));
		objetos.add(new Roca(adventures, new Vector2(715, 522)));
		
		corazones.add(new Corazon(adventures, new Vector2(483, 464), 0));
		
		objetos.add(new Arbol(adventures, new Vector2(193, 406)));
		objetos.add(new Arbol(adventures, new Vector2(367, 406)));
		objetos.add(new Arbol(adventures, new Vector2(599, 406)));
		objetos.add(new Arbol(adventures, new Vector2(773, 406)));
		
		corazones.add(new Corazon(adventures, new Vector2(193, 348), 0));
		cofre = new Cofre(adventures, new Vector2(483, 348), 8);
		corazones.add(new Corazon(adventures, new Vector2(657, 348), 0));
		corazones.add(new Corazon(adventures, new Vector2(773, 348), 0));
		
		objetos.add(new Arbol(adventures, new Vector2(193, 290)));
		objetos.add(new Arbol(adventures, new Vector2(367, 290)));
		objetos.add(new Arbol(adventures, new Vector2(599, 290)));
		objetos.add(new Arbol(adventures, new Vector2(773, 290)));
		
		objetos.add(new Arbol(adventures, new Vector2(367, 232)));
		objetos.add(new Arbol(adventures, new Vector2(599, 232)));
		
		objetos.add(new Arbol(adventures, new Vector2(193, 174)));
		corazones.add(new Corazon(adventures, new Vector2(367, 174), 0));
		corazones.add(new Corazon(adventures, new Vector2(599, 174), 0));
		objetos.add(new Arbol(adventures, new Vector2(773, 174)));
		
		objetos.add(new Arbol(adventures, new Vector2(193, 116)));
		objetos.add(new Roca(adventures, new Vector2(251, 116)));
		objetos.add(new Arbol(adventures, new Vector2(773, 116)));
		
		objetos.add(new Roca(adventures, new Vector2(309, 58)));
		objetos.add(new Roca(adventures, new Vector2(657, 58)));
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes.add(new Dragon(adventures, new Vector2(483, 580), manuel, Dragon.ABAJO));
		personajes.add(new Dragon(adventures, new Vector2(483, 406), manuel, Dragon.ARRIBA));
		personajes.add(new Dragon(adventures, new Vector2(425, 348), manuel, Dragon.IZQUIERDA));
		personajes.add(new Dragon(adventures, new Vector2(541, 348), manuel, Dragon.DERECHA));
		personajes.add(new Dragon(adventures, new Vector2(367, 58), manuel, Dragon.ARRIBA));
		personajes.add(new Dragon(adventures, new Vector2(599, 58), manuel, Dragon.ARRIBA));

		personajesMovibles.add(new Bloque(adventures, new Vector2(309, 348), manuel));
	}
}
