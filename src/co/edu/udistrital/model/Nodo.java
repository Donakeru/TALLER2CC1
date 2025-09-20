package co.edu.udistrital.model;

import java.util.Objects;

public class Nodo {
    
    private Pastor pastor;
    private Nodo siguiente;
    private Nodo anterior;

    /**
     * Construye un nodo doblemente enlazado con el Pastor
     * Las soguientes referencias (siguiente y anterior)
     * empiezan en null
     *
     * @param pastor El dato a almacenar.
     */
    public Nodo(Pastor pastor) {
        this(pastor, null, null);
    }

    /**
     * Construye un nodo doblemente enlazado
     * con el pastor y las referencias
     * anterior y siguiente especificadas.
     *
     * @param pastor El dato a almacenar.
     * @param anterior El nodo que precede a este nodo.
     * @param siguiente El nodo que sucede a este nodo.
     */
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
        return Objects.toString(pastor, "null");
    }
}
