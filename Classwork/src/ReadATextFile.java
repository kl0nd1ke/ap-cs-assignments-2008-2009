import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ReadATextFile {
	
	public static void main(String[] args) throws IOException {
		readATextFile("C:\\Users\\LBBD\\Desktop\\Testtextfile.txt", args);
	}
	public static void readATextFile(String filePath, String[] args) throws IOException {
		Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(filePath)));
	        while (scanner.hasNextLine()) {
	           	System.out.print(scanner.nextLine()+ "\n");
            }
        } 
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
	}
}
