package edu.calstatela.cs.cs202.srice.lab7;

public class Equity {
	
	double value;
	String equityType;
	
	
	Equity()
	{
       this(0.0, "cash");

	}
	Equity(double w, String equityType)
	{
		value = w;
		this.equityType = equityType;
	}
    double getValue()
    {
      
    	
    	return value;
    }
    String getEquityType()
    {
    	return equityType;
    }
    void setEquityType(String equityType)
    {
    	this.equityType = equityType;
    }
    
}
