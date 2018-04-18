package Entities;

import java.util.Date;

public class Retreat {
	
	private int retreatNumber;
	private Borrower borrower;
	private Supply supply;
	private int quantity;
	private Date date;
	
	public Retreat(int retreatNumber, Borrower borrower, Supply supply, int quantity) {
		this.retreatNumber = retreatNumber;
		this.borrower = borrower;
		this.supply = supply;
		this.quantity = quantity;
		this.date = new Date();
	}

	public Borrower getBorrower() {
		return borrower;
	}

//	public void setBorrower(Borrower borrower) {
//		this.borrower = borrower;
//	}

	public Supply getSupply() {
		return supply;
	}

//	public void setSupply(Supply supply) {
//		this.supply = supply;
//	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	public Date getDate() {
//		return date;
//	}

//	public void setDate(Date date) {
//		this.date = date;
//	}

	@Override
	public String toString() {
			return "Id: " + this.retreatNumber + 
				" - Remover: " + this.borrower.getName() + 
				" - Supply: " + this.supply.getName() + 
				" - Quantity: " + this.quantity;
	}
}
