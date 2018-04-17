package Entities;

import java.util.Date;

public class Alarm {
	
	private Loan loan;
	private Date expirationDate;
	
	public Alarm(Loan loan, Date expirationDate) {
		this.loan = loan;
		this.expirationDate = expirationDate;
	}
	
	public Loan getLoan() {
		return loan;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	@Override
	public String toString() {
		return "Loan: " + this.loan.toString() +
				"\n CreationDate: " + this.loan.get_creationDate().toString() + "\n" +
				" ExpirationDate: " + this.expirationDate.toString() + "\n";
	}
}
