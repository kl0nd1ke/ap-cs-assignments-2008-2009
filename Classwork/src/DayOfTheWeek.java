import java.util.Scanner;

public class DayOfTheWeek {

	public static void main(String[] args) {
		
		// Initialize scanner
		Scanner keyboard = new Scanner(System.in);
		
		// Ask user for date and initialize variables
		System.out.println("Please enter a date in the format mm/dd/yyyy.");
		String dateenteredstr = keyboard.nextLine();
		System.out.println(checkIfInt(dateenteredstr, "The date you entered is not in the correct format. Please enter a valid date in the format mm/dd/yyyy."));
	}
	public static int checkIfInt(String inputstr, String displaytext) {

		// Initialize scanner
		Scanner keyboard = new Scanner(System.in);

		int inputint;
		String substringmm = null;
		String substringdd = null;
		String substringyy = null;

		// Loop to check if input is an integer using try-catch; every time an
		// error is thrown we reset the loop
		for (int i = 0; i < 2; i++) {
			if(inputstr.length() > 10 || inputstr.length() < 10 || !(inputstr.substring(2,3).equals("/")) || !(inputstr.substring(5,6).equals("/"))){
				i = 0;
				inputstr = "JUNKJUNK";
			}
			else{
			substringmm = inputstr.substring(0,2);
			substringdd = inputstr.substring(3,5);
			substringyy = inputstr.substring(6,10);
			inputstr = inputstr.replace("/", "");
			i++;
			}
			try {
				inputint = Integer.parseInt(inputstr);
			} 
			catch (NumberFormatException exception) {
				System.out.println(displaytext);
				i = 0;
				inputstr = keyboard.nextLine();
				/*substringmm = inputstr.substring(0,2);
				substringdd = inputstr.substring(3,5);
				substringyy = inputstr.substring(6,10);
				inputstr = substringmm + substringdd + substringyy; */
			}
			//inputstr = substringmm + "/" + substringdd + "/" + substringyy;
			
		}

		inputstr = inputstr.replace("/", "");
		
		// Once loop is over we know that the input is an integer, so we can
		// assign its value to our int
		inputint = Integer.parseInt(inputstr);

		return inputint;
	}
	public static int checkIfValidDate(int mm, int dd, int yy) {
		
		for (int i = 0; i < 1; i++) {
			if(((mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) && dd != 31) || ((mm == 4 || mm == 6 || mm == 9 || mm == 11) && dd != 30) || (mm == 2 && (dd != 28 && dd != 29))){
				i = 0;
				String errorstr = "JUNKJUNK";
				mm = checkIfInt(errorstr, "The date you entered is not in the correct format. Please enter a valid date in the format mm/dd/yyyy.");
			}
		}
		return mm;
	}
}