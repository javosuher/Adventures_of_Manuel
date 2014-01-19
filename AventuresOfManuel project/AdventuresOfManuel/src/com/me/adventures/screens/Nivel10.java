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

public class Nivel10 extends Nivel{
	public Nivel10(AdventuresOfManuel adventures, Vector2 posicionManuel) {
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
		objetos.add(new Arbol(adventures, new Vector2(309, 638)));
		objetos.add(new Arbol(adventures, new Vector2(425, 638)));
		objetos.add(new Arbol(adventures, new Vector2(541, 638)));
		objetos.add(new Arbol(adventures, new Vector2(657, 638)));

		objetos.add(new Arbol(adventures, new Vector2(251, 580)));
		objetos.add(new Roca(adventures, new Vector2(367, 580)));
		objetos.add(new Roca(adventures, new Vector2(599, 580)));
		objetos.add(new Arbol(adventures, new Vector2(715, 580)));
		
		objetos.add(new Arbol(adventures, new Vector2(193, 522)));
		objetos.add(new Roca(adventures, new Vector2(309, 522)));
		objetos.add(new Roca(adventures, new Vector2(657, 522)));
		objetos.add(new Arbol(adventures, new Vector2(773, 522)));

		objetos.add(new Roca(adventures, new Vector2(251, 464)));
		corazones.add(new Corazon(adventures, new Vector2(425, 464), 0));
		corazones.add(new Corazon(adventures, new Vector2(541, 464), 0));
		objetos.add(new Roca(adventures, new Vector2(715, 464)));
		
		objetos.add(new Arbol(adventures, new Vector2(193, 406)));
		corazones.add(new Corazon(adventures, new Vector2(367, 406), 0));
		corazones.add(new Corazon(adventures, new Vector2(483, 406), 0));
		corazones.add(new Corazon(adventures, new Vector2(599, 406), 0));
		
		corazones.add(new Corazon(adventures, new Vector2(251, 348), 0));
		corazones.add(new Corazon(adventures, new Vector2(425, 348), 0));
		cofre = new Cofre(adventures, new Vector2(483, 348), 14);
		corazones.add(new Corazon(adventures, new Vector2(541, 348), 0));
		corazones.add(new Corazon(adventures, new Vector2(715, 348), 2));
		
		objetos.add(new Arbol(adventures, new Vector2(193, 290)));
		corazones.add(new Corazon(adventures, new Vector2(367, 290), 0));
		corazones.add(new Corazon(adventures, new Vector2(483, 290), 0));
		corazones.add(new Corazon(adventures, new Vector2(599, 290), 0));
		
		objetos.add(new Roca(adventures, new Vector2(251, 232)));
		corazones.add(new Corazon(adventures, new Vector2(425, 232), 0));
		corazones.add(new Corazon(adventures, new Vector2(541, 232), 0));
		objetos.add(new Roca(adventures, new Vector2(715, 232)));
		
		objetos.add(new Arbol(adventures, new Vector2(193, 174)));
		objetos.add(new Roca(adventures, new Vector2(309, 174)));
		objetos.add(new Roca(adventures, new Vector2(657, 174)));
		objetos.add(new Arbol(adventures, new Vector2(773, 174)));

		objetos.add(new Arbol(adventures, new Vector2(251, 116)));
		objetos.add(new Roca(adventures, new Vector2(367, 116)));
		objetos.add(new Roca(adventures, new Vector2(599, 116)));
		objetos.add(new Arbol(adventures, new Vector2(715, 116)));
		
		objetos.add(new Arbol(adventures, new Vector2(309, 58)));
		objetos.add(new Arbol(adventures, new Vector2(425, 58)));
		objetos.add(new Arbol(adventures, new Vector2(541, 58)));
		objetos.add(new Arbol(adventures, new Vector2(657, 58)));
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes.add(new Dragon(adventures, new Vector2(483, 522), manuel, Dragon.ABAJO));
		personajes.add(new Dragon(adventures, new Vector2(309, 348), manuel, Dragon.DERECHA));
		personajes.add(new Dragon(adventures, new Vector2(657, 348), manuel, Dragon.IZQUIERDA));
		personajes.add(new Dragon(adventures, new Vector2(483, 174), manuel, Dragon.ARRIBA));
		
		personajesMovibles.add(new Bloque(adventures, new Vector2(425, 522), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(541, 522), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(367, 464), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(599, 464), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(309, 406), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(425, 406), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(541, 406), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(657, 406), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(309, 290), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(425, 290), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(541, 290), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(657, 290), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(367, 232), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(599, 232), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(425, 174), manuel));
		personajesMovibles.add(new Bloque(adventures, new Vector2(541, 174), manuel));

	}
}
