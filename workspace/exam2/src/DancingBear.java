//Scott Rice
//Cin: 301161515
public class DancingBear {
	public static void main(String[] args) {
		SweetHoney sh = new SweetHoney(10);
		try
		{
			sh.eat(-10);
		}
		catch(IllegalArgumentException iae)
		{
			System.out.println(iae.getMessage());
			System.exit(-1);
		}
	}

}
