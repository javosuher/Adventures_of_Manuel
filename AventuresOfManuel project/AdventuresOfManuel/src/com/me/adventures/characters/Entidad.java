package com.me.adventures.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract interface Entidad {
	public abstract void draw(SpriteBatch batch);
	public abstract void update();
	public abstract Vector2 getPosicion();
	public abstract Rectangle getBordes();
}
