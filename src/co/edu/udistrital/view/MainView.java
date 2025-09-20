package co.edu.udistrital.view;

import javax.swing.*;
import java.awt.*;

public class MainView {

    private JFrame frame;
    private JTextField textField;
    private JButton btnEmpezarButton;
    private JButton btnGenerarButton;
    private DrawPanel drawPanel;

    public MainView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Círculo dividido");
        frame.setBounds(10, 10, 1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(new FlowLayout());

        JLabel lblTextoNroPastores = new JLabel("Número de pastores:");
        controlPanel.add(lblTextoNroPastores);

        textField = new JTextField(5);
        controlPanel.add(textField);

        btnGenerarButton = new JButton("Generar");
        controlPanel.add(btnGenerarButton);

        frame.getContentPane().add(controlPanel, BorderLayout.NORTH);
        
        //Inicia el programa con un círculo de 0 divisiones
        drawPanel = new DrawPanel(0);
        frame.getContentPane().add(drawPanel, BorderLayout.CENTER);
        drawPanel.setLayout(null);
        
        btnEmpezarButton = new JButton("Empezar");
        btnEmpezarButton.setBounds(1123, 127, 89, 23);
        drawPanel.add(btnEmpezarButton);
        
        
        
        
        
        
        frame.setVisible(true);
        
        
        
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton getBtnGenerarButton() {
        return btnGenerarButton;
    }
    
    public JButton getBtnEmpezarButton() {
    	return btnEmpezarButton;
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }
}
