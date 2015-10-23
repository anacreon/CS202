package edu.calstatela.cs.cs202.srice.homework2;

public class DataStreamObject {
	String columnName;
	double[] dataArray = null;
	private static final int MAX = 3240;
	
	// default constructor
	DataStreamObject() {
		dataArray = new double[MAX];
	}

	String getColumnName() {
		return columnName;
	}
	
	double[] getDataArray() {
		return dataArray;
	}
	
	// need to fill in standard max, min functions here
}
