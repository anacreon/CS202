package edu.calstatela.cs.cs202.srice.homework1;
//Name: Scott Rice
//CIN: 301161515

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

class FileRead {
	FileInputStream fstream;
	DataInputStream in;
	BufferedReader br;
	
	public FileRead(String filename) {
		try {
			fstream = new FileInputStream(filename);
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
	
	public String[] next() {
		String buffer[] = null;
		String strLine = null;
		
		try {
			strLine = br.readLine();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

		if (strLine == null)
			return buffer;
		
     // split strLine into buffer
		buffer = strLine.split(",");
		return buffer;
	}
}
