package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.codoid.products.exception.FilloException;

import Entities.Loan;
import Entities.Tool;
import database.LoanDAO;
import database.LoanLogDAO;
import Entities.Borrower;

public class LoanSystem extends Observable {
	
	private int loanNumberCounter = 0;
	private List<Loan> loans;
	private List<Tool> allTools;
	private List<Tool> borrowedTools;
	private LoanDAO loanDao;
	private LoanLogDAO loanLogDao;
	
	public LoanSystem(List<Tool> allTools) {
		super();
		this.loanDao = new LoanDAO();
		this.loans = new ArrayList<Loan>();
		this.allTools = allTools;
		this.borrowedTools = new ArrayList<Tool>();
		this.loanLogDao = new  LoanLogDAO();
	}
	
	public void checkLoanGeneration(Tool tool, Borrower borrower) {
		try {
			isBorrowedTool(tool);
			this.loanLogDao.Add(generateLoan(tool,borrower), "Apertura");
		}
	 	catch(Exception e){
	 		//e.printStackTrace();
	 		System.out.println(e.getMessage());
		}
	}
	
	public void closeLoan(Loan loan) throws FilloException {
		// TODO --> Test
		this.removeLoan(loan);
		this.removeToolFromBorrowed(loan.get_tool());
		this.loanDao.delete(loan.getLoanNumber());
		this.loanLogDao.Add(loan, "Cierre");
	}
	
	public Loan generateLoan(Tool tool, Borrower borrower) throws FilloException {
		Loan _loan = new Loan(this.loanNumberCounter,tool, borrower);
		this.addLoan(_loan);
		this.notifyAllObservers(_loan);
		//this.notifyAllObservers(this.loans);
		this.incrementLoanNumberCounter();
		setToolAsBorrowed(tool);
		return _loan;
	}
	
	public void isBorrowedTool(Tool t) throws Exception{
		for(Tool tool:this.borrowedTools) {
			if(tool.equals(t))
				throw new Exception("Tool is already borrowed");
		}
	}
	
	private void removeLoan(Loan loan) {
		this.loans.remove(this.loans.indexOf(loan));
	}
	
	private void removeToolFromBorrowed(Tool t) {
		this.borrowedTools.remove(this.borrowedTools.indexOf(t));
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
		this.generateBorrowedTools(loans);
	}
	
	private void generateBorrowedTools(List<Loan> loans2) {
		this.borrowedTools = new ArrayList<Tool>();
		for(Loan loan:loans) {
			this.setToolAsBorrowed(loan.get_tool());
		}
	}
	
	private void setToolAsBorrowed(Tool t) {
		this.borrowedTools.add(t);
	}

	public void setLastLoanNumber() throws FilloException {
		this.loanNumberCounter = this.loanDao.GetLastFreeLoanNumber();
	}

}
