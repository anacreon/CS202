package edu.calstatela.cs.cs202.srice.homework2;

public class DataCell {
	String cellType;
	String cellName;

	DataCell() {
		this("undefined", "undefined");
	}

	DataCell(String cellType, String cellName) {
		this.cellType = cellType;
		this.cellName = cellName;
	}
	
	public String getCellType() {
		return cellType;
	}
	
	public String getCellName() {
		return cellName;
	}
}
