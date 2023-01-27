import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class passWallet {
	private Map<String,String> wallet;
	private Scanner in = new Scanner(System.in);
	
	public passWallet() {
		wallet = new HashMap<String,String>();
	}
	
	public void passWalletMenu() {
		boolean keepAsking = true;
		
		while (keepAsking) {
			System.out.println();
			System.out.println("Welcome to your password wallet! Please select an option:");
			System.out.println("1. See password wallet");
			System.out.println("2. Find password for an account");
			System.out.println("3. Change a password");
			int option = in.nextInt();
			
			switch (option) {
			case 1:
				displayWallet();
				break;
			case 2:
				findPass();
				break;
			case 3:
				changePass();
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
	
	public void setPass(String account, String password) {
		wallet.put(account, password);
	}
	
	public Map<String,String> getWallet() {
		return wallet;
	}
	
	public String getPass(String account) {
		return wallet.get(account);
	}
	
	public void displayWallet() {
		System.out.println("All accounts and passwords:");
		if (!wallet.isEmpty()) {
			wallet.forEach((account, password) -> {
				System.out.println(account + ": " + password);
			});
		}
	}
	
	public void findPass () {
		System.out.print("Please enter account for password: ");
		String checkAccount = in.nextLine();
		if (wallet.containsKey(checkAccount)) {
			System.out.println("Password for " + checkAccount + " is: " + wallet.get(checkAccount));
		} else {
			System.out.println("No account for this saved in wallet. Would you like to save a password for this account? (Y or N)");
			String answer = in.nextLine();
			if (answer.equals("Y")) {
				System.out.print("Enter password for this account: ");
				String createdPass = in.nextLine();
				wallet.put(checkAccount, createdPass);
				System.out.println("Password set for " + checkAccount + " account.");
			}
		}
	}
	
	public void changePass() {
		System.out.print("Which account do you want to update the password for?");
		String account = in.nextLine();
		System.out.println("Current password for " + account + " is " + wallet.get(account));
		System.out.println("Are you sure you'd like to change it? (Y or N)");
		String answer = in.nextLine();
		boolean keepAsking = true;
		while (keepAsking) {
			switch(answer) {
			case "Y":
				System.out.print("Enter new password: ");
				String newPass = in.nextLine();
				wallet.put(account, newPass);
				System.out.println("New password for " + account + " set to " + newPass);
				keepAsking = false;
				break;
			case "N":
				keepAsking = false;
				break;
			default:
				System.out.println("Please enter valid option");
			}
		}
	}
}

