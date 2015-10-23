package edu.calstatela.cs.cs202.srice.lab4;

import edu.calstatela.cs.cs202.srice.lab3.DataContainer;
import edu.calstatela.cs.cs202.srice.lab3.DataStreamObject;


public class Driver {

	public static void main(String[] args) {

		DataContainer container = new DataContainer();
		
		for (int i = 0; i < 5; i++) {
			container.putValue("price", i*1.0);
		}
		DataStreamObject dso = container.getDSO("price");
		System.out.println("average price = " + dso.getAverage());

	}
	
}
