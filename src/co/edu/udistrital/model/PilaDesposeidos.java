package co.edu.udistrital.model;

public class PilaDesposeidos {
    
    private Nodo cabeza;
    private int tamanno;

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
        this.tamanno++;
    }

    public Pastor retirar() {
        
        if (this.cabeza == null) return null;

        Pastor pastor = this.cabeza.getPastor();
        this.cabeza = this.cabeza.getSiguiente(); //mueve el tope de la pila
        this.tamanno--;
        return pastor;
    }
    
    public Boolean estaVacia() {
    	return this.tamanno == 0;
    }
    
    
}
