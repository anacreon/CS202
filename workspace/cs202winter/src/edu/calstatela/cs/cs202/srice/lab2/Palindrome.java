package edu.calstatela.cs.cs202.srice.lab2;

public class Palindrome {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  String s = "yobananaboy";
	  boolean a = isPalindrome(s);
	  if (a)
		  System.out.println("Yes! " + s + " is a palindrome");
	  else
		  System.out.println("No! " + s + " is not a palindrome");

	}
    public static boolean isPalindrome(String f)
    {
        char[] b = new char[f.length()];
        for(int i = 0; i < b.length; i++)
        {
        	b[b.length - 1 - i] = f.charAt(i);
        }
        String temp = String.valueOf(b);
        if(f.compareTo(temp) == 0)
    	    return true;
        else
        	return false;
    }
}