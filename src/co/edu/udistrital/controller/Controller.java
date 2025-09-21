package co.edu.udistrital.controller;

import java.util.Random;

import javax.swing.JOptionPane;

import co.edu.udistrital.model.GeneradorPastores;
import co.edu.udistrital.model.ListaCircular;
import co.edu.udistrital.model.Nodo;
import co.edu.udistrital.model.Pastor;
import co.edu.udistrital.model.PilaDesposeidos;
import co.edu.udistrital.view.MainView;

public class Controller {

	private MainView view;
	private GeneradorPastores generador;
	private ListaCircular listaPastores;
	private PilaDesposeidos pila;
	private Random rnd;

	public Controller(MainView view) {
		this.view = view;
		this.generador = new GeneradorPastores();
		this.listaPastores = new ListaCircular();
		this.pila = new PilaDesposeidos();
		this.rnd = new Random();
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

	private Nodo buscarNodoConPastorMasPobre() {

		Nodo actual = listaPastores.getCabeza();
		Nodo pobre = actual;
		actual = actual.getSiguiente();
		while (actual != listaPastores.getCabeza()) {
			if (actual.getPastor().getDinero() < pobre.getPastor().getDinero()) {
				pobre = actual;
			}
			actual = actual.getSiguiente();
		}

		return pobre;
	}

	private Nodo buscarNodoConPastorConMenosFeligreces(Nodo nodo) {
		if (nodo == null || listaPastores.getTamanno() <= 1) {
			return null; // no hay vecinos válidos
		}

		Pastor pastorEnTurno = nodo.getPastor();
		boolean sentidoHorario = isPar(pastorEnTurno.getDinero());
		int cantidadVecinos = pastorEnTurno.getDinero() % listaPastores.getTamanno();
		if (cantidadVecinos == 0) {
			cantidadVecinos = 1;
		}

		JOptionPane.showMessageDialog(view.getFrame(), "Se evaluaron en sentido: "
				+ (sentidoHorario ? "horario " : "antihorario ") + cantidadVecinos + " vecinos");

		Nodo actual = sentidoHorario ? nodo.getSiguiente() : nodo.getAnterior();
		Nodo menosFeligreses = actual;

		for (int i = 1; i < cantidadVecinos; i++) {
			actual = sentidoHorario ? actual.getSiguiente() : actual.getAnterior();
			if (actual != nodo && actual.getPastor().getFeligreces() < menosFeligreses.getPastor().getFeligreces()) {
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

		int n = rnd.nextInt(1, listaPastores.getTamanno());

		Nodo actual = buscarNodoConPastorMasRico();

		while (listaPastores.getTamanno() > 1) {

			Pastor pastorTurno = actual.getPastor();

			String estado = String.format("Turno: %s - Dinero:%d Feligreces:%d\nTamaño rueda:%d\nPila vacía:%b",
					pastorTurno.getOficio(), pastorTurno.getDinero(), pastorTurno.getFeligreces(),
					listaPastores.getTamanno(), pila.estaVacia());
			JOptionPane.showMessageDialog(view.getFrame(), estado);

			Nodo nodoMasPobre = buscarNodoConPastorMasPobre();
			if (nodoMasPobre == actual) {
				Nodo nodoMasRico = buscarNodoConPastorMasRico();
				if (nodoMasRico != null && nodoMasRico != actual) {
					int dineroTomado = nodoMasRico.getPastor().getDinero() / 3;
					int feligresesTomados = nodoMasRico.getPastor().getFeligreces() / 3;
					if (dineroTomado > 0 || feligresesTomados > 0) {
						boolean accionPobre = rnd.nextBoolean(); // la acción se realiza aleatoriamente
						if (accionPobre) {
							pastorTurno.adicionarDinero(dineroTomado);
							pastorTurno.adicionarFeligreces(feligresesTomados);
							nodoMasRico.getPastor().setDinero(nodoMasRico.getPastor().getDinero() - dineroTomado);
							nodoMasRico.getPastor()
									.setFeligreces(nodoMasRico.getPastor().getFeligreces() - feligresesTomados);

							String informe = "El pastor " + pastorTurno.getOficio()
									+ " era el más pobre y tomó 1/3 de la riqueza y feligreses de "
									+ nodoMasRico.getPastor().getOficio() + ".\n" + "Dinero tomado: " + dineroTomado
									+ "\n" + "Feligreses tomados: " + feligresesTomados;

							JOptionPane.showMessageDialog(view.getFrame(), informe);

						}
					}

				}

			}

			boolean accionRescate = false;
			if (!pila.estaVacia()) {
				accionRescate = rnd.nextInt(100) < 30; /*
														 * 30% rescatar, 70% eliminar (Para que las posibilidades de que
														 * el juego terminen sean más probables
														 */

			}

			if (accionRescate) {
				Pastor rescatado = pila.retirar();

				if (rescatado != null) {
					int mitadDinero = pastorTurno.getDinero() / 2;
					int mitadFeligreses = pastorTurno.getFeligreces() / 2;

					pastorTurno.setDinero(pastorTurno.getDinero() - mitadDinero);
					pastorTurno.setFeligreces(pastorTurno.getFeligreces() - mitadFeligreses);

					rescatado.adicionarDinero(mitadDinero);
					rescatado.adicionarFeligreces(mitadFeligreses);

					listaPastores.agregar(rescatado);

					JOptionPane.showMessageDialog(view.getFrame(), "Se ha rescatado a: " + rescatado.getOficio());

					actual = designarSiguienteAleatorio(actual);
					view.getDrawPanel().setPartes(listaPastores.getTamanno());
					view.getDrawPanel().colocarPastores(listaPastores);
					continue;

				}

			} else {

				boolean sentidoHorario = isPar(pastorTurno.getDinero());
				Nodo objetivo = buscarNodoConPastorConMenosFeligreces(actual);
				if (objetivo == null || objetivo == actual) {

					JOptionPane.showMessageDialog(view.getFrame(), "No se encontró objetivo válido para eliminar.");
					actual = actual.getSiguiente();
					continue;
				}

				Pastor pastorEliminado = objetivo.getPastor();
				pastorTurno.adicionarDinero(pastorEliminado.getDinero());
				pastorTurno.adicionarFeligreces(pastorEliminado.getFeligreces());

				pila.insertar(pastorEliminado);

				Nodo siguienteDelEliminado = objetivo.getSiguiente();
				listaPastores.eliminar(objetivo);

				JOptionPane.showMessageDialog(view.getFrame(), "Se ha eliminado a: " + pastorEliminado.getOficio());

				// Actualizar vista
				view.getDrawPanel().setPartes(listaPastores.getTamanno());
				view.getDrawPanel().colocarPastores(listaPastores);

				actual = designarSiguienteAleatorio(actual);

			}

			if (listaPastores.getTamanno() == 1) {
				Nodo ganador = listaPastores.getCabeza();
				Pastor p = ganador.getPastor();
				JOptionPane.showMessageDialog(view.getFrame(), "Juego terminado. Ganador: " + p.getOficio() + " Dinero:"
						+ p.getDinero() + " Feligreces:" + p.getFeligreces());
			}

		}
	}

	// Función para seleccionar al siguiente pastor de forma aleatoria (se puede
	// cambiar por otro tipo de asignación
	// para tener otras reglas del juego, luego se verá.
	private Nodo designarSiguienteAleatorio(Nodo actual) {

		int tam = listaPastores.getTamanno();
		if (tam <= 1)
			return listaPastores.getCabeza();
		int pasos = rnd.nextInt(1, tam);
		Nodo elegido = actual;
		for (int i = 0; i < pasos; i++)
			elegido = elegido.getSiguiente();
		return elegido;

	}

}
