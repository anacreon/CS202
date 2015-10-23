
//Scott Rice
//301161515
import java.awt.*;
import javax.swing.*;

class Canvas extends JFrame {

	private static final long serialVersionUID = 7578861071544428050L;

	public Canvas(CanvasData cd, int width, int height) {
		setTitle("Canvas Sample");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		NewPanel p = new NewPanel(cd);
		add(p);
		setVisible(true);
	}

	static public void main(String[] args) {
		CanvasData dd = new CanvasData(200);
		new Canvas(dd, 600, 200);
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
