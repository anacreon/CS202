//Scott Rice
//301161515
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

class Canvas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 7578861071544428050L;
	String stock = "none";
	JTextField stockEntry = null;
	GraphPanel graphPanel = null;
	JComboBox priceVolume = null;
	JPanel canvasPanel = null;
	
	public Canvas(int width, int height) {
		setTitle("Stocks");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create a panel
		canvasPanel = new JPanel();
		JPanel manager = new JPanel();
		manager.setLayout(new GridLayout(1, 3, 5, 5));
		add(canvasPanel, BorderLayout.NORTH);
		
		add(manager, BorderLayout.SOUTH);
		CanvasData cd = new CanvasData(600);
		PlotData(cd, stock);
		
		// create a text field
		stockEntry = new JTextField("GOOG", 4);
		manager.add(stockEntry);
		stockEntry.addActionListener(this);
		
		priceVolume = new JComboBox(new String[]{"Price","Volume"});
		manager.add(priceVolume);
	
		// create go button
		JButton okButton = new JButton("go!");
		manager.add(okButton);
		okButton.addActionListener(this);
		
		setVisible(true);
	}

	private void PlotData(CanvasData cd, String stock) {
		if(graphPanel != null)
		{
		remove(graphPanel);
		}
		graphPanel = new GraphPanel(cd, stock);
		add(graphPanel);	
	}

	public void actionPerformed(ActionEvent e) {
		String stock = stockEntry.getText();
		Date timeNow = new java.util.Date(e.getWhen());
		String PriVol = (String) priceVolume.getSelectedItem();
		System.out.println("The [" + stock + "] button is clicked at " + timeNow);
		StockPortfolio.addStockToPorfolio(stock);

		// get the data container with for the stock
		DataContainer dc = StockPortfolio.getContainer(stock);
		
		// print the data container
		dc.printContainer();
		// 0 for price, 1 for volume
		DataStreamObject dso;
		if(PriVol.equals("Price"))
		{
			dso = dc.getDataStreamObject(0);
		}// 0 for price, 1 for volume
		else
		{
			dso = dc.getDataStreamObject(1);
		}
		int start = 0;
		if(dc.idx > 600)
			start = dc.idx;
		
		CanvasData cd = dso.getCanvasData(600, 200, start); // keep tract starting points..
		PlotData(cd, stock);
		setVisible(true);
	}
}

class GraphPanel extends JPanel {

	private static final long serialVersionUID = 1833059144811640642L;
	private CanvasData dd;
	private String symbol;
	public GraphPanel(CanvasData dd, String symbol) {
		this.dd = dd;
		this.symbol = symbol;
	}

	public void paintComponent(Graphics g) {
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
		
		g.drawString(symbol, 140, 50); //pass in actual stock symbol...
	}
}