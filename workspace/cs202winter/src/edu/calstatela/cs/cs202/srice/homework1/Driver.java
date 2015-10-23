package edu.calstatela.cs.cs202.srice.homework1;
//Name: Scott Rice
//CIN:  301161515

public class Driver {

	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.printf("usage: %s <datafile>\n", args[0]);
			System.exit(0);
		}
		
		String dataFile = args[0];
		FileRead reader = new FileRead(dataFile);
		String[] dataArray = null;
		
		String columnNames[] = { 
				"Ticker", 
				"Price",  // column 1
				"Date", 
				"Time",
				"Change", // column 4 
				"Close",
				"Open",
				"High",
				"Volume"  // column 8
		};

		DataContainer container = new DataContainer(columnNames);

		reader.Open();

		while ((dataArray = reader.next()) != null) {
			// for now ignore the other columns...
			container.putValue("Price", Double.parseDouble(dataArray[1]));
			container.putValue("Change", Double.parseDouble(dataArray[4]));
			container.putValue("Volume", Double.parseDouble(dataArray[8]));
		}

		reader.Close();

		String searchStrings[] = { "Price", "Change", "Volume" } ;
		for (String column : searchStrings) {
			DataStreamObject dso = container.getDSO(column);
			System.out.printf("%s average=%.2f sum=%.2f std=%.2f min=%.2f max=%.2f\n",
					column, dso.getAverage(), dso.getSum(), dso.getStd(),
					dso.getMin(), dso.getMax());
		}
	}

}
