package com.me.adventures.characters;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.Constant;

public class Manuel extends PersonajeDelJuego {
	//Constantes locales
	private static final int ABAJO = 0;
	private static final int IZQUIERDA = 1;
	private static final int DERECHA = 2;
	private static final int ARRIBA = 3;
	private static final int SPRITE_QUIETO = 2;
    
	// Atributos básicos
	private BitmapFont font;
	private Vector2 posicion;
	private Rectangle bordes;
	private float stateTime;
	private int direccion;
	private Colision colisiones;
	private int corazonesObtenidos;
	private List<Proyectil> proyectiles;
	private boolean disparando;

	//Atributos para pintar a Manuel
	private Texture TexturaManuel;
	private TextureRegion [][] manuelMatrizFrames;
	private TextureRegion frameActual;
	private Animation manuelAnimationAbajo, manuelAnimationIzquierda, manuelAnimationDerecha, manuelAnimationArriba;
	
	public Manuel(Vector2 posicion) {
		this.font = new BitmapFont(Gdx.files.internal("arial.fnt"), Gdx.files.internal("arial.png"), false);
		this.corazonesObtenidos = 0;
		//proyectiles = new ArrayList<Proyectil>();
		this.posicion = posicion;
		bordes = new Rectangle(posicion.x, posicion.y, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		stateTime = 0f;
		direccion = ABAJO;
		
		TexturaManuel = new Texture("Manolito/TablaSpritesManolitoTransparencia.png");
		manuelMatrizFrames = TextureRegion.split(TexturaManuel, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		
		// Asignamos las animaciones de las direcciones de Manuel
		manuelAnimationAbajo = new Animation(0.05f, manuelMatrizFrames[ABAJO]);
		manuelAnimationIzquierda = new Animation(0.05f, manuelMatrizFrames[IZQUIERDA]);
		manuelAnimationDerecha= new Animation(0.05f, manuelMatrizFrames[DERECHA]);
		manuelAnimationArriba = new Animation(0.05f, manuelMatrizFrames[ARRIBA]);
		
		disparando = false;
		proyectiles = new ArrayList<Proyectil>();
	}
	
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(frameActual, posicion.x, posicion.y, bordes.height, bordes.width);
		if(disparando)
			proyectiles.get(0).draw(batch);
		batch.draw(new Texture("Miscelanea/Roca.png"), 930, 522);
		if(proyectiles.isEmpty())
			font.draw(batch, "0", 947, 500);
		else if(proyectiles.size() == 1)
			font.draw(batch, "1", 947, 500);
		else if(proyectiles.size() == 2)
			font.draw(batch, "2", 947, 500);
		else if(proyectiles.size() == 3)
			font.draw(batch, "3", 947, 500);
		else if(proyectiles.size() == 4)
			font.draw(batch, "4", 947, 500);
		else if(proyectiles.size() == 5)
			font.draw(batch, "5", 947, 500);
	}
	
	@Override
	public void update() {
		// Determina movimiento de Manuel
		boolean soloUnaTeclaPresionada = true;
		boolean manuelSeQuedaQuieto = false;
		boolean colisionDerecha = colisiones.colisionDerechaObjeto(this) || colisiones.colisionDerechaEnemigo(this);
		boolean colisionIzquierda = colisiones.colisionIzquierdaObjeto(this) || colisiones.colisionIzquierdaEnemigo(this);
		boolean colisionArriba = colisiones.colisionArribaObjeto(this) || colisiones.colisionArribaEnemigo(this);
		boolean colisionAbajo = colisiones.colisionAbajoObjeto(this) || colisiones.colisionAbajoEnemigo(this);
		
		if(Gdx.input.isKeyPressed(Keys.RIGHT) && soloUnaTeclaPresionada && !colisionDerecha) {
			soloUnaTeclaPresionada = false;
			posicion.x = posicion.x + Gdx.graphics.getDeltaTime() * Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccion = DERECHA;
		}
		else if(Gdx.input.isKeyPressed(Keys.LEFT) && soloUnaTeclaPresionada && !colisionIzquierda) {
			soloUnaTeclaPresionada = false;
			posicion.x = posicion.x - Gdx.graphics.getDeltaTime() * Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccion = IZQUIERDA;
		}
		else if(Gdx.input.isKeyPressed(Keys.UP) && soloUnaTeclaPresionada && !colisionArriba) {
			soloUnaTeclaPresionada = false;
			posicion.y = posicion.y + Gdx.graphics.getDeltaTime() * Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccion = ARRIBA;
		}
		else if(Gdx.input.isKeyPressed(Keys.DOWN) && soloUnaTeclaPresionada && !colisionAbajo) {
			soloUnaTeclaPresionada = false;
			posicion.y = posicion.y - Gdx.graphics.getDeltaTime() * Constant.SPEED;
			stateTime = stateTime + Gdx.graphics.getDeltaTime();
			direccion = ABAJO;
		}
		else
			manuelSeQuedaQuieto = true;
		
		colisiones.colisionCorazon(this);
		colisiones.colisionCofre(this);
		
		//Direccion frame Manuel
		if(direccion == ABAJO) {
			if(manuelSeQuedaQuieto) {
				int nuevaPosicion = (int) posicion.y;
				while(nuevaPosicion % 29 != 0) // Ajusta la posición
					nuevaPosicion--;
				posicion.y = nuevaPosicion;
				frameActual = manuelMatrizFrames[direccion][SPRITE_QUIETO];
			}
			else 
				frameActual = manuelAnimationAbajo.getKeyFrame(stateTime, true);
		}
		else if(direccion == IZQUIERDA) {
			if(manuelSeQuedaQuieto) {
				int nuevaPosicion = (int) posicion.x;
				while(nuevaPosicion % 29 != 19) // Ajusta la posición
					nuevaPosicion--;
				posicion.x = nuevaPosicion;
				frameActual = manuelMatrizFrames[direccion][SPRITE_QUIETO];
			}
			else 
				frameActual = manuelAnimationIzquierda.getKeyFrame(stateTime, true);
		}
		else if(direccion == DERECHA) {
			if(manuelSeQuedaQuieto) {
				int nuevaPosicion = (int) posicion.x;
				while(nuevaPosicion % 29 != 19) // Ajusta la posición
					nuevaPosicion++;
				posicion.x = nuevaPosicion;
				frameActual = manuelMatrizFrames[direccion][SPRITE_QUIETO];
			}
			else 
				frameActual = manuelAnimationDerecha.getKeyFrame(stateTime, true);
		}
		else if(direccion == ARRIBA) {
			if(manuelSeQuedaQuieto) {
				int nuevaPosicion = (int) posicion.y;
				while(nuevaPosicion % 29 != 0) // Ajusta la posición
					nuevaPosicion++;
				posicion.y = nuevaPosicion;
				frameActual = manuelMatrizFrames[direccion][SPRITE_QUIETO];
			}
			else 
				frameActual = manuelAnimationArriba.getKeyFrame(stateTime, true);
		}
		
		if(colisionDerecha || colisionIzquierda || colisionArriba || colisionAbajo) {
			detectaColisionInminente();
		}
		
		activarAtaque();
		if(disparando) {
			if(colisiones.colisionDisparoEnemigo(proyectiles.get(0)))
				eliminandoDisparo();
			else if(colisiones.colisionDisparoObjeto(proyectiles.get(0)))
				eliminandoDisparo();
			else
				proyectiles.get(0).update();
		}
		
		// Actualizar bordes
		bordes.x = posicion.x;
		bordes.y = posicion.y;
	}
	
	private void detectaColisionInminente() {
		if(colisiones.colisionObjetoEnemigo(this)) {
			if(direccion == DERECHA)
				posicion.x -= 29;
			if(direccion == IZQUIERDA)
				posicion.x += 29;
			if(direccion == ARRIBA)
				posicion.y -= 29;
			if(direccion == ABAJO)
				posicion.y += 29;
		}
	}
	
	@Override
	public void activarAtaque() {
		if(!proyectiles.isEmpty() && !disparando && Gdx.input.isKeyPressed(Keys.SPACE)){
			//tenemos que pasarle la posicion siguiente a donde este manolito, dependiendo de la direccion
			proyectiles.get(0).inicializaPosicion(posicion, direccion);
			disparando = true;
		}
	}
	private void eliminandoDisparo() {
		disparando = false;
		proyectiles.remove(0);
	}
	
	@Override
	public void convertirEnBola() {
		// TODO Auto-generated method stub
	}
	
	// Getters and Setters ------------------------------------------------------------------------
	@Override
	public boolean estaEnBola() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getCorazonesObtenidos() {
		return corazonesObtenidos;
	}
	
	public void obtenerCorazon(){
		corazonesObtenidos++;
	}
	
	public void obtenerProyectil(int proyectilesOtorgados){
		for(int i = 0; i < proyectilesOtorgados; i++)
			proyectiles.add(new Proyectil());
	}
	
	public void setColision(Colision colisiones) {
		this.colisiones = colisiones;
	}
	
	@Override
	public Vector2 getPosicion() {
		return posicion;
	}

	public void setPosicion(Vector2 posicion) {
		this.posicion = posicion;
	}

	@Override
	public Rectangle getBordes() {
		return bordes;
	}

	public void setBordes(Rectangle bordes) {
		this.bordes = bordes;
	}
	
	public float getStateTime() {
		return stateTime;
	}
}
