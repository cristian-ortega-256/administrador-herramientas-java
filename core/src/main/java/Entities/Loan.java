package Entities;

import java.util.Date;

import Entities.Tool;
import Entities.Worker;

public class Loan {
	
	private int loanNumber;
	private Tool _tool;
	private Worker _worker;
	private Date _creationDate;
	private Date _expirationDate;
	
	public Loan(int loanNumber, Tool tool, Worker worker) {
		this.loanNumber = loanNumber;
		this._tool = tool;
		this._worker = worker;
		this._creationDate = new Date();
	}

	public int getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}

	public Tool get_tool() {
		return _tool;
	}

	public void set_tool(Tool _tool) {
		this._tool = _tool;
	}

	public Worker get_worker() {
		return _worker;
	}

	public void set_worker(Worker _worker) {
		this._worker = _worker;
	}

	public Date get_creationDate() {
		return _creationDate;
	}

	public void set_creationDate(Date _creationDate) {
		this._creationDate = _creationDate;
	}

	public Date get_expirationDate() {
		return _expirationDate;
	}

	public void set_expirationDate(Date _expirationDate) {
		this._expirationDate = _expirationDate;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.loanNumber + " - Worker: " + this._worker.getName() + " - Tool: " + this._tool.getName();
	}
	
}
