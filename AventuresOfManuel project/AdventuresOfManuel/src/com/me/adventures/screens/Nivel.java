package com.me.adventures.screens;

import com.me.adventures.main.AdventuresOfManuel;

public abstract class Nivel extends AbstractScreen {
	public Nivel(AdventuresOfManuel adventures) {
		super(adventures);
	}
	
	protected abstract void objetosDelNivel();
	protected abstract void personajesDelNivel();
}
