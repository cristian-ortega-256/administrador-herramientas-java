package model;

import java.util.ArrayList;
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
	
	public void generateLoan(Tool tool, Worker worker) {
		Loan _loan = new Loan(tool, worker);
		this.addLoan(_loan);
		this.notifyAllObservers(_loan);
	}
	
	private void notifyAllObservers(Loan loan) {
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
