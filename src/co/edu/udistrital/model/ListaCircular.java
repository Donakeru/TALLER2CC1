package co.edu.udistrital.model;

public class ListaCircular {
    private Nodo cabeza;

    public void agregar(Pastor p) {
        Nodo nuevo = new Nodo(p);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            Nodo ultimo = cabeza.getAnterior();
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
        }
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

    public Nodo getCabeza() {
        return cabeza;
    }
}
