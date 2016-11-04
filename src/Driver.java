import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	private Scanner input;

	private BruteAutocomplete autocomplete;

	public static void main(String[] args) {
		new Driver();
	}

	public Driver() {
		String prefix;
		int amountOfTerms = 10;
		input = new Scanner(System.in);

		autocomplete = new BruteAutocomplete();

		while(1 != 0){
		// Get the prefix from the user
		System.out.print("Input the prefix you want to display words with: ");
		prefix = input.nextLine();
		
		try {
		// Get the amount of words to display from the user as an int
		System.out.print("Amount of words you want to display: ");
		amountOfTerms = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Wrong input! \nDisplaying 10 words with the prefix:");
		}


		// display result
		//if only one term is to be displayed, call the faster bestMatch method.
		if(amountOfTerms == 1){
			System.out.print("["+autocomplete.bestMatch(prefix)+"]"+"\n\n");
		}
		else{
		System.out.print(autocomplete.matches(prefix, amountOfTerms)+"\n\n");
		}
		//fixes a bug where the user would have to press enter twice, surpresses a unused error associated with the fix
		@SuppressWarnings("unused") 
		String scannerfix = input.nextLine();
		}
		
	}

}
