package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import Entities.Loan;
import Entities.Tool;
import Entities.Worker;

public class LoanSystem extends Observable {
	
	private ArrayList<Loan> loans;
	
	public LoanSystem() {
		super();
		this.loans = new ArrayList<Loan>();
	}
	
	public void generateLoan(Tool tool, Worker worker, Date expirationDate) {
		Loan _loan = new Loan(tool, worker, expirationDate);
		this.addLoan(_loan);
		//this.notifyAllObservers(_loan);
		this.notifyAllObservers("Loan created");
	}
	
	private void notifyAllObservers(String loan) {
		setChanged();
        notifyObservers(loan);
	}
	
	private void addLoan(Loan loan) {
		this.loans.add(loan);
	}

	public ArrayList<Loan> getLoans() {
		return loans;
	}

}
