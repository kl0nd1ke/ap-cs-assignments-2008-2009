import java.util.ArrayList;
import java.util.Random;

public class ArrayLists {
	public static void main(String[] args) {
		ArrayList<Integer> testAL = new ArrayList<Integer>();
		
		int maxNum = 5;
		Random randGen = new Random();
		
		for(int i = 0; i < maxNum; i++){
			testAL.add(randGen.nextInt(maxNum) + 1);
		}
		
		/*
		for(int i = 0; i < testAL.size(); i++){
			System.out.print(testAL.get(i) + " ");
		}
		*/
		
		// The 'for each' loop (remember that it is read-only)
		for(Integer i: testAL){
			System.out.print(i + " ");
		}
		
	}

}
