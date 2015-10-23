
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
		dsos[0].getDoubleArray()[idx] = row.getDouble("Price");
		
		// store volume in bucket 
		dsos[1].getDoubleArray()[idx] = row.getDouble("Volume");
		
		dsos[2].getStringArray()[idx] = row.getString("Date");
		
		dsos[3].getStringArray()[idx] = row.getString("Time");
		
		// Duhhh!!!
		idx++;
	}
	//average all the values in the same minute then stores it into a smaller dso
	//this assumes the data is in chronological order
	public DataStreamObject bucketize(int index)
	{
		DataStreamObject bucket = new DataStreamObject();
		DataStreamObject date = dsos[2];
		DataStreamObject time = dsos[3];
			
		int i = 0;
		int j = 0;
		while((j < date.StringArray.length) && (date.StringArray[j+1] != null))
		{
			while((date.StringArray[j].equals(date.StringArray[j+1]))
			    &&(time.StringArray[j].equals(time.StringArray[j+1])))
			{
				bucket.doubleArray[i] = (dsos[index].doubleArray[i] + dsos[index].doubleArray[j + 1]) / 2;
				j++;
			}
				i++;
				j++;
		}
			
			return bucket;
	}
	
}
