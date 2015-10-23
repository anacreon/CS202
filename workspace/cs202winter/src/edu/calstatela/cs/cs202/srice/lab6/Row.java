package edu.calstatela.cs.cs202.srice.lab6;

public class Row {
	double price;
	String date;
	String time;
	int volume;
	
	void setPrice(double price)
	{
		this.price = price;
	}
	double getPrice()
	{
		return this.price;
	}
	int getVolume()
	{
		return this.volume;
	}

}
