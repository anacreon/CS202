package edu.calstatela.cs.cs202.srice.lab6;

public class Stock {
	Row[] rows;
	String symbol;
	int size;
	
	Stock()
	{
		this("Undefined");
	}
	Stock(String symbol)
	{
		rows = new Row[10000];
		this.symbol = symbol;
	}
	int Predict()
	{
		int whatToDo = 0;
		int sum = 0;
		
		for(int i = 0; i < size; i++)
		{
			sum+= rows[i].getVolume() * rows[i].getPrice();
			
		}
		double m = rows[size - 1].getVolume() * rows[size -1].getPrice();
		
		if(m > sum)
			return 1;
		
		return whatToDo;
	}
}
