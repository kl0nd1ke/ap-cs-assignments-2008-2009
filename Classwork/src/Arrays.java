
public class Arrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] doubArray = new double[11];
		
		for(int i = 1; i < doubArray.length - 1; i++){
			doubArray[i] = 1.0 / i;
			System.out.print(doubArray[i] + " ");
			doubArray[10] += doubArray[i];
		}
		System.out.println(doubArray[10]);
		
	}

}
