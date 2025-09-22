package co.edu.udistrital.model;

import java.util.Random;


public class GeneradorPastores {

	private Random rnd;
	private final int CANTIDAD_LIMITE_INFERIOR = 1;
	private final int CANTIDAD_LIMITE_SUPERIOR = 150;
	
	public GeneradorPastores() {

		this.rnd = new Random();

	}
	
	public Pastor generar(String nombre) {

		String oficio = Datos.OFICIOS[rnd.nextInt(Datos.OFICIOS.length)];

		int dinero = rnd.nextInt(
			CANTIDAD_LIMITE_INFERIOR,
			CANTIDAD_LIMITE_SUPERIOR + 1
		);

		int feligreces = rnd.nextInt(
			CANTIDAD_LIMITE_INFERIOR,
			CANTIDAD_LIMITE_SUPERIOR + 1
		);

		return new Pastor(nombre, oficio, dinero , feligreces);
	}
	
	
	
	
}
