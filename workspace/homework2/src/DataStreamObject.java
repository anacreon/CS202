
public class DataStreamObject {
	String columnName;
	double[] doubleArray = null;
	String[] StringArray = null;
	private static final int MAX = 10000;
	
	// default constructor
	DataStreamObject() {
		doubleArray = new double[MAX];
		StringArray = new String[MAX];
	}

	String getColumnName() {
		return columnName;
	}
	
	double[] getDoubleArray() {
		return doubleArray;
	}
    String[] getStringArray()
    {
    	return StringArray;
    }
	public CanvasData getCanvasData(int width, int height, int startingPoint) throws ArrayIndexOutOfBoundsException 
	{
		if((startingPoint + width) > doubleArray.length)
		{
			throw new ArrayIndexOutOfBoundsException("The starting point and/or width exceed the length of the array");
		}
		else
		{
			double min = computeMin(startingPoint, startingPoint + width);
			double max = computeMax(startingPoint, startingPoint + width);
		
			CanvasData cd = new CanvasData(width);
				cd.zero();
		
			for (int i = 0; i < width; i++) {
				double y = this.doubleArray[startingPoint + i];
				double yPrime = height * ( y - min)/(max - min);
	
				cd.dataArray[i] = yPrime;
			}
		
			return cd;
		}
	}
	// need to fill in standard max, min functions here
	private double computeMin(int x, int x2) {
		double min = Double.MAX_VALUE;
		for (int i = x; i < x2; i++)
			min = (min < doubleArray[i] ? min : doubleArray[i]);
		
		return min;
	}

	private double computeMax(int x, int x2) {
		double max = -Double.MAX_VALUE;
		for (int i = x; i < x2; i++)
			max = (max > doubleArray[i] ? max : doubleArray[i]);
		
		return max;
	}
}
