package Entities;

import java.util.Date;

import Entities.Tool;
import Entities.Worker;

public class Loan {
	
	//private int id;
	private Tool _tool;
	private Worker _worker;
	private Date _creationDate;
	private Date _expirationDate;
	private Date _deliverDate;
	
	public Loan(Tool tool, Worker worker, Date expirationDate) {
		this._tool = tool;
		this._worker = worker;
		this._creationDate = new Date();
		this._expirationDate = expirationDate;
		this._deliverDate = null;
	}
	
	public void closeLoan() {
		if(this._deliverDate != null)
			this._deliverDate = new Date();
		return;
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

	public Date get_deliverDate() {
		return _deliverDate;
	}

	public void set_deliverDate(Date _deliverDate) {
		this._deliverDate = _deliverDate;
	}
	
}
