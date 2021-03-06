package com.me.adventures.screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.characters.*;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Nivel2 extends Nivel {
	public Nivel2(AdventuresOfManuel adventures, Vector2 posicionManuel) {
		super(adventures, posicionManuel);
	}
	
	@Override
	protected void mapaDelNivel() {
		mapaNivel.add(new Puente(adventures, new Vector2(715,464),Constant.PUENTE_VERTICAL));
		mapaNivel.add(new Puente(adventures, new Vector2(425,464),Constant.PUENTE_VERTICAL));

		mapaNivel.add(new Puente(adventures, new Vector2(425,406),Constant.PUENTE_VERTICAL));
		mapaNivel.add(new Puente(adventures, new Vector2(715,406),Constant.PUENTE_VERTICAL));
	}
	
	@Override
	protected void objetosDelNivel() {
		objetos = new ArrayList<ObjetoDelJuego>();
		corazones = new ArrayList<Corazon>();

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
		objetos.add(new Roca(adventures, new Vector2(483, 638)));
		objetos.add(new Roca(adventures, new Vector2(541, 638)));
		objetos.add(new Roca(adventures, new Vector2(599, 638)));

		corazones.add(new Corazon(adventures, new Vector2(251, 580), 2));
		objetos.add(new Roca(adventures, new Vector2(483, 580)));
		objetos.add(new Roca(adventures, new Vector2(541, 580)));
		objetos.add(new Roca(adventures, new Vector2(599, 580)));
		corazones.add(new Corazon(adventures, new Vector2(715, 580), 0));
		
		objetos.add(new Arbol(adventures, new Vector2(541, 522)));
		objetos.add(new Arbol(adventures, new Vector2(599, 522)));
		
		objetos.add(new Agua(adventures, new Vector2(193,464)));
		objetos.add(new Agua(adventures, new Vector2(251,464)));
		objetos.add(new Agua(adventures, new Vector2(309,464)));
		objetos.add(new Agua(adventures, new Vector2(367,464)));
		objetos.add(new Agua(adventures, new Vector2(483,464)));
		objetos.add(new Agua(adventures, new Vector2(541,464)));
		objetos.add(new Agua(adventures, new Vector2(599,464)));
		objetos.add(new Agua(adventures, new Vector2(657,464)));
		objetos.add(new Agua(adventures, new Vector2(773,464)));
		
		objetos.add(new Agua(adventures, new Vector2(193,406)));
		objetos.add(new Agua(adventures, new Vector2(251,406)));
		objetos.add(new Agua(adventures, new Vector2(309,406)));
		objetos.add(new Agua(adventures, new Vector2(367,406)));
		objetos.add(new Agua(adventures, new Vector2(483,406)));
		objetos.add(new Agua(adventures, new Vector2(541,406)));
		objetos.add(new Agua(adventures, new Vector2(599,406)));
		objetos.add(new Agua(adventures, new Vector2(657,406)));
		objetos.add(new Agua(adventures, new Vector2(773,406)));
		
		cofre = new Cofre(adventures, new Vector2(193, 348), 4);
		objetos.add(new Arbol(adventures, new Vector2(309, 348)));
		objetos.add(new Arbol(adventures, new Vector2(367, 348)));
		objetos.add(new Agua(adventures, new Vector2(773,348)));
		
		objetos.add(new Arbol(adventures, new Vector2(309, 290)));
		objetos.add(new Arbol(adventures, new Vector2(367, 290)));
		objetos.add(new Arbol(adventures, new Vector2(599, 290)));
		objetos.add(new Arbol(adventures, new Vector2(657, 290)));
		objetos.add(new Agua(adventures, new Vector2(773, 290)));

		objetos.add(new Roca(adventures, new Vector2(483, 232)));
		objetos.add(new Roca(adventures, new Vector2(541, 232)));
		objetos.add(new Arbol(adventures, new Vector2(599, 232)));
		objetos.add(new Arbol(adventures, new Vector2(657, 232)));
		objetos.add(new Agua(adventures, new Vector2(773,232)));

		objetos.add(new Roca(adventures, new Vector2(483, 174)));
		objetos.add(new Roca(adventures, new Vector2(541, 174)));
		corazones.add(new Corazon(adventures, new Vector2(599, 174), 0));
		objetos.add(new Agua(adventures, new Vector2(773, 174)));
		
		objetos.add(new Agua(adventures, new Vector2(773, 116)));
		
		corazones.add(new Corazon(adventures, new Vector2(193, 58), 0));
		objetos.add(new Agua(adventures, new Vector2(541, 58)));
		objetos.add(new Agua(adventures, new Vector2(599, 58)));
		objetos.add(new Agua(adventures, new Vector2(657, 58)));
		objetos.add(new Agua(adventures, new Vector2(715, 58)));
		objetos.add(new Agua(adventures, new Vector2(773, 58)));
		
		//Objetos que afectan a la colision de disparos de enemigos
		objetosEnemigos.add(new Pared(adventures, new Vector2(0, 0), 1024, 58));
		objetosEnemigos.add(new Pared(adventures, new Vector2(135, 0), 58, 754));
		objetosEnemigos.add(new Pared(adventures, new Vector2(135, 696), 580, 58));
		objetosEnemigos.add(new Pared(adventures, new Vector2(715, 725), 58, 29));
		objetosEnemigos.add(new Pared(adventures, new Vector2(773, 696), 58, 58));
		objetosEnemigos.add(new Pared(adventures, new Vector2(831, 0), 58, 754));
		
		//Se introducen los demas objetos por fila
		objetosEnemigos.add(new Roca(adventures, new Vector2(483, 638)));
		objetosEnemigos.add(new Roca(adventures, new Vector2(541, 638)));
		objetosEnemigos.add(new Roca(adventures, new Vector2(599, 638)));

		objetosEnemigos.add(new Roca(adventures, new Vector2(483, 580)));
		objetosEnemigos.add(new Roca(adventures, new Vector2(541, 580)));
		objetosEnemigos.add(new Roca(adventures, new Vector2(599, 580)));
		
		objetosEnemigos.add(new Roca(adventures, new Vector2(483, 232)));
		objetosEnemigos.add(new Roca(adventures, new Vector2(541, 232)));

		objetosEnemigos.add(new Roca(adventures, new Vector2(483, 174)));
		objetosEnemigos.add(new Roca(adventures, new Vector2(541, 174)));
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes.add(new Dragon(adventures, new Vector2(367, 638), manuel, Dragon.ABAJO));
		personajes.add(new Dragon(adventures, new Vector2(193, 174), manuel, Dragon.DERECHA));
		
		personajesMovibles.add(new Bloque(adventures, new Vector2(541, 116), manuel));
	}
}