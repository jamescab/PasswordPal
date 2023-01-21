import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class passWallet {
	private Map<String,String> wallet;
	
	public passWallet() {
		wallet = new HashMap<String,String>();
	}
	
	public void addPass(String account, String password) {
		wallet.put(account, password);
	}
	
	public String getPass(String account) {
		return wallet.get(account);
	}
	
	public void changePass(String account) {
		System.out.println("Current password for " + account + " is " + wallet.get(account));
		System.out.println("");
	}
}
