package co.edu.udistrital.view;

import javax.swing.*;
import java.awt.*;

public class MainView {

    private JFrame frame;
    private JTextField textField;
    private JButton btnGenerarButton;
    private DrawPanel drawPanel;

    public MainView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Círculo dividido");
        frame.setBounds(10, 10, 1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(new FlowLayout());

        JLabel lblTextoNroPastores = new JLabel("Número de pastores:");
        controlPanel.add(lblTextoNroPastores);

        textField = new JTextField(5);
        controlPanel.add(textField);

        btnGenerarButton = new JButton("Generar");
        controlPanel.add(btnGenerarButton);

        frame.add(controlPanel, BorderLayout.NORTH);

        // Panel central para dibujo
        drawPanel = new DrawPanel(10);
        frame.add(drawPanel, BorderLayout.CENTER);

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

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }
}
