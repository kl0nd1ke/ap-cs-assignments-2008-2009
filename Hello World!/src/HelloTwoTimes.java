import java.util.Scanner;
 public class HelloTwoTimes
 {
	 public static void main(String[] args)
	 {
		 Scanner keyboard = new Scanner(System.in);
		 System.out.print("Enter an integer: ");
		 int n = keyboard.nextInt();
		 System.out.println("2 * " + n + " = " + (n + n));
	 }
 }