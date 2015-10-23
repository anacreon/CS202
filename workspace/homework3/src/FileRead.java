//Scott Rice
//301161515

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

class FileRead {
	private String[][] columnNames;
	FileInputStream fstream;
	DataInputStream in;
	BufferedReader br;
	
	public FileRead() {
		System.out.println("default constructor not allowed");
		System.exit(-1);
	}
	
	public FileRead(String dataFile, String[][] columnStructure) {
		try {
			fstream = new FileInputStream(dataFile);
			this.columnNames = columnStructure;
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public void Open() {
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));		
	}
	
	public void Close() {
		try {
			in.close();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public RowOfData next() {
		String buffer[] = null;
		String strLine = null;
		
		try {
			strLine = br.readLine();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
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
				double value = Double.parseDouble(buffer[i]);
				row.addData(name, value);
			} else {
				row.addData(name, buffer[i]);		
			}
		}
		
		return row;		
	}
}