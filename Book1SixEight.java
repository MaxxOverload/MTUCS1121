import java.util.Scanner;

/*
* Michigan Technological University CS1121 Problem 6-8
* Averaging arrays
*/
public class Book1SixThree {
	/*
	* Main method
	*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter ten double values: ");
		double[] numbers = new double[10];
		for (int i = 0; i <10; i++) {
			numbers[i] = input.nextDouble();
		}
		
		// Display the average
		System.out.print(average(numbers) );
		
	}
	
	/*
	* Get the average of an int array
	*/
	public static int average(int[] array) {
		int sum = 0;
		int average = 0;
		
		for (int number:array)
			sum += number;
		
		average = sum / 10;
		
		return average;
	}
	
	/*
	* Get the average of a double array
	*/
	public static double average(double[] array) {
		double sum = 0.0;
		double average = 0.0;
		
		for (double number:array)
			sum += number;
		
		average = sum / 10.0;
		
		return average;
	}
	
}