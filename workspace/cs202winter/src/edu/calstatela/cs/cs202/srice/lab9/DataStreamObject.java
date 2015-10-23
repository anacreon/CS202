package edu.calstatela.cs.cs202.srice.lab9;
//Name: Scott Rice
//CIN:  301161515


public class DataStreamObject {
	// data definition
	int size = 0;
	int limit = 3240;
	double data[];

	// default constructor
	DataStreamObject() {
		data = new double[limit];
	}

	// override the default constructor
	public DataStreamObject(int newLimit) {
		limit = newLimit;
		data = new double[limit];
	}

	// add value to DSO
	public void putValue(double value) {
		data[size] = value;
		size++;
		size %= limit;
	}

	// add array of values to DSO
	public void putValues(double[] a) {

		for (int j = 0; j < a.length; j++) {
			putValue(a[j]);
		}
		
	}

	// average method
	public double getAverage() {
		return getSum() / size;
	}

	// sum method
	public double getSum() {
		double sum = 0.0;
		for (int i = 0; i < size; i++)
			sum += data[i];

		return sum;
	}

	// compute standard deviation
	public double getStd() {
		double a = getAverage();
		double std = 0;
		for(int i = 0; i < size; i++)
		{
			std = std + Math.pow(data[i] - a, 2);  
		}
		std = Math.sqrt(std/size);
		return std;
	}

	// compute min
	public double getMin() {
		
		double min = data[0];
		for(int i = 1; i < size; i++)
		{
			if(min > data[i])
				min = data[i];
		}
		return min;
	}

	// compute max
	public double getMax() {
		double max = data[0];
		for(int i = 1; i < size; i++)
		{
			if(max < data[i])
				max = data[i];
		}
		return max;
	}
}
