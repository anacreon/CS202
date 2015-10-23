package edu.calstatela.cs.cs202.srice.lab6;

public class Portfolio {
	Position[] positions;
	String name;
	
	double lossgain()
	{
		return 0.0;
	}
void print()
{
	for(Position p: positions)
	{
		p.print();
	}
}
}
