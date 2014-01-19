package com.me.adventures.screens;

import com.badlogic.gdx.math.Vector2;
import com.me.adventures.characters.*;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Nivel1 extends Nivel {
	
	public Nivel1(AdventuresOfManuel adventures, Vector2 posicionManuel) {
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
		objetos.add(new Pared(adventures, new Vector2(135, 696), 406, 58));
		objetos.add(new Pared(adventures, new Vector2(541, 725), 58, 29));
		objetos.add(new Pared(adventures, new Vector2(541, 696), 58, 29));//
		salida = new Salida(adventures, new Vector2(483,696), Constant.PUERTA, objetos.size()-1);
		objetos.add(new Pared(adventures, new Vector2(599, 696), 290, 58));
		objetos.add(new Pared(adventures, new Vector2(831, 0), 58, 754));
		
		//Se introducen los demas objetos por fila
		objetos.add(new Roca(adventures, new Vector2(193, 638)));
		objetos.add(new Roca(adventures, new Vector2(251, 638)));
		objetos.add(new Roca(adventures, new Vector2(309, 638)));
		objetos.add(new Roca(adventures, new Vector2(367, 638)));
		objetos.add(new Roca(adventures, new Vector2(425, 638)));
		objetos.add(new Roca(adventures, new Vector2(483, 638)));
		objetos.add(new Roca(adventures, new Vector2(599, 638)));
		objetos.add(new Roca(adventures, new Vector2(657, 638)));
		objetos.add(new Arbol(adventures, new Vector2(715, 638)));
		objetos.add(new Arbol(adventures, new Vector2(773, 638)));
		
		objetos.add(new Roca(adventures, new Vector2(193, 580)));
		objetos.add(new Arbol(adventures, new Vector2(251, 580)));
		objetos.add(new Arbol(adventures, new Vector2(309, 580)));
		objetos.add(new Roca(adventures, new Vector2(367, 580)));
		corazones.add(new Corazon(adventures, new Vector2(425,580), 0)); //no da proyectiles
		objetos.add(new Roca(adventures, new Vector2(599, 580)));
		objetos.add(new Roca(adventures, new Vector2(657, 580)));
		objetos.add(new Arbol(adventures, new Vector2(715, 580)));
		objetos.add(new Arbol(adventures, new Vector2(773, 580)));
		
		objetos.add(new Arbol(adventures, new Vector2(251, 522)));
		objetos.add(new Arbol(adventures, new Vector2(309, 522)));
		objetos.add(new Roca(adventures, new Vector2(367, 522)));
		objetos.add(new Roca(adventures, new Vector2(425, 522)));
		objetos.add(new Roca(adventures, new Vector2(483, 522)));
		objetos.add(new Roca(adventures, new Vector2(599, 522)));
		objetos.add(new Roca(adventures, new Vector2(657, 522)));
		objetos.add(new Roca(adventures, new Vector2(715, 522)));
		objetos.add(new Arbol(adventures, new Vector2(773, 522)));
		
		objetos.add(new Arbol(adventures, new Vector2(309, 464)));
		objetos.add(new Arbol(adventures, new Vector2(367, 464)));
		objetos.add(new Roca(adventures, new Vector2(425, 464)));
		objetos.add(new Roca(adventures, new Vector2(483, 464)));
		objetos.add(new Roca(adventures, new Vector2(599, 464)));
		objetos.add(new Roca(adventures, new Vector2(657, 464)));
		objetos.add(new Roca(adventures, new Vector2(715, 464)));
		objetos.add(new Arbol(adventures, new Vector2(773, 464)));
		
		objetos.add(new Roca(adventures, new Vector2(425, 406)));
		objetos.add(new Roca(adventures, new Vector2(483, 406)));
		objetos.add(new Roca(adventures, new Vector2(599, 406)));
		objetos.add(new Roca(adventures, new Vector2(657, 406)));
		objetos.add(new Arbol(adventures, new Vector2(715, 406)));
		corazones.add(new Corazon(adventures, new Vector2(773,406), 2)); //otorga 2 proyectiles
		
		objetos.add(new Roca(adventures, new Vector2(657, 348)));
		
		objetos.add(new Arbol(adventures, new Vector2(251, 290)));
		objetos.add(new Arbol(adventures, new Vector2(309, 290)));
		
		objetos.add(new Arbol(adventures, new Vector2(193, 232)));
		objetos.add(new Arbol(adventures, new Vector2(251, 232)));
		objetos.add(new Arbol(adventures, new Vector2(309, 232)));
		objetos.add(new Arbol(adventures, new Vector2(367, 232)));
		objetos.add(new Arbol(adventures, new Vector2(599, 232)));
		objetos.add(new Arbol(adventures, new Vector2(657, 232)));
		
		objetos.add(new Arbol(adventures, new Vector2(193, 174)));
		objetos.add(new Arbol(adventures, new Vector2(251, 174)));
		objetos.add(new Arbol(adventures, new Vector2(309, 174)));
		objetos.add(new Arbol(adventures, new Vector2(367, 174)));
		objetos.add(new Arbol(adventures, new Vector2(599, 174)));
		objetos.add(new Arbol(adventures, new Vector2(657, 174)));
		objetos.add(new Arbol(adventures, new Vector2(715, 174)));
		
		objetos.add(new Roca(adventures, new Vector2(193, 116)));
		objetos.add(new Arbol(adventures, new Vector2(251, 116)));
		objetos.add(new Arbol(adventures, new Vector2(309, 116)));
		objetos.add(new Roca(adventures, new Vector2(367, 116)));
		cofre = new Cofre(adventures, new Vector2(425,116), 2);
		objetos.add(new Arbol(adventures, new Vector2(657, 116)));
		objetos.add(new Arbol(adventures, new Vector2(715, 116)));
		
		objetos.add(new Roca(adventures, new Vector2(193, 58)));
		objetos.add(new Roca(adventures, new Vector2(251, 58)));
		objetos.add(new Roca(adventures, new Vector2(309, 58)));
		objetos.add(new Roca(adventures, new Vector2(367, 58)));
		objetos.add(new Roca(adventures, new Vector2(425, 58)));
		objetos.add(new Roca(adventures, new Vector2(483, 58)));
	}
	
	@Override
	protected void personajesDelNivel() {		
		personajes.add(new Serpiente(adventures, new Vector2(541,348), manuel));
	}
}
