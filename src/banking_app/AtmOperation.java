package banking_app;

import java.util.HashMap;

class Atm{
	private double depositAmount;
	private double withdrawAmount;
	private double balanceAmount;
	public Atm(double depositAmount, double withdrawAmount, double balanceAmount) {
		super();
		this.depositAmount = depositAmount;
        this.withdrawAmount = withdrawAmount;
        this.balanceAmount = balanceAmount;
	}
	public Atm() {
		super();
	}
	public double getDepositAmount(){
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public double getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	public double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
}

interface AtmOperationInterf {
	void deposit(double depositAmount) throws Exception;
	void withdraw(double withdrawAmount) throws Exception;
	void viewBalance() throws Exception;
	void viewMiniStatement() throws Exception;
	void exit() throws Exception;
}


public class AtmOperation  implements AtmOperationInterf{
	Atm atm = new Atm();
	HashMap<Double, String> hm = new HashMap<Double, String>();
	public void deposit(double depositAmount) throws Exception{
		if(depositAmount % 100 == 0) {
			Thread.sleep(3000);
			hm.put(depositAmount, ":Deposited");
			System.out.println("Rs." + depositAmount + "/- has been deposited successfully!!");
			Thread.sleep(3000);
			atm.setBalanceAmount(atm.getBalanceAmount() + depositAmount);
		}
		else {
			System.out.println("Please enter the amount in multiples of 100!!");
		}
	}
	public void withdraw(double withdrawAmount) throws Exception {
		if(withdrawAmount % 100 == 0) {
			if(withdrawAmount <= atm.getBalanceAmount()) {
				Thread.sleep(3000);
				hm.put(withdrawAmount, ":withdraw");
				System.out.println("Collect the cash Rs." + withdrawAmount + "/-..");
				atm.setBalanceAmount(atm.getBalanceAmount() - withdrawAmount);
				viewBalance();
			}
			else {
				System.out.println("Insufficient Balance!!");
			}
		}
	}
	public void viewBalance() throws Exception {
		System.out.println("Available Balance is Rs." + atm.getBalanceAmount() + "/-");
	}
	public void viewMiniStatement() throws Exception {
		System.out.println("Mini Statement:");
		hm.forEach((k, v) -> System.out.println(k + " " + v));
	}
	public void exit() throws Exception {
        Thread.sleep(3000);
        System.out.println("Collect your ATM card..");
        System.out.println("Thank you for using our ATM services!!");
        System.exit(0);
	}
}
