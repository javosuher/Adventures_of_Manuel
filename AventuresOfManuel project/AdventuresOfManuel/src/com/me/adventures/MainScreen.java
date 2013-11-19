package com.me.adventures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MainScreen implements Screen {
	private static final int        FRAME_COLS = 5;
    private static final int        FRAME_ROWS = 4;
    private float stateTime;
    
	private AdventuresOfManuel adventuras_del_manuel;
	private Texture TexturaFondo, TexturaManuel;
	private TextureRegion[] ManuelFrames;
	private TextureRegion frameActual;
	private Animation ManuelAnimation;
	private SpriteBatch batch;
	private Manuel manuel;
	

	public MainScreen(AdventuresOfManuel adventuras_del_manuel) {
		this.adventuras_del_manuel = adventuras_del_manuel;
		TexturaFondo = new Texture("data/TexturaFondo.png");
		TexturaFondo.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TexturaManuel = new Texture("data/SpritesManolito.png");
		TextureRegion[][] tmp = TextureRegion.split(TexturaManuel, TexturaManuel.getWidth() / FRAME_COLS / 2, TexturaManuel.getHeight() / FRAME_ROWS);
		ManuelFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
                for (int j = 0; j < FRAME_COLS; j++) {
                        ManuelFrames[index++] = tmp[i][j];
                }
        }
        ManuelAnimation = new Animation(0.025f, ManuelFrames);
		TexturaManuel.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		manuel = new Manuel(new Vector2(10,10), TexturaManuel.getWidth() / 3, TexturaManuel.getHeight() / 3);
		batch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		stateTime += manuel.getStateTime();
		frameActual = ManuelAnimation.getKeyFrame(stateTime, true);
		
		manuel.update();
		batch.begin();
		batch.draw(TexturaFondo, 0, 0, TexturaFondo.getWidth(), TexturaFondo.getHeight());
		batch.draw(frameActual, manuel.getPosicion().x, manuel.getPosicion().y, manuel.getAnchura(), manuel.getAltura());
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
