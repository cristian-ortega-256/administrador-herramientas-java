package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.codoid.products.exception.FilloException;

import Entities.Loan;
import Entities.Tool;
import database.LoanDAO;
import Entities.Borrower;

public class LoanSystem extends Observable {
	
	private int loanNumberCounter = 0;
	private List<Loan> loans;
	private List<Tool> allTools;
	private List<Tool> borrowedTools;
	private LoanDAO loanDao;
	
	public LoanSystem(List<Tool> allTools) {
		super();
		this.loanDao = new LoanDAO();
		this.loans = new ArrayList<Loan>();
		this.allTools = allTools;
		this.borrowedTools = new ArrayList<Tool>();
	}
	
	public void checkLoanGeneration(Tool tool, Borrower borrower) {
		try {
			isBorrowedTool(tool);
			generateLoan(tool,borrower);
		}
	 	catch(Exception e){
	 		System.out.println(e.getMessage());
		}
	}
	
	public void generateLoan(Tool tool, Borrower borrower) throws FilloException {
		//this.loanNumberCounter = this.loanDao.GetLastFreeLoanNumber();
		Loan _loan = new Loan(this.loanNumberCounter,tool, borrower);
		this.addLoan(_loan);
		this.notifyAllObservers(_loan);
		//this.notifyAllObservers(this.loans);
		this.incrementLoanNumberCounter();
		setToolAsBorrowed(tool);
	}
	
	public void isBorrowedTool(Tool t) throws Exception{
		if(this.borrowedTools.contains(t)) {
			throw new Exception("Tool is already borrowed");
		}
	}
	
	private void setToolAsBorrowed(Tool t) {
		this.borrowedTools.add(t);
	}
	
	private void incrementLoanNumberCounter() {
		++this.loanNumberCounter;
	}
	
	private void notifyAllObservers(Loan loan) {
		setChanged();
        notifyObservers(loan);
	}
	
	/*
	private void notifyAllObservers(ArrayList<Loan> loans) {
		setChanged();
        notifyObservers(loans);
	}
	*/
	
	private void addLoan(Loan loan) throws FilloException {
		this.loans.add(loan);
		this.loanDao.Add(loan);
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	
	public void setLastLoanNumber() throws FilloException {
		this.loanNumberCounter = this.loanDao.GetLastFreeLoanNumber();
	}

}
