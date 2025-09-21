package co.edu.udistrital.model;

public class Pastor {
	
	private String oficio;
	private int dinero;
	private int feligreces;
	
	public Pastor(String oficio, int dinero, int feligreces) {
		this.oficio = oficio;
		this.dinero = dinero;
		this.feligreces = feligreces;
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
		try {
			if (dinero >= 0) {
				this.dinero = dinero;
			} else {
				throw new Exception("No puede haber dinero negativo");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getFeligreces() {
		return feligreces;
	}

	public void setFeligreces(int feligreces) {
		try {
			if (feligreces >= 0) {
				this.feligreces = feligreces;
			} else {
				throw new Exception("No puede haber una cantidad de feligreces negativos");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void adicionarDinero(int dinero) {
		this.dinero+=dinero;
	}

	public void adicionarFeligreces(int feligreces) {
		this.feligreces+=feligreces;
	}

	@Override
	public String toString() {
		return "Pastor [oficio=" + oficio + ", dinero=" + dinero + ", feligreces=" + feligreces + "]";
	}

}
