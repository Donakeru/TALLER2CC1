package co.edu.udistrital.view;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	private int partes;

	public DrawPanel(int partes) {
		this.partes = partes;
	}

	public void setPartes(int partes) {
		this.partes = partes;
		repaint(); // actualiza la vista
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int size = Math.min(getWidth(), getHeight()) - 100;
		int x = (getWidth() - size) / 2;
		int y = (getHeight() - size) / 2;

		g.drawOval(x, y, size, size);

		int cx = x + size / 2;
		int cy = y + size / 2;

		for (int i = 0; i < partes; i++) {
			double angle = 2 * Math.PI * i / partes;
			int px = cx + (int) (size / 2 * Math.cos(angle));
			int py = cy + (int) (size / 2 * Math.sin(angle));
			g.drawLine(cx, cy, px, py);
		}
	}
}
