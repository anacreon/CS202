package edu.calstatela.cs.cs202.srice.lab3;


public class DataStreamObject 
{
	double[] data;
	int limit = 3240;
	int size = 0;
	DataStreamObject()
	{
	    data = new double[limit];	
	}
    public DataStreamObject(int newLimit)
    {
    	limit = newLimit;
    	data = new double[limit];
    }
    public double getAverage()
    {
    	return getSum()/size;
    }
    public double getSum() {
    	double sum = 0.0;
    	for(int i = 0; i < size; i++)
    	{
    		sum += data[i];
    	}
		return sum;
	}
	public void putValue(double value)
    {
    	data[size] = value;
    	size++;
    	size %= limit;
    }
	public void putValues(double[] a) {
			
		for(int j = 0; j < a.length; j++)
			{
				putValue(a[j]);
			} 	
		
	}
	public void printValues()
	{
		for(int j = 0; j < size; j++)
		{
			System.out.printf("[%d] %f\n", j, data[j]);
			
		}
		
	}
	
}
