package edu.calstatela.cs.cs202.srice.lab3;


public class Driver 
{
	public static void main(String[] args)
	{
		DataStreamObject dataVector =
			new DataStreamObject(10);
		for(int i = 0; i < 5; i++)
			dataVector.putValue(i*1.0);
		
		System.out.println("sum = " + dataVector.getSum());
		System.out.println("avg = " + dataVector.getAverage());
		
	}

}
