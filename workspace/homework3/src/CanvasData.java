//Scott Rice
//301161515

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

	public void zero() {
		for (int i = 0; i < dataArray.length; i++)
			dataArray[i] = 0.0;
	}
	
	public CanvasData() {
		this(100);
	}

	public double[] getDataArray() {
		return dataArray;
	}

	public void printValues() {
		for (int i = 0; i < dataArray.length; i++) {
			System.out.println(dataArray[i]);
		}
	}

}
