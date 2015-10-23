//Scott Rice
//301161515

public class NumberCell extends DataCell {
	double value;
	
	NumberCell(String cellName, double value) {
		super("number", cellName);
		setCellValue(value);
	}

	NumberCell(double value) {
		this("undefined", value);
		setCellValue(value);
	}
	
	NumberCell() {
		this("undefined", 0.0);
	}
	
	public void setCellValue(double value) {
		this.value = value;
	}
	
	public double getCellValue() {
		return value;
	}
	
}
