package com.me.adventures.screens;

import java.util.ArrayList;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.characters.*;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Nivel2 extends Nivel {
	public Nivel2(AdventuresOfManuel adventures) {
		super(adventures);
		manuel = new Manuel(new Vector2(425,116));
		iniciarColisiones();
	}
	
	@Override
	protected void mapaDelNivel() {
		mapaNivel.add(new Puente(new Vector2(715,464),Constant.PUENTE_VERTICAL));
		mapaNivel.add(new Puente(new Vector2(425,464),Constant.PUENTE_VERTICAL));

		mapaNivel.add(new Puente(new Vector2(425,406),Constant.PUENTE_VERTICAL));
		mapaNivel.add(new Puente(new Vector2(715,406),Constant.PUENTE_VERTICAL));
	}
	
	@Override
	protected void objetosDelNivel() {
		//Se introducen las paredes del nivel
		objetos.add(new Pared(new Vector2(0, 0), 1024, 58));
		objetos.add(new Pared(new Vector2(135, 0), 58, 754));
		objetos.add(new Pared(new Vector2(135, 696), 580, 58));
		objetos.add(new Pared(new Vector2(715, 725), 58, 29));
		salida = new Salida(new Vector2(657,696), "PUERTA");
		objetos.add(new Pared(new Vector2(773, 696), 58, 58));
		objetos.add(new Pared(new Vector2(831, 0), 58, 754));
		
		//Se introducen los demas objetos por fila
		objetos.add(new Roca(new Vector2(483, 638)));
		objetos.add(new Roca(new Vector2(541, 638)));
		objetos.add(new Roca(new Vector2(599, 638)));

		corazones.add(new Corazon(new Vector2(251, 580), 2)); //otorga 2 proyectiles
		objetos.add(new Roca(new Vector2(483, 580)));
		objetos.add(new Roca(new Vector2(541, 580)));
		objetos.add(new Roca(new Vector2(599, 580)));
		corazones.add(new Corazon(new Vector2(715, 580), 0)); //no da proyectiles
		
		objetos.add(new Arbol(new Vector2(541, 522)));
		objetos.add(new Arbol(new Vector2(599, 522)));
		
		objetos.add(new Agua(new Vector2(193,464)));
		objetos.add(new Agua(new Vector2(251,464)));
		objetos.add(new Agua(new Vector2(309,464)));
		objetos.add(new Agua(new Vector2(367,464)));
		objetos.add(new Agua(new Vector2(425,464)));
		objetos.add(new Agua(new Vector2(483,464)));
		objetos.add(new Agua(new Vector2(541,464)));
		objetos.add(new Agua(new Vector2(599,464)));
		objetos.add(new Agua(new Vector2(657,464)));
		objetos.add(new Agua(new Vector2(715,464)));
		objetos.add(new Agua(new Vector2(773,464)));
		
		objetos.add(new Agua(new Vector2(193,406)));
		objetos.add(new Agua(new Vector2(251,406)));
		objetos.add(new Agua(new Vector2(309,406)));
		objetos.add(new Agua(new Vector2(367,406)));
		objetos.add(new Agua(new Vector2(425,406)));
		objetos.add(new Agua(new Vector2(483,406)));
		objetos.add(new Agua(new Vector2(541,406)));
		objetos.add(new Agua(new Vector2(599,406)));
		objetos.add(new Agua(new Vector2(657,406)));
		objetos.add(new Agua(new Vector2(715,406)));
		objetos.add(new Agua(new Vector2(773,406)));
		
		cofre = new Cofre(new Vector2(193, 348), 4);
		objetos.add(new Arbol(new Vector2(309, 348)));
		objetos.add(new Arbol(new Vector2(367, 348)));
		objetos.add(new Agua(new Vector2(773,348)));
		
		objetos.add(new Arbol(new Vector2(309, 290)));
		objetos.add(new Arbol(new Vector2(367, 290)));
		objetos.add(new Arbol(new Vector2(599, 290)));
		objetos.add(new Arbol(new Vector2(657, 290)));
		objetos.add(new Agua(new Vector2(773, 290)));

		objetos.add(new Roca(new Vector2(483, 232)));
		objetos.add(new Roca(new Vector2(541, 232)));
		objetos.add(new Arbol(new Vector2(599, 232)));
		objetos.add(new Arbol(new Vector2(657, 232)));
		objetos.add(new Agua(new Vector2(775,232)));

		objetos.add(new Roca(new Vector2(483, 174)));
		objetos.add(new Roca(new Vector2(541, 174)));
		corazones.add(new Corazon(new Vector2(599, 174), 0)); //no da proyectiles
		objetos.add(new Agua(new Vector2(773, 174)));
		
		objetos.add(new Bloque(new Vector2(541, 116)));
		objetos.add(new Agua(new Vector2(773, 116)));
		
		corazones.add(new Corazon(new Vector2(193, 58), 0)); //no da proyectiles
		objetos.add(new Agua(new Vector2(541, 58)));
		objetos.add(new Agua(new Vector2(599, 58)));
		objetos.add(new Agua(new Vector2(657, 58)));
		objetos.add(new Agua(new Vector2(715, 58)));
		objetos.add(new Agua(new Vector2(773, 58)));
	}
	
	@Override
	protected void personajesDelNivel() {
		/*personajes.add(new Serpiente(new Vector2(367, 638), manuel));
		personajes.add(new Serpiente(new Vector2(193, 174), manuel));*/
	}
}