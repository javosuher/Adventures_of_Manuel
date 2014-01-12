package com.me.adventures.screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.buttons.*;
import com.me.adventures.main.AdventuresOfManuel;

public class MainScreen extends AbstractScreen {
	private List<Boton> botonesPrincipales;
	private List<Boton> botonesModoHistoria;
	private List<Boton> botonesOpciones;

	public MainScreen(AdventuresOfManuel adventures) {
		super(adventures);
	}
	
	@Override
	public void show() {
		botonesPrincipales = new ArrayList<Boton>();
		botonesModoHistoria = new ArrayList<Boton>();
		botonesOpciones = new ArrayList<Boton>();
		
		botonesPrincipales.add(new BotonModoHistoria(adventures, new Vector2(100, Gdx.graphics.getHeight() - 100)));
		botonesPrincipales.add(new BotonModoMustDie(adventures, new Vector2(100, Gdx.graphics.getHeight() - 150)));
		botonesPrincipales.add(new BotonOpciones(adventures, new Vector2(100, Gdx.graphics.getHeight() - 200)));
		botonesPrincipales.add(new BotonExit(adventures, new Vector2(100, Gdx.graphics.getHeight() - 250)));
		
		botonesPrincipales.get(0).setMainScreen(this); // Asignacion de MainScreen para nuevos menus
		botonesPrincipales.get(2).setMainScreen(this);
	}
	
	public void menuModoHistoria() {
		botonesOpciones.clear();
		botonesModoHistoria.add(new BotonNivel1(adventures, new Vector2(500, Gdx.graphics.getHeight() - 100)));
		botonesModoHistoria.add(new BotonNivel2(adventures, new Vector2(500, Gdx.graphics.getHeight() - 150)));
		botonesModoHistoria.add(new BotonNivel3(adventures, new Vector2(500, Gdx.graphics.getHeight() - 200)));
		botonesModoHistoria.add(new BotonNivel4(adventures, new Vector2(500, Gdx.graphics.getHeight() - 250)));
		botonesModoHistoria.add(new BotonNivel5(adventures, new Vector2(500, Gdx.graphics.getHeight() - 300)));
	}
	
	public void menuOpciones() {
		botonesModoHistoria.clear();
		botonesOpciones.add(new BotonEfectos(adventures, new Vector2(500, Gdx.graphics.getHeight() - 100)));
		botonesOpciones.add(new BotonMusica(adventures, new Vector2(500, Gdx.graphics.getHeight() - 150)));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		for(Boton boton : botonesPrincipales)
			boton.update();
		for(Boton boton : botonesModoHistoria)
			boton.update();
		for(Boton boton : botonesOpciones)
			boton.update();
		
		batch.begin();
		for(Boton boton : botonesPrincipales)
			boton.draw(batch);
		for(Boton boton : botonesModoHistoria)
			boton.draw(batch);
		for(Boton boton : botonesOpciones)
			boton.draw(batch);
		batch.end();
	}
	
	public List<Boton> getBotonesPrincipales() {
		return botonesPrincipales;
	}

	public List<Boton> getBotonesModoHistoria() {
		return botonesModoHistoria;
	}

	public List<Boton> getBotonesOpciones() {
		return botonesOpciones;
	}

	@Override
	public void resize(int width, int height) {
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
