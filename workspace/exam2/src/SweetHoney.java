//Scott Rice
//Cin: 301161515
public class SweetHoney {
	int totalWeight;

	public SweetHoney(int weight)
		{
			this.totalWeight = weight;
		}
	
	public void eat(int ounces) throws IllegalArgumentException
	{
		if(ounces >= 0)
		{
			for(int i =0; i < ounces; i++)
			{
				System.out.println("Yummy");
			}
			totalWeight -= ounces;
		}
		else
		{
			throw new IllegalArgumentException("Ounces cannot be negative");
		}
	}
}
