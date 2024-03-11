package Beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class AccountBean 
{
	double acctNo,acctBal;

	public AccountBean()
	{
		System.out.println("AccountBean Constructor Called");
	}

	public double getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(double acctNo) {
		this.acctNo = acctNo;
	}

	public double getAcctBal() {
		return acctBal;
	}

	public void setAcctBal(double acctBal) {
		this.acctBal = acctBal;
	}

}
