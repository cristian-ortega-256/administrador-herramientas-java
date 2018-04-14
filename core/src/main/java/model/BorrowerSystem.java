package model;

import java.util.ArrayList;
import java.util.List;

import Entities.Borrower;

public class BorrowerSystem {
	
	private List<Borrower> workers;
	
	public BorrowerSystem() {
		this.workers = new ArrayList<Borrower>();
		this.populateInternalWorkers();
	}
	// TODO --> Move this outside of the class
	private void populateInternalWorkers() {
		this.workers.add(new Borrower("Goku"));
		this.workers.add(new Borrower("Vegeta"));
		this.workers.add(new Borrower("Gohan"));
		this.workers.add(new Borrower("Trunks"));
	}

	public List<Borrower> getBorrowers() {
		return workers;
	}
	
	/*
	public void setBorrowers(List<Borrower> workers) {
		this.workers = workers;
	}
	*/
	
}
