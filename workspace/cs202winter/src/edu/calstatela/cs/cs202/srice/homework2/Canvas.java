package edu.calstatela.cs.cs202.srice.homework2;

import java.awt.*;
import javax.swing.*;

class Canvas extends JFrame {

	private static final long serialVersionUID = 7578861071544428050L;

	public Canvas() {
		// default constructor
	}

	static public void main(String[] args) {
		Canvas canvas = new Canvas();

		canvas.setTitle("canvas sample");
		canvas.setSize(600, 200);
		canvas.setLocationRelativeTo(null);
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CanvasData dd = new CanvasData(300);
		
		NewPanel p = new NewPanel(dd);
		canvas.add(p);		
		
		canvas.setVisible(true);
	}

}

class NewPanel extends JPanel {

	private static final long serialVersionUID = 1833059144811640642L;
	private CanvasData dd;
	
	public NewPanel(CanvasData dd) {
		this.dd = dd;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		double[] dataVector = dd.getDataArray();
		int w = 2;
		int YMAX = this.getHeight();
		
		for (int i = 0; i < dataVector.length; i++) {
			int x = w * i;
			int h = (int) dataVector[i];
			int y = YMAX - h;
			g.fillRect(x, y, w, h);
		}
		
		g.drawString("INTC", 140, 50);
	}
}
