package co.edu.udistrital.model;

import java.util.Random;


public class GeneradorDatosRandom {
	
	private String[] listaOficios;
	private ListaDatos oficios;
	
	public GeneradorDatosRandom() {
		listaOficios = oficios.getOFICIOS();
	}
	
	private Pastor[] generarDatos(int n, int m, Random rnd) {
		Pastor[] pastores = new Pastor[n];
		for (int i = 0; i < n; i++) {
			int dinero = 1 + rnd.nextInt(i, m);
			int seguidores = 1 + rnd.nextInt(1,m);


			String oficio = listaOficios[rnd.nextInt(listaOficios.length)];

			pastores[i] = new Pastor(oficio, dinero , seguidores);
		}
		return pastores;
	}
	
	
	
	
}
