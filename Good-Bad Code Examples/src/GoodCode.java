/*
 * GoodCode.java
 * 
 * This code prints digits of the fibinacci sequence using good Java style
 * 
 * AP Computer Science
 * Class Work - Java Style
 * 9/4/08
 * 
 */

public class GoodCode {

	public static void main(String[] args) {
		
		int N = 10; // number of elements in Fibinacci sequence to print
		
		// these two vars store the most recent elements of the sequence
		int element1 = 0;
		int element2 = 1;
		
		// print first element
		System.out.println(element1);
		
		
		// loop through elements and print each to console
		for(int c = 0; c < N; c++){
			System.out.println(element2);
			
			// calculate the next element in the sequence
			int temp = element1;
			element1 = element2;
			element2 = temp + element2;
		}

	}

}
