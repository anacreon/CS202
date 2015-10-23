//Scott Rice
//301161515

import java.util.HashMap;
import java.util.Set;

public class StockPortfolio {
	static HashMap<String,DataContainer> setOfContainers = 
		new HashMap<String,DataContainer>();;
	
	public static void addStockToPorfolio(String stock) {
		if (! setOfContainers.containsKey(stock)) {
			System.out.println("Adding: " + stock + " to porfolio");
			DataContainer dc = new DataContainer(stock, "anydate");
			setOfContainers.put(stock, dc);
		}
	}
	
	public static DataContainer getContainer(String stock) {
		DataContainer dc = setOfContainers.get(stock);
		
		
		if (dc == null) {
			dc = new DataContainer(stock, "anydate");
			setOfContainers.put(stock, dc);
		}
		
		return dc;
	}
	
	public static void printInfo() {
		Set<String> stocks = setOfContainers.keySet();
		
		if (stocks.size() == 0)
			return;
		
		// now we have an stock list in a array
		String[] stockArray = (String[]) stocks.toArray(new String[0]);
		
		for (String stock : stockArray) {
			System.out.println("   " + stock);
		}
		
	}
	
	public static String[] getStocks() {
		Set<String> stocks = setOfContainers.keySet();
		
		if (stocks.size() == 0)
			return null;
		
		return (String[])(setOfContainers.keySet()).toArray(new String[0]);
	}
}
