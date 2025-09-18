package co.edu.udistrital.model;

public class Pastor {
	
	private String oficio;
	private int dinero;
	private int seguidores;
	
	public Pastor(String oficio, int dinero, int seguidores) {
		this.oficio = oficio;
		this.dinero = dinero;
		this.seguidores = dinero;
	}
	
	
	
	

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(int seguidores) {
		this.seguidores = seguidores;
	}
	
	
	

	
	
	

}
