import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	
	public static int numAccounts = 0;
	public static double totalHoldings = 0;
	
	private static String generateAccountNumba() {
		String str = "";
		Random r = new Random();
		for(int i = 0 ; i < 10 ; i ++) {
			str += r.nextInt(10);
			// nextInt(num) generates a random number between 0 and num
		}
		return str;
	}
	
	public BankAccount() {
		this.accountNumber = BankAccount.generateAccountNumba();
		this.checkingBalance = 0.0;
		this.savingsBalance = 0.0;
		
		numAccounts ++;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public static int getNumAccounts() {
		return numAccounts;
	}

	public static void setNumAccounts(int numAccounts) {
		BankAccount.numAccounts = numAccounts;
	}

	public static double getTotalHoldings() {
		return totalHoldings;
	}

	public static void setTotalHoldings(double totalHoldings) {
		BankAccount.totalHoldings = totalHoldings;
	}
	
	
}
