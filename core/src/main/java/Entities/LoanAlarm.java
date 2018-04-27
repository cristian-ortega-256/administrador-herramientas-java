package Entities;

import java.util.Date;

public class LoanAlarm  extends Alarm{
	
	private Loan loan;

	public LoanAlarm(Loan loan, Date expirationDate) {
		super(expirationDate);
		this.loan = loan;
	}
	
	public Loan getLoan() {
		return loan;
	}
	
	@Override
	public String toString() {
		return "LOAN ALARM: " + this.loan.toString() + "\n" + this.getExpirationDate().toString();
	}

}
