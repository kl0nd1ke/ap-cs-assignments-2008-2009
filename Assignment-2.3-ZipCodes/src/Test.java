
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZipCodesData zd = new ZipCodesData("PartialUnsortedZipData.csv");
		//zd.printUnsortedZipCodes();
		
		zd.printUnsortedZipCodes();
		//zd.insertionSort();
		zd.mergeSort();
		zd.printSortedZipCodes();
		zd.binarySearch("76930");
	}

}
