package edu.calstatela.cs.cs202.srice.homework1;
//Name: Scott Rice
//CIN:  301161515

public class DataContainer {
	DataStreamObject dsos[];
	String lookupTable[];

	public DataContainer(String[] columnNames) {
	    // modify the constructor so that the number of columns is dynamic 
		dsos = new DataStreamObject[columnNames.length];
		for(int i = 0; i < dsos.length; i ++)
			dsos[i] = new DataStreamObject();
		
		lookupTable = new String[columnNames.length];
		
		for(int j = 0; j < lookupTable.length; j++)
		{
			lookupTable[j] = new String(columnNames[j]);
		}

	}

	private int getIndex(String columnName) {
		for (int i = 0; i < lookupTable.length; i++)
			if (lookupTable[i].equals(columnName))
				return i;

		return -1;
	}

	public void putValue(String columnName, double value) {
		int index = getIndex(columnName);
		if (index < 0) {
			System.out.println("No such column: " + columnName);
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
