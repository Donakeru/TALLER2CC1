package co.edu.udistrital.controller;

import java.util.Random;

import javax.swing.JOptionPane;

import co.edu.udistrital.model.*;
import co.edu.udistrital.view.MainView;

public class Controller {
	private MainView view;
	private GeneradorDatosRandom generador;
	private ListaCircular listaPastores;

	public Controller(MainView view) {
		this.view = view;
		this.generador = new GeneradorDatosRandom();
		this.listaPastores = new ListaCircular();

		initController();
	}

	private void initController() {
		view.getBtnGenerarButton().addActionListener(e -> generarPastores());
		view.getBtnEmpezarButton().addActionListener(e -> empezarJuego());
	}

	private void generarPastores() {
		try {
			int n = Integer.parseInt(view.getTextField().getText());
			Random ran = new Random();

			Pastor[] pastores = generador.generarDatos(n, 100, ran);

			listaPastores = new ListaCircular();
			for (Pastor p : pastores) {
				listaPastores.agregar(p);
			}

			System.out.println("Lista circular generada:");
			listaPastores.mostrar();

			view.getDrawPanel().setPartes(n);
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
						+ mejorPastor.getDinero() + "\n" + "Seguidores: " + mejorPastor.getSeguidores());

	}
}
