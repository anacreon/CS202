


//Scott Rice
//301161515
public class StockGraphProgram {

	public static void main(String[] args) {
		
		// takes the stock as the first argument
		if (args.length < 2) {
			System.out.printf("usage: %s <datafile> [price|volume]\n", args[0]);
			System.exit(0);
		}
				
		String dataFile = args[0];
		String priceOrVolume = args[1];
		
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
		
		FileRead reader = new FileRead(dataFile, columnStructure);
		RowOfData row = null;
		
		// one data container per program
		DataContainer dc = new DataContainer();
		
		reader.Open();

		while ((row = reader.next()) != null) {
			// row.print();
			dc.addRow(row);
		}

		reader.Close();

		// datacontainer is fat and happy!
		
		// for this exercise we'll plot price ... but you decide!
		DataStreamObject dso = null;
		DataStreamObject bucketized = new DataStreamObject();
		if (priceOrVolume.equals("price")) {
			// plot price
			dso = dc.bucketize(0);
		} else {
			// plot volume
			dso = dc.bucketize(1);
		}
		
		
		
		CanvasData cd = null;
		try
		{
			cd = dso.getCanvasData(300, 200, 0);
		}
		catch(ArrayIndexOutOfBoundsException aioobe)
		{
			System.out.println(aioobe.getMessage());
			System.exit(-1);
		}
		// cd.printValues();
		
		Canvas canvas = new Canvas(cd, 650, 300);
	}

}
