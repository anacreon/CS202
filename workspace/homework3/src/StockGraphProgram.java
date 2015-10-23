


//Scott Rice
//301161515
public class StockGraphProgram {

	public static void main(String[] args) {
		
				

		final String columnStructure[][] = { 
				{ "Ticker", "string" },  
				{ "Price",  "number" },  // column 1
				{ "Date",   "string" },  
				{ "Time",   "string" },
				{ "Change", "number" },  // column 4 
				{ "Close",  "number" },
				{ "Open",   "number" },
				{ "High",   "number" },
				{ "Volume", "number" }   // column 8
		};
		
		URLConnectionReader reader = new URLConnectionReader(columnStructure);
		
		// one data container per program
		int pauseTime = 2;
		Canvas canvas = new Canvas(650, 400);
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
	}
}
		

		// should never get here



