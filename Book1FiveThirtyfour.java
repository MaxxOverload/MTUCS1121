import java.util.Scanner;

/*
* Michigan Technological University CS1121 Problem 5-34
* Rewriting PrintCalendar.java using Zeller's 
* algorithm
*/
public class Book1FiveThirtythree {
	/*
	* Main method
	*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Prompt the user to enter year
		System.out.print("Enter full year (e.g., 2001): ");
		int year = input.nextInt();
		
		// Prompt the user to enter month
		System.out.print("Enter month in number between 1 and 12: ");
		int month = input.nextInt();
		
		// Print calendar for the month of the year
		printMonth(year, month);
	}
	
	/*
	* Print the calendar for a month in a year
	*/
	public static void printMonth(int year, int month) {
		// Print the headings of the calendar
		printMonthTitle(year, month);
		
		// Print the body of the calendar
		printMonthBody(year, month);
	}
	
	/*
	* Print the month title, e.g., May, 1999
	*/
	public static void printMonthTitle(int year, int month) {
		System.out.println("         " + getMonthName(month) + " " + year);
		System.out.println("-------------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}
	
	/*
	* Get the English name for the month
	*/
	public static String getMonthName(int month) {
		String monthName = " ";
		switch (month) {
			case 1: monthName = "January"; break;
			case 2: monthName = "February"; break;
			case 3: monthName = "March"; break;
			case 4: monthName = "April"; break;
			case 5: monthName = "May"; break;
			case 6: monthName = "June"; break;
			case 7: monthName = "July"; break;
			case 8: monthName = "August"; break;
			case 9: monthName = "September"; break;
			case 10: monthName = "October"; break;
			case 11: monthName = "November"; break;
			case 12: monthName = "December";
		}
		
		return monthName;
	}
	
	/*
	* Print month body
	*/
	public static void printMonthBody(int year, int month) {
		// Get start day of the week for the first date in the month
		int startDay = (int)getDayOfWeek(year, month, 1);
		
		// Get number of days in the month
		int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
		
		// Pad space before the first day in the month
		for (int i = 1; i < startDay; i++)
		  System.out.print("    ");
		
		for (int i = 1; i < numberOfDaysInMonth + 1; i++) {
			System.out.printf("%4d", i);
			
			if (((i - 1) + startDay) % 7 == 0)
				System.out.println();
		}
		
		System.out.println();
	}
	
	/*
	* Get the number of days in a month
	*/
	public static int getNumberOfDaysInMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 ||
				month == 8 || month == 10 || month == 12)
			return 31;
		if (month == 4 || month == 6 || month == 9 || month == 11)
			return 30;
		
		if (month == 2) return isLeapYear(year) ? 29 : 28;
		
		return 0; // If month is incorrect
	}
	
	/*
	* Determine if it is a leap year
	*/
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
	
	/*
	* Use Zeller's congruence to calculate the day of the week 
	*/
	public static double getDayOfWeek(int year, int month, int day) {
		if (month == 1) {
			month = 13;
			year -= 1;
		}
		else if (month == 2) {
			month = 14;
			year -= 1;
		}
		
		double h = (day + Math.floor((13.0 * ((double)month + 1.0) ) / 5.0) + ((double)year % 100.0)
			+ Math.floor(((double)year % 100.0) / 4.0) + Math.floor(Math.floor((double)year / 100.0) / 4.0) 
			- (2.0 * Math.floor((double)year / 100.0) ) ) % 7.0;
			
		if (h == 0)
			h = 7;
		
		return h;
	}
}