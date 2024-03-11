package AOP;

public class AccountBean 
{
	private int accNo;
	private double balance;
	
	public AccountBean() {
		// TODO Auto-generated constructor stub
	}

	public void Withdraw(int amount)
	{
		System.out.println("Before Withdrawing the Balance is : "+balance);
		balance-=amount;
		System.out.println("After Withdrawal Balance is : "+balance);
	}
	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}
