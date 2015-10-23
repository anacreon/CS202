package edu.calstatela.cs.cs202.srice.lab7;

public class Bonds extends Equity {

	String series;
	int maturationDate;
	
	Bonds()
	{
		
		System.out.print(toString());
		System.out.println(": default contructor not allowed");
		System.exit(-1);
	}
	Bonds(int maturationDate, int value)
	{
		super(value, "bonds");
	}
    double computeValue(int days)
    {
    	return getValue() * (double)days/maturationDate;
    }

}
