package co.edu.udistrital.model;

import java.util.Random;


public class GeneradorPastores {

	private Random rnd;
	private final int CANTIDAD_LIMITE_INFERIOR = 1;
	private final int CANTIDAD_LIMITE_SUPERIOR = 100;
	
	public GeneradorPastores() {

		this.rnd = new Random();

	}
	
	public Pastor generar() {

		String oficio = Datos.OFICIOS[rnd.nextInt(Datos.OFICIOS.length)];

		int dinero = rnd.nextInt(
			CANTIDAD_LIMITE_INFERIOR,
			CANTIDAD_LIMITE_SUPERIOR + 1
		);

		int feligreces = rnd.nextInt(
			CANTIDAD_LIMITE_INFERIOR,
			CANTIDAD_LIMITE_SUPERIOR + 1
		);

		return new Pastor(oficio, dinero , feligreces);
	}
	
	
	
	
}
