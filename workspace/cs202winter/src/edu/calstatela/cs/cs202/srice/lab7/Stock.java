package edu.calstatela.cs.cs202.srice.lab7;

public class Stock extends Equity {

	String symbol;
	Stock()
	{
		this(0.0);
	}
	Stock(double value)
	{
		super(value, "stock");
	}
	double computeValue(int quantity)
	{
		return getValue() * quantity;
	}
	void stockOnlyFunction(){
		System.out.println("i am a stock");
	}
}
