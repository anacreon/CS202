package edu.calstatela.cs.cs202.srice.homework2;

import edu.calstatela.cs.cs202.srice.homework2.FileRead;

public class StockGraphProgram {


	public static void main(String[] args) {
		
		// takes the stock as the first argument
		if (args.length < 1) {
			System.out.printf("usage: %s <datafile>\n", args[0]);
			System.exit(0);
		}
		
		String dataFile = args[0];
		
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
		
		//construct a data container => dc
		
		reader.Open();

		while ((row = reader.next()) != null) {
			row.print();
			//add row to dc
		}

		reader.Close();
		//dc should contain n DSO's objects filled with data from rows
		
		//extract canvas data from dc
		//CanvasData cd = dc.getCanvasData
		//construct canvas
		//add cd to canvas
		//have canvas reder the plot
	}

}
