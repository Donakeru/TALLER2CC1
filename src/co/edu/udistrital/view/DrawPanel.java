package co.edu.udistrital.view;

import java.awt.*;
import javax.swing.*;

import co.edu.udistrital.model.*;

public class DrawPanel extends JPanel {
	private int partes;
	private int sectorHover = -1;
	private ListaCircular listaPastores;

	public DrawPanel(int partes) {
		this.partes = partes;
		ToolTipManager.sharedInstance().registerComponent(this);
		ToolTipManager.sharedInstance().setInitialDelay(10);

	}

	public void setPartes(int partes) {
		this.partes = partes;
		repaint();
	}

	public void colocarPastores(ListaCircular listaPastores) {
		this.listaPastores = listaPastores;
		repaint();
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

		if (sectorHover >= 0 && partes > 0) {
			System.out.println(sectorHover);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(new Color(135, 206, 250, 120));
			double startAngle = 360.0 * sectorHover / partes;
			double arcAngle = 360.0 / partes;
			System.out.println("GRADOS: " + Math.toDegrees(startAngle));
			g2d.fillArc(x, y, size, size, (int) (-startAngle), (int) -arcAngle);
		}

		g.setColor(Color.BLACK);
		g.drawOval(x, y, size, size);

		for (int i = 0; i < partes; i++) {
			double angle = 2 * Math.PI * i / partes;
			int px = cx + (int) (size / 2 * Math.cos(angle));
			int py = cy + (int) (size / 2 * Math.sin(angle));
			g.drawLine(cx, cy, px, py);
		}
	}

	@Override
	public String getToolTipText(java.awt.event.MouseEvent e) {
		if (listaPastores == null || listaPastores.getCabeza() == null) {
			sectorHover = -1;
			repaint();
			return null;
		}

		int size = Math.min(getWidth(), getHeight()) - 100;
		int cx = getWidth() / 2;
		int cy = getHeight() / 2;
		int radio = size / 2;

		double dx = e.getX() - cx;
		double dy = e.getY() - cy;
		double dist = Math.sqrt(dx * dx + dy * dy);

		if (dist > radio) {
			sectorHover = -1;
			repaint();
			return null;
		}

		double angle = Math.atan2(dy, dx);
		if (angle < 0)
			angle += 2 * Math.PI;

		int sector = (int) (angle / (2 * Math.PI) * partes);

		sectorHover = sector;
		repaint();

		Nodo nodo = listaPastores.getCabeza();
		for (int i = 0; i < sector; i++) {
			nodo = nodo.getSiguiente();
		}

		Pastor pastor = nodo.getPastor();
		return "<html><b>Oficio:</b> " + pastor.getOficio() + "<br><b>Dinero:</b> " + pastor.getDinero()
				+ "<br><b>Seguidores:</b> " + pastor.getFeligreces() + "</html>";
	}
}
