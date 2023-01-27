import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class passMaker {
	private int passLength;
	private int nonLetter;
	private passWallet currentWallet;
	private Scanner in = new Scanner(System.in);
	
	public passMaker() {
		passLength = 10;
		nonLetter = 3;
		currentWallet = new passWallet();
	}
	
	public passMaker(passWallet wallet) {
		passLength = 10;
		nonLetter = 3;
		currentWallet = wallet;
	}
	
	public void passMakerMain() {
		boolean keepAsking = true;
		while (keepAsking) {
			System.out.println("Welcome to Pass Maker! Please select an option");
			System.out.println("1. Set new password for account.");
			System.out.println("2. Exit");
			int option = in.nextInt();
			in.nextLine();
			
			switch (option) {
			case 1:
				System.out.println("Setting new password...");
				genPass();
				break;
			case 2:
				System.out.println("Exiting Pass Maker");
				keepAsking = false;
				break;
			default:
				System.out.println("Invalid option. Try again.");
				break;
			}
			
			System.out.println("Leave wallet? (Y or N)");
			String response = in.nextLine();
			if (response.equals("Y")) {
				keepAsking = false;
			}
		}
	}
	
	//TODO: Display account title and password
	public void genPass () {
		String generatedPass = randomPass();
		System.out.println("Enter account title: ");
		String inputAccount = in.nextLine();
		
		currentWallet.setPass(inputAccount, generatedPass);
		
		System.out.println("Password for " + inputAccount + " set to " + generatedPass);
	}
	
	
	public String randomPass () {
		String generatedPass = "";
		int [] nonletterPlaces = getRandomPlaces();
		int nonletterCounter = 0;
		Random r = new Random();
		
		for (int i = 0; i < passLength; i++) {
			if (i == nonletterPlaces[nonletterCounter]) {
				int genInt = (int) (Math.random() * 9);
				String convertedInt = Integer.toString(genInt);
				generatedPass = generatedPass + convertedInt;
				if (nonletterCounter < 2) {
					nonletterCounter++;
				}
			}
			char genChar = (char) (r.nextInt(26) + 'a');
			String convertedChar = Character.toString(genChar);
			generatedPass = generatedPass + convertedChar;
		}
		
		return generatedPass;
		
	}
	
	public int [] getRandomPlaces () {
		int [] places = new int [3];
		System.out.print("random places: ");
		
		for (int i = 0; i < places.length; i++) {
			places[i] = (int) (Math.random() * passLength);
			System.out.print(places[i] + " ");
		}
		
		Arrays.sort(places);
		
		return places;
	}
}

