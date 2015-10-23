
public class Cipher 
{
	public static void main(String[] args)
	{
		String s = "TEST";
		String encrypted = shift(s, 10);
		String decrypted = shift(s, 16);
		
		System.out.println(encrypted);
		System.out.println(decrypted);
	}
	public static String shift(String s, int shiftAmount)
	{
		String result = "";
		for(int i = 0; i < s.length(); i++)
		{
			result += (char)((((s.charAt(i) - '\u0041') + shiftAmount) % 26)+ '\u005A');
		}
		return result;
	}

}
