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
}
