package co.edu.udistrital.model;

public class PilaDesposeidos {
    
    private Nodo cabeza;

    public PilaDesposeidos() {
        this.cabeza = null;
    }

    public void insertar(Pastor pastor) {
        Nodo nuevoNodo = new Nodo(pastor, null, null);

        if (this.cabeza == null) {
            this.cabeza = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(this.cabeza);
            this.cabeza = nuevoNodo;
        }
    }

    public Pastor retirar() {
        
        if (this.cabeza == null) return null;

        Pastor pastor = this.cabeza.getPastor();

        return pastor;

    }

}
