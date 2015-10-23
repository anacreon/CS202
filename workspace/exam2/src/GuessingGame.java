import java.util.ArrayList;
import java.util.Scanner;


public class GuessingGame {


	public static void main(String[] args) {
		int n;
		int m;
		int k;
		int guess;
		Scanner input = new Scanner(System.in);
		System.out.println("What is the highest possible number you want?");
		m = input.nextInt();
		System.out.println("How many numbers do you want?");
		n = input.nextInt();
		System.out.println("How many guesses do you want?");
		k = input.nextInt();

		Integer numbers;
		ArrayList<Integer> game = new ArrayList<Integer>(n);
		
		for(int i = 0; i < n; i++)
		{
			numbers = 1 + (int)(Math.random() * m);
			game.add(i, numbers);
		}
		
		System.out.println("Try to guess some integers between 0 and " + (m+1)+ " not inclusive");
		for(int i = 0; i < k; i++)
		{
			guess = input.nextInt();
			if(game.indexOf(guess) > -1)
			{
				System.out.println("You guessed a correct number");
			}
			else
			{
				System.out.println("Try again");
			}
		}
		System.out.print("The numbers were: ");
		for(int i = 0; i < game.size(); i++)
		{
			System.out.print(game.get(i) + " ");
		}

	}

}
