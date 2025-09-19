package co.edu.udistrital.view;

import javax.swing.*;
import java.awt.*;

public class MainView {

    private JFrame frame;
    private JTextField textField;
    private DrawPanel drawPanel;

    public MainView() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame("Círculo dividido");
        frame.setBounds(10, 10, 1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); 

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JLabel lblTextoNroPastores = new JLabel("Número de pastores:");
        controlPanel.add(lblTextoNroPastores);

        textField = new JTextField(5);
        controlPanel.add(textField);

        JButton btnGenerarButton = new JButton("Generar");
        controlPanel.add(btnGenerarButton);

        frame.add(controlPanel, BorderLayout.NORTH);


        drawPanel = new DrawPanel(10);
        frame.add(drawPanel, BorderLayout.CENTER);


        btnGenerarButton.addActionListener(e -> {
            try {
                int n = Integer.parseInt(textField.getText());
                drawPanel.setPartes(n); 
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Ingresa un número válido");
            }
        });

        frame.setVisible(true);
    }
}
