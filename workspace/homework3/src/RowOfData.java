//Scott Rice
//301161515

public class RowOfData {
	java.util.ArrayList<DataCell> cells;
	
	public RowOfData() {
		cells = new java.util.ArrayList<DataCell>();
	}
	
	public void addData(String name, double value) {
		NumberCell cell = new NumberCell(name, value);
		cells.add(cell);
	}
	
	public void addData(String name, String value) {
		StringCell cell = new StringCell(name, value);
		cells.add(cell);
	}
	
	double getDouble(String cellName) {
		for (DataCell cell : cells) {
			if (cell.getCellName().equals(cellName))
				return (double) ((NumberCell)cell).getCellValue();
		}
		
		return 0.0;
	}
	
	String getString(String cellName) {
		for (DataCell cell : cells) {
			if (cell.getCellName().equals(cellName))
				return (String) ((StringCell)cell).getCellValue();
		}
		
		return new String("");
	}
	
	public void print() {
		
		for (DataCell cell : cells) {
			System.out.printf("%s [%s] = ", cell.getCellName(), cell.getCellType());
			if (cell.getCellType().equals("number")) {
				System.out.printf("%.2f\n", ((NumberCell)cell).getCellValue());
			} else {
				System.out.printf("%s\n", ((StringCell)cell).getCellValue());
			}	
		}
		
		System.out.println("");
	}
	
}
