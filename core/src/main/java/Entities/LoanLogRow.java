package Entities;

public class LoanLogRow {
	private String number;
	private String tool;
	private String borrower;
	private String action;
	private String date;

	public LoanLogRow(String number, String tool, String borrower, String action, String date) {
		this.number = number;
		this.tool = tool;
		this.borrower = borrower;
		this.action = action;
		this.date = date;
	}

	public String getNumber() {
		return number;
	}

	public String getTool() {
		return tool;
	}

	public String getBorrower() {
		return borrower;
	}

	public String getAction() {
		return action;
	}

	public String getDate() {
		return date;
	}
	
}
