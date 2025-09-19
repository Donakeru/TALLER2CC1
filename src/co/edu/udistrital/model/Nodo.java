package co.edu.udistrital.model;

public class Nodo {
    private Pastor pastor;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Pastor pastor) {
        this(pastor, null, null);
    }

    public Nodo(Pastor pastor, Nodo siguiente, Nodo anterior) {
        this.pastor = pastor;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    // Getters y Setters
    public Pastor getPastor() {
        return pastor;
    }

    public void setPastor(Pastor pastor) {
        this.pastor = pastor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return pastor.toString();
    }
}
