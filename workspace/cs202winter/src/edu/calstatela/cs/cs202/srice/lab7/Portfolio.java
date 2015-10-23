package edu.calstatela.cs.cs202.srice.lab7;

public class Portfolio extends Equity{
	java.util.ArrayList<Equity> equityArray;
	String name;
	
	Portfolio()
	{
		equityArray = new java.util.ArrayList<Equity>();
	}

	//option 1
	//addStock(Stock st) {} & addBonds(bd){}
	//
	//option 2
	//addEquity(Stock st) {} & addEquity(Bonds bd){}
	//
	//option 3
	//addEquity(Equity eq) {}
	
	void addEquity(Equity equity)
	{
		equityArray.add(equity);
	}
	int countAsset(String equityType)
	{
		int count = 0;
		
		for(Equity eq : equityArray){
			if(eq.getEquityType().equals(equityType))
				count++;
		}
		return count;
	}

}
