package com.me.adventures.screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.buttons.*;
import com.me.adventures.main.AdventuresOfManuel;

public class MainScreen extends AbstractScreen {
	private List<Boton> botonesPrincipales;
	private List<Boton> botonesModoHistoria;
	private List<Boton> botonesOpciones;
	private float ancho, alto, altura;

	public MainScreen(AdventuresOfManuel adventures) {
		super(adventures);
		
		/*ancho = adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth();
		alto = adventures.getManager().get("Pantallas/Loading.png", Texture.class).getHeight();
		altura = 0;
		if(Gdx.graphics.getWidth() < adventures.getManager().get("Pantallas/FondoMenu.png", Texture.class).getWidth()) {
			if(Gdx.app.getType() == ApplicationType.Desktop) {
				ancho = ancho * adventures.getDivMenu();
				alto = alto * adventures.getDivMenu();
				altura = Gdx.graphics.getHeight() - alto;
			}
			//else if(Gdx.app.getType() == ApplicationType.Android) {
				//adventures.getCamera().position.set(adventures.getManager().get("Pantallas/FondoMenu.png", Texture.class).getWidth() / 2, adventures.getManager().get("Pantallas/FondoMenu.png", Texture.class).getHeight() / 2, 0);
				//float sum = (float)((float)Gdx.graphics.getHeight() - (float)(adventures.getManager().get("Pantallas/FondoMenu.png", Texture.class).getHeight())) / 2; 
				//adventures.getCamera().position.set(adventures.getManager().get("Pantallas/FondoMenu.png", Texture.class).getWidth() / 2, adventures.getManager().get("Pantallas/FondoMenu.png", Texture.class).getHeight() / 2, 0);
				//adventures.getCamera().zoom = 1 / adventures.getDivMenu();
			//}
		}
		//altura = Gdx.graphics.getHeight() - alto;*/
		
		ancho = 0;
		alto = 0;
		if(Gdx.graphics.getWidth() < adventures.getManager().get("Pantallas/FondoMenu.png", Texture.class).getWidth()) {
			float div = (float) ((float) Gdx.graphics.getWidth()) / ((float) adventures.getManager().get("Pantallas/Loading.png", Texture.class).getWidth());
			ancho = adventures.getManager().get("Pantallas/FondoMenu.png", Texture.class).getWidth() * div;
			alto = adventures.getManager().get("Pantallas/FondoMenu.png", Texture.class).getHeight() * div;
			altura = Gdx.graphics.getHeight() - alto;
			adventures.getCamera().position.set(ancho / 2, alto / 2, 0);
			adventures.getCamera().zoom = 1;

		}
		
		botonesPrincipales = new ArrayList<Boton>();
		botonesModoHistoria = new ArrayList<Boton>();
		botonesOpciones = new ArrayList<Boton>();
		
		botonesPrincipales.add(new BotonModoHistoria(adventures, new Vector2(280, Gdx.graphics.getHeight() - 200)));
		botonesPrincipales.add(new BotonModoMustDie(adventures, new Vector2(280, Gdx.graphics.getHeight() - 290)));
		botonesPrincipales.add(new BotonInstrucciones(adventures, new Vector2(280, Gdx.graphics.getHeight() - 370)));
		botonesPrincipales.add(new BotonOpciones(adventures, new Vector2(285, Gdx.graphics.getHeight() - 450)));
		botonesPrincipales.add(new BotonExit(adventures, new Vector2(290, Gdx.graphics.getHeight() - 530)));
		
		botonesPrincipales.get(0).setMainScreen(this); // Asignacion de MainScreen para nuevos menus
		botonesPrincipales.get(3).setMainScreen(this);
	}
	
	public void menuModoHistoria() {
		borrarMenuOpciones();
		botonesModoHistoria.add(new BotonNivel1(adventures, new Vector2(600, Gdx.graphics.getHeight() - 100)));
		botonesModoHistoria.add(new BotonNivel2(adventures, new Vector2(600, Gdx.graphics.getHeight() - 200)));
		botonesModoHistoria.add(new BotonNivel3(adventures, new Vector2(600, Gdx.graphics.getHeight() - 300)));
		botonesModoHistoria.add(new BotonNivel4(adventures, new Vector2(600, Gdx.graphics.getHeight() - 400)));
		botonesModoHistoria.add(new BotonNivel5(adventures, new Vector2(600, Gdx.graphics.getHeight() - 500)));
		botonesModoHistoria.add(new BotonNivel6(adventures, new Vector2(700, Gdx.graphics.getHeight() - 100)));
		botonesModoHistoria.add(new BotonNivel7(adventures, new Vector2(700, Gdx.graphics.getHeight() - 200)));
		botonesModoHistoria.add(new BotonNivel8(adventures, new Vector2(700, Gdx.graphics.getHeight() - 300)));
		botonesModoHistoria.add(new BotonNivel9(adventures, new Vector2(700, Gdx.graphics.getHeight() - 400)));
		botonesModoHistoria.add(new BotonNivel10(adventures, new Vector2(700, Gdx.graphics.getHeight() - 500)));
	}
	
	public void menuOpciones() {
		botonesModoHistoria.clear();
		botonesOpciones.add(new BotonEfectos(adventures, new Vector2(700, Gdx.graphics.getHeight() - 300)));
		botonesOpciones.add(new BotonMusica(adventures, new Vector2(850, Gdx.graphics.getHeight() - 300)));
	}
	
	public void borrarMenuModoHistoria() {
		botonesModoHistoria.clear();
	}
	public void borrarMenuOpciones() {
		botonesOpciones.clear();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		if(adventures.isMusicaActivada()) { // Poner musica Menú
			if(adventures.getMusicaNivel().isPlaying())
				adventures.getMusicaNivel().stop();
			if(!adventures.getMusicaMenu().isPlaying())
				adventures.getMusicaMenu().play();
		}
		
		if(Gdx.app.getType() == ApplicationType.Android) {
			adventures.getCamera().update();
			batch.setProjectionMatrix(adventures.getCamera().combined);
		}
		
		for(Boton boton : botonesPrincipales)
			boton.update();
		for(Boton boton : botonesModoHistoria)
			boton.update();
		for(Boton boton : botonesOpciones)
			boton.update();
		
		batch.begin();
		batch.draw(adventures.getManager().get("Pantallas/FondoMenu.png", Texture.class), 0, altura, ancho, alto);
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
	public void show() {
		
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
