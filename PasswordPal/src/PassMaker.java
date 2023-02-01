import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class PassMaker {
	private int passLength;
	private int nonLetter;
	private PassWallet currentWallet;
	private Scanner in = new Scanner(System.in);
	
	//Make a password with uninitialized wallet
	public PassMaker() {
		passLength = 10;
		nonLetter = 3;
		currentWallet = new PassWallet();
	}
	
	//Make a password for initialized wallet
	public PassMaker(PassWallet wallet) {
		passLength = 10;
		nonLetter = 3;
		currentWallet = wallet;
	}
	
	//Main menu for PassMaker
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
				System.out.println();
				genPass();
				break;
			case 2:
				System.out.println();
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
	
	//Enters account name and password to wallet
	public void genPass () {
		String generatedPass = randomPass();
		System.out.print("Enter account title: ");
		String inputAccount = in.nextLine();
		
		currentWallet.setPass(inputAccount, generatedPass);
		System.out.println("Password for " + inputAccount + " set to " + generatedPass);
	}
	
	//Generates random password with characteristics defined in class attributes
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
	
	//Calculates where non-letters will be in password
	public int [] getRandomPlaces () {
		int [] places = new int [3];
		
		for (int i = 0; i < places.length; i++) {
			places[i] = (int) (Math.random() * passLength);
		}
		Arrays.sort(places);
		return places;
	}
}


