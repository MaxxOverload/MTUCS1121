import java.util.Scanner;

/*
* Michigan Technological University CS1121 Problem 7-17
* Financial tsunami
*/
public class Book1SevenSeventeen {
	/*
	* Main method
	*/
	public static void main(String[] args) {
		int n = 0; // Number of banks
		int limit = 0; // Limit where a bank is considered safe
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		limit = input.nextInt();
		
		double[] currentBalances = new double[n];
		double[][] borrowers = new double[n][n];
		
		for (int i = 0; i < n; i++) {
			// Get the first number in the line (the bank's initial balance)
			currentBalances[i] = input.nextDouble();
			
			// Get the number of borrowers for the bank
			int noOfBorrowers = input.nextInt();
			
			// Now get the information for the borrowers
			for (int j = 0; j < noOfBorrowers; j++) {
				int borrowerID = input.nextInt();
				borrowers[i][borrowerID] = input.nextDouble();
			}
			
		}
		
		double[] totalAssets = setAssets(currentBalances, borrowers);
		double[] finalAssets = setUnsafeBanks(limit, totalAssets, borrowers);
		
		System.out.print("Unsafe banks are ");
		
		for (int i = 0; i < finalAssets.length; i++) {
			if (finalAssets[i] == -1.0)
				System.out.print(i + " ");
		}
		
	}
	
	/*
	* Get the total assets of each bank
	* and set the values in the 'assets'
	* array
	*/
	public static double[] setAssets(double[] initialAssets, double[][] borrowers) {
		double[] finalAssets = new double[initialAssets.length];
		
		for (int i = 0; i < finalAssets.length; i++) {
			double rowTotal = 0.0;
			
			for (int j = 0; j < finalAssets.length; j++)
				rowTotal += borrowers[i][j];
			
			finalAssets[i] += initialAssets[i];
			finalAssets[i] += rowTotal;
		}
		
		return finalAssets;
	}
	
	/*
	* Find all of the unsafe banks
	* (by convention, an unsafe bank
	* will be set to -1)
	*/
	public static double[] setUnsafeBanks(int limit, double[] assets, double[][] borrowers) {
		int i = 0;
		
		while (i < assets.length) {
			if (assets[i] < (double)limit && assets[i] != -1.0) {
				assets[i] = -1.0;
				assets = getUpdatedAssets(i, assets, borrowers);
				borrowers = updateBorrowers(i, borrowers);
				i = 0; // If a bank is unsafe, start at the beginning to scan for more unsafe banks
			}
			
			else
				i++;
		}
		
		
		return assets;
	}
	
	/*
	* If a bank becomes unsafe, get all of
	* the loans lent to the other banks
	* and update the 'assets' array
	*/
	public static double[] getUpdatedAssets(int bankID, double[] initialAssets, double[][] borrowers) {
		double[] finalAssets = initialAssets;
		
		for (int i = 0; i < finalAssets.length; i++)
			finalAssets[i] -= borrowers[i][bankID];
		
		return finalAssets;
	}
	
	/*
	* Update the 'borrowers' array
	* if a bank is unsafe
	*/
	public static double[][] updateBorrowers(int bankID, double[][] borrowers) {
		for (int i = 0; i < borrowers[0].length; i++)
			borrowers[i][bankID] = 0.0;
		
		return borrowers;
	}
	
}