import java.util.Scanner;

public class DayOfTheWeekBroken {

	public static void main(String[] args) {
		/*
		// Initialize scanner
		Scanner keyboard = new Scanner(System.in);
		
		// Ask user for date and initialize variables
		System.out.println("Please enter a date in the format mm/dd/yyyy.");
		String dateenteredstr = keyboard.nextLine();
		String inputstr = dateenteredstr.replace("/", "");
		int mm = 0;
		int dd = 0;
		int yy = 0;
		int dateconcat = 0;
		String dateconcatstr = null;
		
		// Validate the date entered by: string length, presence of "/" in mm/dd/yyyy, and numerical nature of mm, dd, and yy
		for(int i = 0; i < 1; i++){
			if(dateenteredstr.length() > 10 || dateenteredstr.length() < 10 || !(dateenteredstr.substring(2,3).equals("/")) || !(dateenteredstr.substring(5,6).equals("/"))){
				i = 0;
				String errorstr = "JUNKJUNK";
				dateconcat = checkIfInt(errorstr, "The date you entered is not in the correct format. Please enter a valid date in the format mm/dd/yyyy.");
			}
			else{
				dateconcat = 0;
				dateconcat = checkIfInt(inputstr, "The date you entered is not in the correct format. Please enter a valid date in the format mm/dd/yyyy.");
				
			}
		}
		dateconcatstr = Integer.toString(checkIfInt(inputstr, "The date you entered is not in the correct format. Please enter a valid date in the format mm/dd/yyyy."));
		mm = Integer.parseInt(dateconcatstr.substring(0,2));
		dd = Integer.parseInt(dateconcatstr.substring(2,4));
		yy = Integer.parseInt(dateconcatstr.substring(4,8));
		
		// Jan Mar May Jul Aug Oct Dec 31
		// 1   3   5   7   8   10  12
		// Apr Jun Sep Nov 30
		// 4   6   9   11
		// Feb 29
		// 2
		
		/*if (mm == ){
			
		}
		else{
			
		}
		
		System.out.println(mm + " " + dd + " " + yy);
		*/
	}

	public static int checkIfInt(String inputstr, String displaytext) {

		// Initialize scanner
		Scanner keyboard = new Scanner(System.in);

		int inputint;

		// Loop to check if input is an integer using try-catch; every time an
		// error is thrown we reset the loop
		for (int i = 0; i < 2; i++) {
			try {
				inputint = Integer.parseInt(inputstr);
			} 
			catch (NumberFormatException exception) {
				System.out.println(displaytext);
				i = 0;
				inputstr = keyboard.nextLine();
				String substringmm = inputstr.substring(0,2);
				String substringdd = inputstr.substring(3,5);
				String substringyy = inputstr.substring(6,10);
				inputstr = substringmm + substringdd + substringyy;
			}
			if(inputstr.length() > 10 || inputstr.length() < 10 || !(inputstr.substring(2,3).equals("/")) || !(inputstr.substring(5,6).equals("/"))){
				i = 0;
				inputstr = "JUNKJUNK";
			}
		}

		// Once loop is over we know that the input is an integer, so we can
		// assign its value to our int
		inputint = Integer.parseInt(inputstr);

		return inputint;
	}
	public static int checkIfValidDate(int mm, int dd, int yy) {

		// Initialize scanner
		Scanner keyboard = new Scanner(System.in);

		int inputint = 0;

		// Loop to check if input is an integer using try-catch; every time an
		// error is thrown we reset the loop
		
		/*for(int i = 0; i < 1; i++){
			if(dateenteredstr.length() > 10 || dateenteredstr.length() < 10 || !(dateenteredstr.substring(2,3).equals("/")) || !(dateenteredstr.substring(5,6).equals("/"))){
				i = 0;
				String errorstr = "JUNKJUNK";
				dateconcat = checkIfInt(errorstr, "The date you entered is not in the correct format. Please enter a valid date in the format mm/dd/yyyy.");
			}
			else{
				dateconcat = 0;
				dateconcat = checkIfInt(inputstr, "The date you entered is not in the correct format. Please enter a valid date in the format mm/dd/yyyy.");
				
			}
		} 
		
		for (int i = 0; i < 1; i++) {
			if(((mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) && dd != 31) || ((mm == 4 || mm == 6 || mm == 9 || mm == 11) && dd != 30) || (mm == 2 && (dd != 28 && dd != 29))){
				i = 0;
				String errorstr = "JUNKJUNK";
				//dateconcat = checkIfInt(errorstr, "The date you entered is not in the correct format. Please enter a valid date in the format mm/dd/yyyy.");

			}
			else{
			}
			switch(mm){
			case 1:
				break;
				
			}
			try {
				inputint = Integer.parseInt(inputstr);
			} 
			catch (NumberFormatException exception) {
				System.out.println(displaytext);
				i = 0;
				inputstr = keyboard.nextLine();
				String substringmm = inputstr.substring(0,2);
				String substringdd = inputstr.substring(3,5);
				String substringyy = inputstr.substring(6,10);
				inputstr = substringmm + substringdd + substringyy;
			}
		}*/

		// Once loop is over we know that the input is an integer, so we can
		// assign its value to our int
		//inputint = Integer.parseInt(inputstr);

		return inputint;
	}
	public static int checkFormat(String inputstr, String displaytext) {

		// Initialize scanner
		Scanner keyboard = new Scanner(System.in);

		int inputint = 0;

	for(int i = 0; i < 1; i++){
		if(inputstr.length() > 10 || inputstr.length() < 10 || !(inputstr.substring(2,3).equals("/")) || !(inputstr.substring(5,6).equals("/"))){
			i = 0;
			String errorstr = "JUNKJUNK";
			//dateconcat = checkIfInt(errorstr, "The date you entered is not in the correct format. Please enter a valid date in the format mm/dd/yyyy.");
		}
		else{
			//dateconcat = 0;
			//dateconcat = checkIfInt(inputstr, "The date you entered is not in the correct format. Please enter a valid date in the format mm/dd/yyyy.");
			
		}
		//dateconcatstr = Integer.toString(dateconcat);
		//mm = Integer.parseInt(dateconcatstr.substring(0,2));
		//dd = Integer.parseInt(dateconcatstr.substring(2,4));
		//yy = Integer.parseInt(dateconcatstr.substring(4,8));
}
	return inputint;
	}
}
