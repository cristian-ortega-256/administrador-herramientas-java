package Entities;

import java.util.Date;

public class RetreatLog {
	
	private Supply supply;
	private Borrower borrower;
	private int quantity;
	private Date date;
	
	public RetreatLog(Supply supply, Borrower borrower, int quantity, Date date){
		this.supply = supply;
		this.borrower = borrower;
		this.quantity = quantity;
		this.date = date;
	}
	
}
