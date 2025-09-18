package co.edu.udistrital.view;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class MainView {

    private JFrame frame;


    public MainView() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame("Círculo dividido");
        frame.setVisible(true);
        
        frame.setBounds(10, 10, 1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dibuja el circulo con n particiones
        DrawPanel panel = new DrawPanel(10);
        frame.add(panel);
    }
}
