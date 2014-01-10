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

public class Nivel2 extends Nivel {
	private AdventuresOfManuel adventurasDeManuel;
	private Texture TexturaFondo;
	private SpriteBatch batch;
	private Manuel manuel;
	private Cofre cofre;
	private List<Corazon> corazones;
	private List<ObjetoDelJuego> objetos;
	private List<PersonajeDelJuego> personajes;
	private Colision colisiones;
	private List<PersonajeDelJuego> personajesMovibles;
	private Salida salida;

	public Nivel2(AdventuresOfManuel adventuras_del_manuel) {
		this.adventurasDeManuel = adventuras_del_manuel;
		TexturaFondo = new Texture("Miscelanea/Nivel.png");
		TexturaFondo.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		manuel = new Manuel(new Vector2(193, 464));
		
		objetosDelNivel();
		personajesDelNivel();
		colisiones = new Colision(manuel, personajes, objetos, personajesMovibles, corazones, cofre, salida);
		
		manuel.setColision(colisiones);
		
		batch = new SpriteBatch();
	}
	
	@Override
	protected void objetosDelNivel() {
		objetos = new ArrayList<ObjetoDelJuego>();
		corazones = new ArrayList<Corazon>();

		//Se introducen las paredes del nivel
		objetos.add(new Pared(new Vector2(0, 0), 1024, 58));
		objetos.add(new Pared(new Vector2(135, 0), 58, 754));
		objetos.add(new Pared(new Vector2(135, 696), 580, 58));
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
		
		//Agua(193,464);
		//Agua(251,464);
		//Agua(309,464);
		//Agua(367,464);
		//Puente(425,464);
		//Agua(483,464);
		//Agua(541,464);
		//Agua(599,464);
		//Agua(657,464);
		//Puente(715,464);
		//Agua(773,464);
		
		//Agua(193,406);
		//Agua(251,406);
		//Agua(309,406);
		//Agua(367,406);
		//Puente(425,406);
		//Agua(483,406);
		//Agua(541,406);
		//Agua(599,406);
		//Agua(657,406);
		//Puente(715,406);
		//Agua(773,406);
		
		cofre = new Cofre(new Vector2(193, 348), 3);
		objetos.add(new Arbol(new Vector2(309, 348)));
		objetos.add(new Arbol(new Vector2(367, 348)));
		//agua(773,348);
		
		objetos.add(new Arbol(new Vector2(309, 290)));
		objetos.add(new Arbol(new Vector2(367, 290)));
		objetos.add(new Arbol(new Vector2(599, 290)));
		objetos.add(new Arbol(new Vector2(657, 290)));
		//agua(773, 290);

		objetos.add(new Roca(new Vector2(483, 232)));
		objetos.add(new Roca(new Vector2(541, 232)));
		objetos.add(new Arbol(new Vector2(599, 232)));
		objetos.add(new Arbol(new Vector2(657, 232)));
		//agua(775,232)

		objetos.add(new Roca(new Vector2(483, 174)));
		objetos.add(new Roca(new Vector2(541, 174)));
		corazones.add(new Corazon(new Vector2(599, 174), 0)); //no da proyectiles
		//agua(773, 174)
		
		//objetos.add(new Caja(new Vector2(541, 116)));
		//agua(773, 116);
		
		corazones.add(new Corazon(new Vector2(193, 58), 0)); //no da proyectiles
		//agua(541, 58);
		//agua(599, 58);
		//agua(657, 58);
		//agua(715, 58);
		//agua(773, 58);
	}
	
	@Override
	protected void personajesDelNivel() {
		personajes = new ArrayList<PersonajeDelJuego>();

		personajes.add(new Serpiente(new Vector2(367, 638), manuel));
		personajes.add(new Serpiente(new Vector2(193, 174), manuel));
		for(PersonajeDelJuego p : personajes){
			p.setColision(colisiones);
		}
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		// Actualizamos personajes pantalla
		manuel.update();
		
		// Pintamos la pantalla
		batch.begin();
		batch.draw(TexturaFondo, 135, 0, TexturaFondo.getWidth(), TexturaFondo.getHeight());
		salida.draw(batch);
		for(Corazon corazon : corazones){
			corazon.draw(batch);
		}
		cofre.draw(batch);
		manuel.draw(batch);
		if(salida.salidaAbierta() == false){
			for(PersonajeDelJuego personaje : personajes){
				personaje.draw(batch);
			}
		}
		
		for(ObjetoDelJuego objeto : objetos) {
			objeto.draw(batch);
		}
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}