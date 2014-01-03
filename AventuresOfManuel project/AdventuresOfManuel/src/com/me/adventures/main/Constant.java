package com.me.adventures.main;

public final class Constant {
	private static final Constant constantes = new Constant();
	public static final float SPEED = 210; //58
	public static final float BOLA_SPEED = 300;
    public static final int ANCHURA_PERSONAJE = 58, ANCHURA_OBJETO = 58;
    public static final int ALTURA_PERSONAJE = 58, ALTURA_OBJETO = 58;
    public static final int ANCHURA_PANTALLA = 1024, ALTURA_PANTALLA = 754;
    public static final int ANCHURA_ESCENARIO = 754, ALTURA_ESCENARIO = 754;
    		
	public static Constant getConstant() {
		return constantes;
	}
}
