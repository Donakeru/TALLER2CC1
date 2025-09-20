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

	private void empezarJuego() {
		if (listaPastores == null || listaPastores.getCabeza() == null) {
			JOptionPane.showMessageDialog(view.getFrame(), "No hay pastores en la lista");
			return;
		}

		Nodo actual = listaPastores.getCabeza();
		Nodo mejorNodo = actual; //el que tiene más dinero
		actual = actual.getSiguiente();

		while (actual != listaPastores.getCabeza()) {
			if (actual.getPastor().getDinero() > mejorNodo.getPastor().getDinero()) {
				mejorNodo = actual;
			}
			actual = actual.getSiguiente();
		}

		Pastor mejorPastor = mejorNodo.getPastor();

		JOptionPane.showMessageDialog(view.getFrame(), // esto se cambiará a que al empezar el pastor se marque en el
														// circulo, para poder verlo mejor
				"El pastor con más dinero es:\n" + "Oficio: " + mejorPastor.getOficio() + "\n" + "Dinero: "
						+ mejorPastor.getDinero() + "\n" + "Feligreces: " + mejorPastor.getFeligreces());

	}
}
