package edu.calstatela.cs.cs202.srice.homework2;

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

	public void addRow(RowOfData row) {
		// get date & normalize time to bucket (or index)
		
		dsos[0].getDataArray()[idx] = row.getDouble("time");
		
		// store price (average price in bucket)
		dsos[1].getDataArray()[idx] = row.getDouble("price");
		
		// store volumne in bucket 
		dsos[2].getDataArray()[idx] = row.getDouble("volume");
		idx++;
	}
	public CanvasData getCanvasData()
	{
		return null;
	}
}
