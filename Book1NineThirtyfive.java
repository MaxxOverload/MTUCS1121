import java.util.Scanner;

/*
* Michigan Technological University CS1121 Problem 9-35
* Bioinformatics: Finding genes in a genome string
*/
public class Book1NineThirtyfive {
	/*
	* Main method
	*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a genome string: ");
		String genomeSequence = input.nextLine();
		
		/* Debugging */
		
		findGenes(genomeSequence);
	}
	
	/*
	* Find the genes in the genome
	*/
	public static void findGenes(String genome) {
		String potentialGene = " ";
		
		// Scan the entire genome sequence for a starting triplet "ATG"
		for (int i = 0; i < genome.length() - 2; i++) {
			
			// If a starting triplet is found, begin scanning for an ending triplet
			if (genome.substring(i, i + 3).equals("ATG") ) {
				
				// Begin scanning for an ending triplet here and obtain the genome substring
				for (int j = i + 3; j < genome.length() - 2; j++) {
					// If an ending triplet is found, confirm the potential gene meets the right conditions
					if (isEndingTriplet(genome.substring(j, j + 3) ) ) {
						
						if (!hasTriplet(genome.substring(i + 3, j) ) &&
							isCorrectLength(genome.substring(i + 3, j) ) ) {
							
							potentialGene = genome.substring(i + 3, j);
							System.out.println(potentialGene);
							
							break;
						}
					}
						
				}
			}
			
		}
		
		if (potentialGene.equals(" ") )
			System.out.println("no gene is found");
		
	}
	
	/*
	* Check if the length of a substring
	* is a correct amount (multiple of 3 and
	* greater than 0)
	*/
	public static boolean isCorrectLength(String genomeSubstring) {
		return genomeSubstring.length() % 3 == 0 && genomeSubstring.length() > 0;
	}
	
	/*
	* Determine if a substring contains a certain
	* triplet ("ATG", "TAG", "TAA", "TGA")
	*/
	public static boolean hasTriplet(String genomeSubstring) {
		return genomeSubstring.contains("ATG") || genomeSubstring.contains("TAG") ||
			genomeSubstring.contains("TAA") || genomeSubstring.contains("TGA");
	}
	
	/*
	* Determine if a triplet is an
	* ending triplet ("TAG", "TAA", 
	* "TGA")
	*/
	public static boolean isEndingTriplet(String triplet) {
		boolean isTriplet = false;
		
		if (triplet.equals("TAG") || triplet.equals("TAA") ||
			triplet.equals("TGA") )
			isTriplet = true;
		
		return isTriplet;
	}
	
}