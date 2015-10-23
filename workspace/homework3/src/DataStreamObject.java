//Scott Rice
//301161515

public class DataStreamObject {
	String columnName;
	double[] dataArray = null;
	private static final int MAX = 10000;
	
	// default constructor
	DataStreamObject() {
		dataArray = new double[MAX];
	}

	String getColumnName() {
		return columnName;
	}
	
	double[] getDataArray() {
		return dataArray;
	}

	public CanvasData getCanvasData(int width, int height, int startingPoint) {
		double min = computeMin(startingPoint, startingPoint + width);
		double max = computeMax(startingPoint, startingPoint + width);
		
		CanvasData cd = new CanvasData(width);
		cd.zero();
		
		for (int i = 0; i < width; i++) {
			double y = this.dataArray[startingPoint + i];
			double yPrime;
			if(min != max)
			{
				yPrime = height * ( y - min)/(max - min);
			}
			else
			{
				yPrime = height * ( y - min)/(min);	
			}
	
			cd.dataArray[i] = yPrime;
		}
		
		return cd;
	}
	
	// need to fill in standard max, min functions here
	private double computeMin(int x, int x2) {
		double min = Double.MAX_VALUE;
		for (int i = x; i < x2; i++)
			min = (min < dataArray[i] ? min : dataArray[i]);
		
		return min;
	}

	private double computeMax(int x, int x2) {
		double max = -Double.MAX_VALUE;
		for (int i = x; i < x2; i++)
			max = (max > dataArray[i] ? max : dataArray[i]);
		
		return max;
	}
}
