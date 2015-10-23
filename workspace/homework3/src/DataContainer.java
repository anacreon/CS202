//Scott Rice
//301161515

public class DataContainer {
	String symbol;
	String date;
	DataStreamObject[] dsos;
	int idx = 0;
	
	DataContainer() {
		this("undefined", "undefined");
	}
	
	DataContainer(String symbol, String date) {
		this.symbol = symbol;
		this.date = date;
		
		dsos = new DataStreamObject[5];
		for (int i = 0; i < 5; i++)
			dsos[i] = new DataStreamObject();
	}
	
	public DataStreamObject getDataStreamObject(int index) {
		return dsos[index];
	}

	public void addRow(RowOfData row) {
		// get date & normalize time to bucket (or index)
		
		// store price (average price in bucket)
		dsos[0].getDataArray()[idx] = row.getDouble("Price");
		
		// store volume in bucket 
		dsos[1].getDataArray()[idx] = row.getDouble("Volume");
		
		// Duhhh!!!
		idx++;
	}
	
	
	// newly added print container method
	public void printContainer() {
		System.out.println("Container for [" + symbol + "]");
		
		if (idx == 0) {
			System.out.println(" has no values");
			return;
		}
		
		System.out.printf("%5s %10s %10s\n", "idx", "price", "volume");
		for (int i = 0; i < idx; i++) {
			double price = dsos[0].getDataArray()[i];
			int volume = (int) dsos[1].getDataArray()[i];

			System.out.printf("%5d %10.2f %10d\n", i, price, volume);
		}
	}
	
}
