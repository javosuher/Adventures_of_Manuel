package com.me.adventures.main;

public final class Constant {
	private static final Constant constantes = new Constant();
	public static final double SPEED = 3.625; //29; //220; //58
	public static final float BOLA_SPEED = 10;
	public static final int TIEMPO_AGUA = 10;
	public static final int TIEMPO_BOLA = 800;
	public static final int TIEMPO_BOLA_CAMBIO = 400;
	public static final int TIEMPO_PROYECTIL = 50;
	public static final int TIEMPO_DESAPARECIDO = 800;
	public static final int TIEMPO_MOVIMIENTO = 15;
    public static final int ANCHURA_PERSONAJE = 58, ANCHURA_OBJETO = 58;
    public static final int ALTURA_PERSONAJE = 58, ALTURA_OBJETO = 58;
    public static final int ANCHURA_PANTALLA = 1024, ALTURA_PANTALLA = 754;
    public static final int ANCHURA_ESCENARIO = 754, ALTURA_ESCENARIO = 754;
    public static final int PUENTE_VERTICAL = 0, PUENTE_HORIZONTAL = 1;
    public static final int PUERTA = 0, ESCALERA = 1;
    		
	public static Constant getConstant() {
		return constantes;
	}
}
