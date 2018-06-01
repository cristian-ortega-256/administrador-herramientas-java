package Entities;

import java.util.Calendar;
import java.util.Date;

import Entities.Tool;
import Entities.Borrower;

public class Loan {
	
	private int loanNumber;
	private Tool _tool;
	private Borrower _borrower;
	private Date _creationDate;
	
	public Loan(int loanNumber, Tool tool, Borrower borrower) {
		this.loanNumber = loanNumber;
		this._tool = tool;
		this._borrower = borrower;
		this._creationDate = new Date();
	}
	
	public void setLoanNumber(int number) {
		this.loanNumber = number;
	}

	public int getLoanNumber() {
		return loanNumber;
	}

	public Tool get_tool() {
		return _tool;
	}

	public Borrower get_borrower() {
		return _borrower;
	}

	public Date get_creationDate() {
		return _creationDate;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.loanNumber + " - Borrower: " + this._borrower.getName() + " - Tool: " + this._tool.getName();
	}

	public void set_creationDate(Date _creationDate) {
		this._creationDate = _creationDate;
	}
	
	
}
