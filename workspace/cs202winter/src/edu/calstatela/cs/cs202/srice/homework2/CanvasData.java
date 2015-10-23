package edu.calstatela.cs.cs202.srice.homework2;

import java.util.Random;

public class CanvasData {
	double[] dataArray = null;

	private void RandomFill(int nz) {
		Random r = new Random();

		dataArray = new double[nz];
		for (int i = 0; i < nz; i++)
			dataArray[i] = r.nextDouble() * 100;
	}

	public CanvasData(int nz) {
		RandomFill(nz);
	}

	public CanvasData() {
		this(100);
	}

	public double[] getDataArray() {
		return dataArray;
	}

}
