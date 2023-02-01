import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		PassWallet wallet = new PassWallet();
		PassMaker maker = new PassMaker(wallet);
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
				System.out.println();
				maker.passMakerMain();
				break;
			case 2:
				System.out.println();
				wallet.passWalletMenu();
				break;
			case 3:
				System.out.println();
				runProgram = false;
				break;
			default:
				System.out.println("Invalid Option. Try Again");
				break;
			}
		}
	}

}
