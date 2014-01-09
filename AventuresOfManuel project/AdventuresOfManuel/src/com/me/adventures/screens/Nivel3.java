package com.me.adventures.screens;

import com.badlogic.gdx.math.Vector2;
import com.me.adventures.characters.*;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Nivel3 extends Nivel {
	public Nivel3(AdventuresOfManuel adventures) {
		super(adventures);
		manuel = new Manuel(new Vector2(541, 174));
		iniciarColisiones();
	}
	
	@Override
	protected void mapaDelNivel() {
		mapaNivel.add(new Puente(new Vector2(251, 348),Constant.PUENTE_HORIZONTAL));
		mapaNivel.add(new Puente(new Vector2(309, 116),Constant.PUENTE_VERTICAL));
	}
	
	@Override
	protected void objetosDelNivel() {
		//Se introducen las paredes del nivel
		objetos.add(new Pared(new Vector2(0, 0), 1024, 58));
		objetos.add(new Pared(new Vector2(135, 0), 58, 754));
		objetos.add(new Pared(new Vector2(135, 696), 348, 58));
		objetos.add(new Pared(new Vector2(483, 725), 58, 29));
		salida = new Salida(new Vector2(425, 696), "PUERTA");
		objetos.add(new Pared(new Vector2(541, 696), 290, 58));
		objetos.add(new Pared(new Vector2(831, 0), 58, 754));
		
		//Se introducen los demas objetos por fila
		objetos.add(new Arbol(new Vector2(309, 580)));
		objetos.add(new Arbol(new Vector2(367, 580)));
		objetos.add(new Arbol(new Vector2(425, 580)));
		objetos.add(new Arbol(new Vector2(483, 580)));
		objetos.add(new Agua(new Vector2(599, 580)));
		objetos.add(new Agua(new Vector2(657, 580)));
		objetos.add(new Agua(new Vector2(715, 580)));
		
		objetos.add(new Agua(new Vector2(251, 522)));
		objetos.add(new Arbol(new Vector2(309, 522)));
		objetos.add(new Arbol(new Vector2(367, 522)));
		objetos.add(new Arbol(new Vector2(425, 522)));
		objetos.add(new Arbol(new Vector2(483, 522)));
		corazones.add(new Corazon(new Vector2(541, 522), 0));
		objetos.add(new Agua(new Vector2(599, 522)));
		objetos.add(new Agua(new Vector2(657, 522)));
		objetos.add(new Agua(new Vector2(715, 522)));

		objetos.add(new Agua(new Vector2(251, 464)));
		objetos.add(new Agua(new Vector2(309, 464)));
		objetos.add(new Agua(new Vector2(367, 464)));
		objetos.add(new Agua(new Vector2(425, 464)));
		objetos.add(new Agua(new Vector2(483, 464)));
		objetos.add(new Agua(new Vector2(541, 464)));
		objetos.add(new Agua(new Vector2(599, 464)));
		objetos.add(new Agua(new Vector2(657, 464)));
		objetos.add(new Agua(new Vector2(715, 464)));
		
		objetos.add(new Agua(new Vector2(251, 406)));
		cofre = new Cofre(new Vector2(309, 406), 5);
		objetos.add(new Arbol(new Vector2(367, 406)));
		objetos.add(new Arbol(new Vector2(599, 406)));


		objetos.add(new Agua(new Vector2(251, 348)));
		objetos.add(new Roca(new Vector2(367, 348)));
		objetos.add(new Roca(new Vector2(483, 348)));
		objetos.add(new Arbol(new Vector2(599, 348)));
		
		objetos.add(new Agua(new Vector2(251, 290)));
		objetos.add(new Roca(new Vector2(367, 290)));
		corazones.add(new Corazon(new Vector2(425, 290), 2));
		objetos.add(new Roca(new Vector2(483, 290)));
		corazones.add(new Corazon(new Vector2(541, 290), 0));

		objetos.add(new Agua(new Vector2(251, 232)));
		objetos.add(new Roca(new Vector2(367, 232)));
		objetos.add(new Roca(new Vector2(483, 232)));
		objetos.add(new Arbol(new Vector2(541, 232)));
		objetos.add(new Agua(new Vector2(599, 232)));
		objetos.add(new Agua(new Vector2(657, 232)));
		objetos.add(new Agua(new Vector2(715, 232)));

		objetos.add(new Agua(new Vector2(251, 174)));
		objetos.add(new Arbol(new Vector2(367, 174)));
		objetos.add(new Agua(new Vector2(599, 174)));
		objetos.add(new Agua(new Vector2(657, 174)));
		objetos.add(new Agua(new Vector2(715, 174)));

		objetos.add(new Agua(new Vector2(251, 116)));
		objetos.add(new Agua(new Vector2(309, 116)));
		objetos.add(new Agua(new Vector2(367, 116)));
		objetos.add(new Agua(new Vector2(425, 116)));
		objetos.add(new Agua(new Vector2(483, 116)));
		objetos.add(new Agua(new Vector2(541, 116)));
		objetos.add(new Agua(new Vector2(599, 116)));
		objetos.add(new Agua(new Vector2(657, 116)));
		objetos.add(new Agua(new Vector2(715, 116)));
		corazones.add(new Corazon(new Vector2(773, 116), 0));
		
		corazones.add(new Corazon(new Vector2(599, 58), 0));
		objetos.add(new Arbol(new Vector2(773, 58)));
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes.add(new Serpiente(new Vector2(483, 406), manuel));
		personajes.add(new Serpiente(new Vector2(193, 174), manuel)); //Fantasma verde
	}
}