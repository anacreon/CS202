package edu.calstatela.cs.cs202.srice.lab3;


public class DataContainer 
{
	DataStreamObject dsos[];
	String lookupTable[];
	
	public DataContainer()
	{
		dsos = new DataStreamObject[5];
		
		for(int i = 0; i < dsos.length; i++)
			dsos[i] = new DataStreamObject();
		
		lookupTable = new String[5];
		
		lookupTable[0] = "time";
		lookupTable[1] = "price";
		lookupTable[2] = "volume";
		lookupTable[3] = "bid";
		lookupTable[4] = "ask";
		
	}
	private int getIndex(String columnName)
	{
		for (int i = 0; i < 5; i++)
			if(lookupTable[i].equals(columnName))
				return i;
		
		return -1;
	}
	public void putValue(String columnName, double value) {
		int index = getIndex(columnName);
		if (index < 0) {
			System.out.println("no such column: " + columnName);
			return;
		}
		(dsos[index]).putValue(value);
	}

	public DataStreamObject getDSO(String columnName) {
		int index = getIndex(columnName);
		
		if (index < 0)
			return null;
		
		return dsos[index];
	}
	public void putValues(String columnName, double[] a) {
		int index = getIndex(columnName);
		if (index < 0) {
			System.out.println("no such column: " + columnName);
			return;
		}
		(dsos[index]).putValues(a);
	}
}
