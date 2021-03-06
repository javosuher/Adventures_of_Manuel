package com.me.adventures.characters;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.me.adventures.main.AdventuresOfManuel;
import com.me.adventures.main.Constant;

public class Manuel extends PersonajeDelJuego {
	//Constantes locales
	public static final int ABAJO = 0;
	public static final int IZQUIERDA = 1;
	public static final int DERECHA = 2;
	public static final int ARRIBA = 3;
	public static final int SPRITE_QUIETO = 2;
    
	// Atributos básicos
	private BitmapFont font;
	private int corazonesObtenidos;
	private List<Proyectil> proyectiles;
	private boolean disparando;
	boolean manuelSeQuedaQuieto;
	private int tiempoParaSiguienteProyectil; // Para que no se disparen dos a la vez
	private Sound sonidoDisparo;

	//Atributos para pintar a Manuel
	private TextureRegion [][] manuelMatrizFrames;
	private Animation manuelAnimationAbajo, manuelAnimationIzquierda, manuelAnimationDerecha, manuelAnimationArriba;
	
	public Manuel(AdventuresOfManuel adventures, Vector2 posicion) {
		super(adventures, posicion);
		
		Textura = adventures.getManager().get("Manolito/TablaSpritesManolitoTransparencia.png", Texture.class);
		manuelMatrizFrames = TextureRegion.split(Textura, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE);
		
		// Asignamos las animaciones de las direcciones de Manuel
		manuelAnimationAbajo = new Animation(0.05f, manuelMatrizFrames[ABAJO]);
		manuelAnimationIzquierda = new Animation(0.05f, manuelMatrizFrames[IZQUIERDA]);
		manuelAnimationDerecha= new Animation(0.05f, manuelMatrizFrames[DERECHA]);
		manuelAnimationArriba = new Animation(0.05f, manuelMatrizFrames[ARRIBA]);
		
		disparando = false;
		this.font = new BitmapFont(Gdx.files.internal("arial.fnt"), Gdx.files.internal("arial.png"), false);
		this.corazonesObtenidos = 0;
		direccion = ABAJO;
		proyectiles = new ArrayList<Proyectil>();
		tiempoParaSiguienteProyectil = 0;
		sonidoDisparo = adventures.getManager().get("Musica/DisparoManolito.mp3", Sound.class);
	}
	
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(frameActual, posicion.x, posicion.y, bordes.height, bordes.width);
		if(disparando)
			proyectiles.get(0).draw(batch);
		
		batch.draw(new TextureRegion(new Texture("Miscelanea/ProyectilManolito.png"), 58, 0, Constant.ANCHURA_PERSONAJE, Constant.ALTURA_PERSONAJE), 930, 522);
		String numeroProyectiles = Integer.toString(proyectiles.size()); // Mostrar numero de proyectiles
		font.draw(batch, numeroProyectiles, 947, 500);
	}
	
	@Override
	public void update() {
		// Determina movimiento de Manuel
		boolean soloUnaTeclaPresionada = true;
		manuelSeQuedaQuieto = false;
		boolean colisionDerecha = colisiones.colisionDerechaObjeto(this) || colisiones.colisionDerechaEnemigo(this) || colisiones.colisionMovibleDerecha(this);
		boolean colisionIzquierda = colisiones.colisionIzquierdaObjeto(this) || colisiones.colisionIzquierdaEnemigo(this) || colisiones.colisionMovibleIzquierda(this);
		boolean colisionArriba = colisiones.colisionArribaObjeto(this) || colisiones.colisionArribaEnemigo(this) || colisiones.colisionMovibleArriba(this);
		boolean colisionAbajo = colisiones.colisionAbajoObjeto(this) || colisiones.colisionAbajoEnemigo(this) || colisiones.colisionMovibleAbajo(this);
		
		if(Gdx.app.getType() == ApplicationType.Desktop)
			moverDesktop(soloUnaTeclaPresionada, colisionDerecha, colisionIzquierda, colisionArriba, colisionAbajo);
		else if(Gdx.app.getType() == ApplicationType.Android)
			moverAndroid(soloUnaTeclaPresionada, colisionDerecha, colisionIzquierda, colisionArriba, colisionAbajo);
		
		colisiones.colisionCorazon(this);
		colisiones.colisionCofre(this);
		
		ajustarManuel(colisionDerecha, colisionIzquierda, colisionArriba, colisionAbajo);
		
		activarAtaque();
		if(disparando) {
			if(colisiones.colisionDisparoEnemigo(proyectiles.get(0)))
				eliminandoDisparo();
			else if(colisiones.colisionDisparoObjeto(proyectiles.get(0)))
				eliminandoDisparo();
			else
				proyectiles.get(0).update();
		}
		if(tiempoParaSiguienteProyectil > 0) // Decrementa tiempo misil
			tiempoParaSiguienteProyectil--;
		
		// Actualizar bordes
		bordes.x = posicion.x;
		bordes.y = posicion.y;
	}
	
	@Override
	public void activarAtaque() {
		if(!proyectiles.isEmpty() && !disparando && teclaDeDisparo() && tiempoParaSiguienteProyectil == 0){
			tiempoParaSiguienteProyectil = Constant.TIEMPO_PROYECTIL;
			//tenemos que pasarle la posicion siguiente a donde este manolito, dependiendo de la direccion
			proyectiles.get(0).inicializaPosicion(posicion, direccion);
			disparando = true;
			if(adventures.isSonidoActivado())
				sonidoDisparo.play();
		}
	}
	private boolean teclaDeDisparo() {
		if(Gdx.app.getType() == ApplicationType.Desktop)
			return Gdx.input.isKeyPressed(Keys.SPACE);
		else if(Gdx.app.getType() == ApplicationType.Android)
			return Gdx.input.isTouched() && Gdx.input.getX() < (Gdx.graphics.getWidth() / 2) + 150 && Gdx.input.getX() > (Gdx.graphics.getWidth() / 2) - 150 && Gdx.input.getY() < (Gdx.graphics.getHeight() / 2) + 150 && Gdx.input.getY() > (Gdx.graphics.getHeight() / 2) - 150;
		else return false;
	}
	private void eliminandoDisparo() {
		disparando = false;
		proyectiles.remove(0);
	}
	
	private void moverDesktop(boolean soloUnaTeclaPresionada, boolean colisionDerecha, boolean colisionIzquierda, boolean colisionArriba, boolean colisionAbajo) {
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			if(soloUnaTeclaPresionada && !colisionDerecha) {
				//posicion.x = posicion.x + Constant.SPEED;
				posicion.x = (float) (posicion.x + Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
			}
			soloUnaTeclaPresionada = false;
			direccion = DERECHA;
		}
		else if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			if(soloUnaTeclaPresionada && !colisionIzquierda) {
				//posicion.x = posicion.x - Constant.SPEED;
				posicion.x = (float) (posicion.x - Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
			}
			soloUnaTeclaPresionada = false;
			direccion = IZQUIERDA;
		}
		else if(Gdx.input.isKeyPressed(Keys.UP)) {
			if(soloUnaTeclaPresionada && !colisionArriba) {
				//posicion.y = posicion.y + Constant.SPEED;
				posicion.y = (float) (posicion.y + Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
			}
			soloUnaTeclaPresionada = false;
			direccion = ARRIBA;
		}
		else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			if(soloUnaTeclaPresionada && !colisionAbajo) {
				//posicion.y = posicion.y - Constant.SPEED;
				posicion.y = (float) (posicion.y - Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
			}
			soloUnaTeclaPresionada = false;
			direccion = ABAJO;
		}
		else
		manuelSeQuedaQuieto = true;
	}
	
	private void moverAndroid(boolean soloUnaTeclaPresionada, boolean colisionDerecha, boolean colisionIzquierda, boolean colisionArriba, boolean colisionAbajo) {
		if(Gdx.input.isTouched() && Gdx.input.getX() > Gdx.graphics.getWidth() - 70) {
			if(soloUnaTeclaPresionada && !colisionDerecha) {
				posicion.x = (float) (posicion.x + Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
			}
			soloUnaTeclaPresionada = false;
			direccion = DERECHA;
		}
		else if(Gdx.input.isTouched() && Gdx.input.getX() < 70) {
			if(soloUnaTeclaPresionada && !colisionIzquierda) {
				posicion.x = (float) (posicion.x - Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
			}
			soloUnaTeclaPresionada = false;
			direccion = IZQUIERDA;
		}
		else if(Gdx.input.isTouched() && Gdx.input.getY() < 70) {
			if(soloUnaTeclaPresionada && !colisionArriba) {
				posicion.y = (float) (posicion.y + Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
			}
			soloUnaTeclaPresionada = false;
			direccion = ARRIBA;
		}
		else if(Gdx.input.isTouched() && Gdx.input.getY() > Gdx.graphics.getHeight() - 70) {
			if(soloUnaTeclaPresionada && !colisionAbajo) {
				posicion.y = (float) (posicion.y - Constant.SPEED);
				stateTime = stateTime + Gdx.graphics.getDeltaTime();
			}
			soloUnaTeclaPresionada = false;
			direccion = ABAJO;
		}
		else
			manuelSeQuedaQuieto = true;
	}
	
	public void ajustarManuel(boolean colisionDerecha, boolean colisionIzquierda, boolean colisionArriba, boolean colisionAbajo) {
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
	}
	
	private void detectaColisionInminente() {
		if(colisiones.colisionObjetoEnemigoMovible(this)) {
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
	
	// Getters and Setters ------------------------------------------------------------------------
	public int getCorazonesObtenidos() {
		return corazonesObtenidos;
	}
	
	public void obtenerCorazon(){
		corazonesObtenidos++;
	}
	
	public void obtenerProyectil(int proyectilesOtorgados){
		for(int i = 0; i < proyectilesOtorgados; i++)
			proyectiles.add(new ProyectilManuel(adventures, new Vector2()));
	}
}
