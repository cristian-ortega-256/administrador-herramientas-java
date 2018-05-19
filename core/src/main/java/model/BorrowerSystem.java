package model;

import java.util.ArrayList;
import java.util.List;

import Entities.Borrower;

public class BorrowerSystem {
	
	private List<Borrower> workers;
	
	public BorrowerSystem() {
		this.workers = new ArrayList<Borrower>();
	}

	public void setWorkers(List<Borrower> list) {
		this.workers = list;
	}

	public List<Borrower> getBorrowers() {
		return workers;
	}
	
}
