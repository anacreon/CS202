package edu.calstatela.cs.cs202.srice.lab2;
import java.util.Scanner;
public class Stockmarket 
{

	public static void main(String[] args)
	{ 
		    Scanner scanner = new Scanner(System.in);
		    double price = 0, volume = 0, bid = 0, ask = 0, time;
		    boolean a = true;
		    int count = 0;
		    String line;
		    while(a)
		    {
		    	line = scanner.nextLine();
			    String[] tokens = line.split("\\|");
		    	if(tokens[0].equals("EOD"))
		    		a = false;
		    	else
		    	{
		    		price += Double.valueOf(tokens[1]);
		    		volume += Double.valueOf(tokens[2]);
		    		bid += Double.valueOf(tokens[3]);
		    		ask += Double.valueOf(tokens[4]);
		    		
		    		
		        count++;
		    	}
		    	
		    }
		
	}
}
