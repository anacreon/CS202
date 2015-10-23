package edu.calstatela.cs.cs202.srice.homework2;

public class StringCell extends DataCell {
	String value;
	
	StringCell(String cellName, String value) {
		super("string", cellName);
		setCellValue(value);
	}

	StringCell(String value) {
		this("undefined", value);
		setCellValue(value);
	}
	
	StringCell() {
		this("undefined", "");
	}

	public void setCellValue(String value) {
		this.value = value;
	}
	
	public String getCellValue() {
		return value;
	}
	
}
