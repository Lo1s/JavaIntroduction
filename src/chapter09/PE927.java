/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 4. 7. 2014 2014 8:45:57 
 */
public class PE927 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TTATGTTTTAAGGATGGGGCGTTAGTT
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a genome string: ");
		String genome = input.next();
		findGene(genome);

	}
	// Finds the all possible genes within the genome
	public static void findGene(String genome) {
		String[] triplets = new String[] {"ATG", "TAG", "TAA", "TGA"};
		int countPos = 0;
		int numberOfGenes= 0;
		for (int i = 0; i < genome.length() - 3; i++) {		
			if (genome.substring(i, (i + 3)).equals(triplets[0]))
				for (int k = (i + 3); k < genome.length() && 
						(!genome.substring(k, (k + 3)).equals(triplets[1]) && 
								!genome.substring(k, (k + 3)).equals(triplets[2]) &&
								!genome.substring(k, (k + 3)).equals(triplets[3])); k++)
					countPos++;
			if (countPos > 0 && countPos % 3 == 0) {
				String gene = genome.substring((i + 3), ((i + 3) + countPos));
				System.out.println(gene);
				numberOfGenes++;
				countPos = 0;
			}
		}
		if (numberOfGenes == 0)
			System.out.println("no gene is found");
	}
}
