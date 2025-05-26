/*
* Michigan Technological University CS1121 Problem 4-24
* Summing a series
*/
public class Book1FourTwentyfour {
	public static void main(String[] args) {
		int numerator = 1;
		int denominator = 3;
		double sum = 0.0;
		
		while (denominator < 100) {
			sum += (double)numerator / (double)denominator;
			
			numerator += 2;
			denominator += 2;
		}
		
		System.out.println(sum);
	}
}