

import javax.swing.*;

import java.awt.TextField;
import java.awt.event.*;
import java.util.Date;

public class StockGraphProgram2 {

	public static void main(String[] args) {

		int pauseTime = 1;

		final String columnStructure[][] = {
				{ "Ticker", "string" },
				{ "Price", "number" }, // column 1
				{ "Date", "string" },
				{ "Time", "string" },
				{ "Change", "number" }, // column 4
				{ "Close", "number" }, { "Open", "number" },
				{ "High", "number" }, { "Volume", "number" } // column 8
		};

		URLConnectionReader reader = new URLConnectionReader(columnStructure);

		// for the demo, we use four buttons below...
		//String[] buttons = { "INTC", "IBM", "AAPL", "MSFT" };
	   //String[] buttons = { };
		
		 //create an application and show its window
		 //StockDemoWindow applicationWindow = new StockDemoWindow();
		 //applicationWindow.showWindow("Stock Demo Window");
		// -- or --
		Canvas canvas = new Canvas(600,400);
		
		// infinite loop to read data
		while (true) {
			System.out.println("Reading stock(s): ");
			StockPortfolio.printInfo();

			// for each stock in the portfolio read data from Internet
			String[] stocks = StockPortfolio.getStocks();

			if (stocks != null) {
				for (String stock : stocks) {
					// Get reference to container from the Portfolio
					DataContainer dc = StockPortfolio.getContainer(stock);

					// Get row of data from the reader
					RowOfData row = reader.next(stock);

					// Add the row of data to container
					dc.addRow(row);
					row.print();
					
				}
			}

			try {
				int delay = 1000 * pauseTime;
				System.out.println("Pausing: " + pauseTime + " seconds");
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// should never get here
	}
}


// this is where you'd do most of your work...
class StockDemoWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1950708474357933004L;
	JTextField stockEntry = null;

	public void showWindow(String title) {
		setTitle(title);
		setVisible(true);
	}
	
	public StockDemoWindow() {

		// Create a panel to hold buttons
		JPanel panel = new JPanel();
	
		// create a text field
		stockEntry = new JTextField("GOOG", 4);
		panel.add(stockEntry);
		stockEntry.addActionListener(this);
	
		// create go button
		JButton okButton = new JButton("go!");
		panel.add(okButton);
		okButton.addActionListener(this);

		// Add panel to the frame
		add(panel); 
		setSize(200, 150);
		setLocation(200, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		String stock = stockEntry.getText();
		Date timeNow = new java.util.Date(e.getWhen());
		
		System.out.println("The [" + stock + "] button is clicked at " + timeNow);
		StockPortfolio.addStockToPorfolio(stock);

		// get the data container with for the stock
		DataContainer dc = StockPortfolio.getContainer(stock);
		
		// print the datacontainer
		dc.printContainer();
	}
}

