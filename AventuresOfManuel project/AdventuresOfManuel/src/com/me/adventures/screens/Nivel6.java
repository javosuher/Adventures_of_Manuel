package com.me.adventures.screens;

import com.badlogic.gdx.math.Vector2;
import com.me.adventures.characters.Arbol;
import com.me.adventures.characters.Cofre;
import com.me.adventures.characters.Corazon;
import com.me.adventures.characters.Fantasma;
import com.me.adventures.characters.Pared;
import com.me.adventures.characters.Roca;
import com.me.adventures.characters.Salida;
import com.me.adventures.characters.Serpiente;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Nivel6 extends Nivel{
	public Nivel6(AdventuresOfManuel adventures, Vector2 posicionManuel) {
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
		objetos.add(new Arbol(adventures, new Vector2(773, 638)));

		objetos.add(new Roca(adventures, new Vector2(251, 580)));
		objetos.add(new Roca(adventures, new Vector2(425, 580)));
		corazones.add(new Corazon(adventures, new Vector2(541, 580), 0));
		objetos.add(new Roca(adventures, new Vector2(599, 580)));

		objetos.add(new Arbol(adventures, new Vector2(251, 522)));
		objetos.add(new Roca(adventures, new Vector2(367, 522)));
		objetos.add(new Roca(adventures, new Vector2(425, 522)));
		objetos.add(new Roca(adventures, new Vector2(541, 522)));
		objetos.add(new Roca(adventures, new Vector2(599, 522)));

		corazones.add(new Corazon(adventures, new Vector2(251, 464), 0));
		objetos.add(new Roca(adventures, new Vector2(425, 464)));
		corazones.add(new Corazon(adventures, new Vector2(483, 464), 2));
		objetos.add(new Roca(adventures, new Vector2(541, 464)));
		objetos.add(new Roca(adventures, new Vector2(599, 464)));
		corazones.add(new Corazon(adventures, new Vector2(657, 464), 0));
		corazones.add(new Corazon(adventures, new Vector2(773, 464), 0));
		
		objetos.add(new Arbol(adventures, new Vector2(251, 406)));
		objetos.add(new Roca(adventures, new Vector2(425, 406)));
		objetos.add(new Roca(adventures, new Vector2(483, 406)));
		objetos.add(new Roca(adventures, new Vector2(541, 406)));
		objetos.add(new Arbol(adventures, new Vector2(599, 406)));
		objetos.add(new Arbol(adventures, new Vector2(657, 406)));
		objetos.add(new Arbol(adventures, new Vector2(773, 406)));
		
		cofre = new Cofre(adventures, new Vector2(425, 348), 9);
		objetos.add(new Roca(adventures, new Vector2(483, 348)));
		corazones.add(new Corazon(adventures, new Vector2(541, 348), 0));
		objetos.add(new Arbol(adventures, new Vector2(599, 348)));
		
		objetos.add(new Arbol(adventures, new Vector2(290, 290)));
		objetos.add(new Roca(adventures, new Vector2(599, 290)));
		objetos.add(new Arbol(adventures, new Vector2(657, 290)));
		objetos.add(new Arbol(adventures, new Vector2(773, 290)));

		corazones.add(new Corazon(adventures, new Vector2(773, 232), 0));

		objetos.add(new Roca(adventures, new Vector2(773, 174)));

		objetos.add(new Arbol(adventures, new Vector2(367, 58)));
		corazones.add(new Corazon(adventures, new Vector2(425, 58), 0));
		objetos.add(new Arbol(adventures, new Vector2(483, 58)));
		objetos.add(new Roca(adventures, new Vector2(541, 58)));
		corazones.add(new Corazon(adventures, new Vector2(599, 58), 0));
		objetos.add(new Roca(adventures, new Vector2(657, 58)));
		objetos.add(new Arbol(adventures, new Vector2(715, 58)));
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes.add(new Fantasma(adventures, new Vector2(251, 638), manuel, Fantasma.DERECHA));
		personajes.add(new Serpiente(adventures, new Vector2(541, 290), manuel));
	}
}
