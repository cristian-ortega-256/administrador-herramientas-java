package model;

import java.util.ArrayList;
import java.util.Observable;

import Entities.Loan;
import Entities.Tool;
import Entities.Worker;

public class LoanSystem extends Observable {
	
	private int loanNumberCounter;
	private ArrayList<Loan> loans;
	
	public LoanSystem() {
		super();
		this.loanNumberCounter = 0;
		this.loans = new ArrayList<Loan>();
	}
	
	public void generateLoan(Tool tool, Worker worker) {
		Loan _loan = new Loan(this.loanNumberCounter,tool, worker);
		this.addLoan(_loan);
		this.notifyAllObservers(this.loans);
		this.incrementLoanNumberCounter();
	}
	
	private void incrementLoanNumberCounter() {
		++this.loanNumberCounter;
	}
	
	private void notifyAllObservers(ArrayList<Loan> loans) {
		setChanged();
        notifyObservers(loans);
	}
	
	private void addLoan(Loan loan) {
		this.loans.add(loan);
	}

	public ArrayList<Loan> getLoans() {
		return loans;
	}

	public int getLoanNumberCounter() {
		return loanNumberCounter;
	}

	public void setLoanNumberCounter(int loanNumberCounter) {
		this.loanNumberCounter = loanNumberCounter;
	}

}
