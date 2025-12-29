import java.util.Scanner;

/*
* Michigan Technological University CS1121 Problem 2-17
* Formula for wind chill
*/
public class Book1TwoSeventeen {
	public static void main(String[] args) {
		double outsideTemp = 0.0;
		double windSpeed = 0.0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the temperature in Fahrenheit: ");
		outsideTemp = input.nextDouble();
		System.out.print("Enter the wind speed miles per hour: ");
		windSpeed = input.nextDouble();
		
		// Use the NWS wind chill temperature formula given in the textbook
		double windChillTemp = 35.74 + (0.6215 * outsideTemp) - (35.75 * Math.pow(windSpeed, 0.16) )
			+ (0.4275 * outsideTemp * Math.pow(windSpeed, 0.16) );
		
		System.out.print("The wind chill index is " + windChillTemp);
	}
	
}