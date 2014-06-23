import java.util.Random;

public class Craps {
	public static void main(String[] args) {
		int die1, die2, sum;
		Random randGen = new Random();
		
		die1 = randGen.nextInt(6) + 1;
		die2 = randGen.nextInt(6) + 1;
		sum = die1 + die2;
		
		System.out.println("Roll: " + die1 + " " + die2);
		System.out.println();
		
		if (sum == 2) {
			System.out.println("Snake Eyes!");
		}
		else if (sum == 3){
			System.out.println("Ace-Deuce");
		}
		else if (sum == 12){
			System.out.println("Boxcars");
		}
		else{
			System.out.println("You are not a winner.");
		}
	}

}
