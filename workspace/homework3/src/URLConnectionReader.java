//Scott Rice
//301161515

import java.net.*;
import java.io.*;

public class URLConnectionReader {
	private String[][] columnNames;

	public URLConnectionReader(String[][] columnStructure) {
		this.columnNames = columnStructure;
	}
	
	public RowOfData next(String stock) {
		String buffer[] = null;
		String strLine = null;

		try {
			strLine = getStock(stock);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		if (strLine == null)
			return null;

		strLine = strLine.replace("\"", "");
		buffer = strLine.split(",");

		RowOfData row = new RowOfData();
		for (int i = 0; i < columnNames.length; i++) {
			String name = columnNames[i][0];
			String type = columnNames[i][1];

			if (type.equals("number")) {
				try {
					double value = Double.parseDouble(buffer[i]);
					row.addData(name, value);
				} catch (Exception e) {
					
				}
			} else {
				row.addData(name, buffer[i]);
			}
		}

		return row;
	}

	public String getStock(String stock) throws IOException {
		URL yahoo = new URL("http://download.finance.yahoo.com/d/quotes.csv?s="
				+ stock + "&f=sl1d1t1c1ohgv&e=.csv");
		URLConnection yc = yahoo.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()));

		String inputLine = in.readLine();

		in.close();

		return inputLine;
	}

	public static void main(String[] args) throws Exception {
		String row = null;

		try {
			row = (new URLConnectionReader(null)).getStock("INTC");
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}

		System.out.println(row);
	}
}
