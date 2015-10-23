package edu.calstatela.cs.cs202.srice.lab5;

import edu.calstatela.cs.cs202.srice.lab3.DataContainer;

class Canvas {

	private int width, height;
	private int startPoint;
	private int stepSize;
	private DataContainer dc = null;
	private int[][] matrix;
	
	Canvas(int width, int height, int startPoint, int stepSize)
	{
		this.width = width;
		this.height = height;
		this.startPoint = startPoint;
		this.stepSize = stepSize;
	}
	Canvas()
	{
		this(500, 400, 0, 1);
	}
	public static void normalize()
	{
		
	}
	void setDataContainer(DataContainer dc)
	{
		this.dc = dc;
	}
	void bucketize(String columnName)
	{
		//get dso for time column from dc
		
		//get dso for columnname, eg "volume" or "price"
	
		//for each x = 0 ... width {
		//while( timeof time[i] is between time[i] + stepSize
		//  sumOfBucket = value[i]
		//for j = 0 < sumOfBucket
		//  mat[x][j] = color
	}

}
