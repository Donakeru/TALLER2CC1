package co.edu.udistrital.model;

public class ListaCircular {
    
    private Nodo cabeza;
    private int tamanno;

    public ListaCircular() {
        this.cabeza = null;
        this.tamanno = 0;
    }

    // Información básico y acceso interno

    public Nodo getCabeza() {
        return estaVacia() ? null : this.cabeza;
    }

    public int getTamanno() {
        return tamanno;
    }

    public boolean estaVacia() {
        return tamanno == 0;
    }

    // Metodos de inserción / eliminación de datos

    public void agregar(Pastor p) {
        Nodo nuevo = new Nodo(p);
        if (this.cabeza == null) {
            this.cabeza = nuevo;
            this.cabeza.setSiguiente(cabeza);
            this.cabeza.setAnterior(cabeza);
        } else {
            Nodo ultimo = cabeza.getAnterior();
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
        }
        this.tamanno++;
    }

    public void eliminar(Nodo nodo) {
        if (nodo.getSiguiente() == nodo) { 
            cabeza = null;
        } else {
            nodo.getAnterior().setSiguiente(nodo.getSiguiente());
            nodo.getSiguiente().setAnterior(nodo.getAnterior());
            if (nodo == cabeza) {
                cabeza = nodo.getSiguiente();
            }
        }
        this.tamanno--;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La mesa está vacía.");
            return;
        }
        Nodo temp = cabeza;
        do {
            System.out.println(temp.getPastor());
            temp = temp.getSiguiente();
        } while (temp != cabeza);
    }

}
