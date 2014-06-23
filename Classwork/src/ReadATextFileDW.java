import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadATextFileDW {

	public static void main(String[] args) {
		String fileLocation = "C:\\Users\\LBBD\\Desktop\\Testtextfile.txt";
		String errorMsg = "File not found.";
		File myFile = new File(fileLocation);
		Scanner myScanner = null;
		
		try{
			myScanner = new Scanner(myFile);
		}
		catch(FileNotFoundException exception){
			System.out.println(errorMsg);
			System.exit(1);
		}
		while(myScanner.hasNextLine()){
			System.out.println(myScanner.nextLine());
		}
	}

}
