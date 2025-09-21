package co.edu.udistrital.controller;

import javax.swing.JOptionPane;
import co.edu.udistrital.model.*;
import co.edu.udistrital.view.MainView;

public class Controller {

    private MainView view;
    private GeneradorPastores generador;
    private ListaCircular listaPastores;

    public Controller(MainView view) {
        this.view = view;
        this.generador = new GeneradorPastores();
        this.listaPastores = new ListaCircular();
        initController();
    }

    private void initController() {
        view.getBtnGenerarButton().addActionListener(e -> generarPastores());
        view.getBtnEmpezarButton().addActionListener(e -> empezarJuego());
    }

    private void generarPastores() {
        try {
            listaPastores = new ListaCircular();
            int cantidadPastores = Integer.parseInt(view.getTextField().getText());

            for (int i = 0; i < cantidadPastores; i++) {
                listaPastores.agregar(this.generador.generar());
            }

            System.out.println("Lista circular generada:");
            listaPastores.mostrar();

            view.getDrawPanel().setPartes(cantidadPastores);
            view.getDrawPanel().colocarPastores(listaPastores);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view.getFrame(), "Ingresa un número válido");
        }
    }

    private Nodo buscarNodoConPastorMasRico() {
        Nodo actual = listaPastores.getCabeza();
        Nodo mejorNodo = actual;
        actual = actual.getSiguiente();

        while (actual != listaPastores.getCabeza()) {
            if (actual.getPastor().getDinero() > mejorNodo.getPastor().getDinero()) {
                mejorNodo = actual;
            }
            actual = actual.getSiguiente();
        }
        return mejorNodo;
    }

    private Nodo buscarNodoConPastorConMenosFeligreces(Nodo nodo) {
        if (nodo == null || listaPastores.getTamanno() <= 1) {
            return null; // no hay vecinos válidos
        }

        Pastor pastorEnTurno = nodo.getPastor();
        boolean sentidoHorario = isPar(pastorEnTurno.getDinero());
        int cantidadVecinos = pastorEnTurno.getDinero() % listaPastores.getTamanno();

        JOptionPane.showMessageDialog(
            view.getFrame(),
            "Se evaluaron en sentido: " + (sentidoHorario ? "horario " : "antihorario ")
            + cantidadVecinos + " vecinos"
        );

        Nodo actual = sentidoHorario ? nodo.getSiguiente() : nodo.getAnterior();
        Nodo menosFeligreses = actual;

        for (int i = 1; i < cantidadVecinos; i++) {
            actual = sentidoHorario ? actual.getSiguiente() : actual.getAnterior();
            if (actual != nodo &&
                actual.getPastor().getFeligreces() < menosFeligreses.getPastor().getFeligreces()) {
                menosFeligreses = actual;
            }
        }
        return menosFeligreses;
    }

    private boolean isPar(int num) {
        return num % 2 == 0;
    }

    private void empezarJuego() {
        if (listaPastores == null || listaPastores.getCabeza() == null) {
            JOptionPane.showMessageDialog(view.getFrame(), "No hay pastores en la lista");
            return;
        }

        Nodo nodoMasRico = buscarNodoConPastorMasRico();
        Pastor pastorMasRico = nodoMasRico.getPastor();

        Nodo nodoMenosFeligreses = buscarNodoConPastorConMenosFeligreces(nodoMasRico);
        Pastor pastorMenosFeligreses = nodoMenosFeligreses.getPastor();

        JOptionPane.showMessageDialog(
            view.getFrame(),
            "El pastor con más dinero es:\n" +
            "Oficio: " + pastorMasRico.getOficio() + "\n" +
            "Dinero: " + pastorMasRico.getDinero() + "\n" +
            "Feligreces: " + pastorMasRico.getFeligreces()
        );

        JOptionPane.showMessageDialog(
            view.getFrame(),
            "El pastor vecino con menos feligreses:\n" +
            "Oficio: " + pastorMenosFeligreses.getOficio() + "\n" +
            "Dinero: " + pastorMenosFeligreses.getDinero() + "\n" +
            "Feligreces: " + pastorMenosFeligreses.getFeligreces()
        );

		// transferir recursos
		pastorMasRico.adicionarDinero(pastorMenosFeligreses.getDinero());
		pastorMasRico.adicionarFeligreces(pastorMenosFeligreses.getFeligreces());
		pastorMenosFeligreses.setDinero(0);
		pastorMenosFeligreses.setFeligreces(0);

		// eliminar
        listaPastores.eliminar(nodoMenosFeligreses);

        view.getDrawPanel().setPartes(listaPastores.getTamanno());
        view.getDrawPanel().colocarPastores(listaPastores);
    }
}
