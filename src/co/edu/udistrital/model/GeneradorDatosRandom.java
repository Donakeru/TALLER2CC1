package co.edu.udistrital.model;

import java.util.Random;


public class GeneradorDatosRandom {
	
	private String[] listaOficios;
	private Datos oficios = new Datos();
	
	public GeneradorDatosRandom() {
		this.listaOficios = oficios.getOFICIOS();
	}
	
	public Pastor[] generarDatos(int n, int m, Random rnd) {
		Pastor[] pastores = new Pastor[n];
		for (int i = 0; i < n; i++) {
			int dinero = rnd.nextInt(1, m + 1);     
			int seguidores = rnd.nextInt(1, m + 1);  



			String oficio = listaOficios[rnd.nextInt(listaOficios.length)];

			pastores[i] = new Pastor(oficio, dinero , seguidores);
		}
		return pastores;
	}
	
	
	
	
}
