import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		passWallet wallet = new passWallet();
		passMaker maker = new passMaker(wallet);
		boolean runProgram = true;
		
		while (runProgram) {
			System.out.println("");
			System.out.println("Welcome to Password Pal! Please select an option.");
			System.out.println("1. Password Maker");
			System.out.println("2. Password Wallet");
			System.out.println("3. Exit");
			int answer = in.nextInt();
			
			switch(answer) {
			case 1:
				System.out.println("Opening password maker...");
				maker.passMakerMain();
				break;
			case 2:
				System.out.println("Opening password wallet...");
				wallet.passWalletMenu();
				break;
			case 3:
				System.out.println("Exiting Password Pal. Goodbye!");
				runProgram = false;
				break;
			default:
				System.out.println("Invalid Option. Try Again");
				break;
			}
		}
	}

}
