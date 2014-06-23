/*
 * RunTimeError.java
 * 
 * This code gives an example of a run time error
 * 
 * AP Computer Science
 * Class Work - Compile Time Error Example
 * 9/8/08
 * 
 */

public class RunTimeError {
	public static void main(String[] args)
	{
		int N = 10; // number of elements in Fibinacci sequence to print
		int[] Fib = new int[N];
		
		Fib[0] = 0;
		Fib[1] = 1;
		
		// print first element
		System.out.println(Fib[0]);
		
		
		// loop through elements and print each to console
		for(int c = 2; c < N; c++)
		{
			
			// calculate the next element in the sequence
			Fib[c] = Fib[c-1] + Fib[c-2];
			    
			System.out.println(Fib[c]);
		}

	}
}
