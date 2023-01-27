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
			
			switch (option) {
			case 1:
				passMake();
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
	public void passMake () {
		System.out.println("Enter account title: ");
		String inputAccount = in.nextLine();
		
		
		currentWallet.setPass(inputAccount, "");
		
		System.out.println("Password for " + inputAccount + " set to " + "");
	}
	
	//TODO: Have it generate pass character by character
	public String randomPass () {
		String generatedPass = "";
		int [] nonletterPlaces = getRandomPlaces();
		int nonletterCounter = 0;
		Random r = new Random();
		
		for (int i = 0; i < passLength; i++) {
			if (i == nonletterPlaces[nonletterCounter]) {
				int genInt = (int) Math.random() * 9;
			}
		}
		
		return generatedPass;
		
	}
	
	public int [] getRandomPlaces () {
		int [] places = new int [3];
		
		for (int i = 0; i < places.length; i++) {
			places[i] = (int) Math.random() * passLength;
		}
		
		return places;
	}
}
