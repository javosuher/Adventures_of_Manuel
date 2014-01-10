package com.me.adventures.screens;

import com.badlogic.gdx.math.Vector2;
import com.me.adventures.characters.*;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Nivel4 extends Nivel {
	public Nivel4(AdventuresOfManuel adventures, Vector2 posicionManuel) {
		super(adventures, posicionManuel);
	}
	
	@Override
	protected void mapaDelNivel() {
		mapaNivel.add(new Puente(new Vector2(193, 348),Constant.PUENTE_VERTICAL));
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
		objetos.add(new Roca(new Vector2(251, 580)));
		objetos.add(new Roca(new Vector2(309, 580)));
		objetos.add(new Roca(new Vector2(367, 580)));
		objetos.add(new Roca(new Vector2(425, 580)));
		objetos.add(new Roca(new Vector2(483, 580)));
		objetos.add(new Roca(new Vector2(541, 580)));
		objetos.add(new Bloque(new Vector2(599, 580)));
		
		objetos.add(new Bloque(new Vector2(309, 522)));
		objetos.add(new Roca(new Vector2(715, 522)));
		
		objetos.add(new Roca(new Vector2(541, 464)));
		objetos.add(new Roca(new Vector2(599, 464)));
		objetos.add(new Roca(new Vector2(657, 464)));
		objetos.add(new Roca(new Vector2(715, 464)));
		
		corazones.add(new Corazon(new Vector2(193, 406), 0));
		objetos.add(new Agua(new Vector2(251, 406)));
		objetos.add(new Agua(new Vector2(309, 406)));
		objetos.add(new Agua(new Vector2(367, 406)));
		objetos.add(new Agua(new Vector2(425, 406)));
		objetos.add(new Roca(new Vector2(541, 406)));
		corazones.add(new Corazon(new Vector2(599, 406), 0));
		objetos.add(new Bloque(new Vector2(715, 406)));

		objetos.add(new Agua(new Vector2(251, 348)));
		objetos.add(new Agua(new Vector2(309, 348)));
		objetos.add(new Agua(new Vector2(367, 348)));
		cofre = new Cofre(new Vector2(425, 348), 5);
		objetos.add(new Roca(new Vector2(541, 348)));
		corazones.add(new Corazon(new Vector2(599, 348), 0));
		objetos.add(new Bloque(new Vector2(715, 348)));

		corazones.add(new Corazon(new Vector2(193, 290), 0));
		objetos.add(new Agua(new Vector2(251, 290)));
		objetos.add(new Agua(new Vector2(309, 290)));
		objetos.add(new Agua(new Vector2(367, 290)));
		objetos.add(new Agua(new Vector2(425, 290)));
		objetos.add(new Roca(new Vector2(541, 290)));
		corazones.add(new Corazon(new Vector2(599, 290), 0));
		objetos.add(new Bloque(new Vector2(715, 290)));
		
		objetos.add(new Roca(new Vector2(541, 232)));
		objetos.add(new Roca(new Vector2(599, 232)));
		objetos.add(new Roca(new Vector2(657, 232)));
		objetos.add(new Roca(new Vector2(715, 232)));

		objetos.add(new Bloque(new Vector2(309, 174)));
		objetos.add(new Roca(new Vector2(715, 174)));
		
		objetos.add(new Roca(new Vector2(251, 116)));
		objetos.add(new Roca(new Vector2(309, 116)));
		objetos.add(new Roca(new Vector2(367, 116)));
		objetos.add(new Roca(new Vector2(425, 116)));
		objetos.add(new Roca(new Vector2(483, 116)));
		objetos.add(new Roca(new Vector2(541, 116)));
		objetos.add(new Bloque(new Vector2(599, 116)));
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes.add(new Serpiente(new Vector2(367, 638), manuel));//calavera
		personajes.add(new Serpiente(new Vector2(657, 348), manuel));//calavera
		personajes.add(new Serpiente(new Vector2(367, 58), manuel));//calavera
	}
}