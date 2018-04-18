package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import Entities.Borrower;
import Entities.Retreat;
import Entities.Supply;

public class RetreatSystem extends Observable{
	
	private int retreatNumberCounter = 0;
	private List<Retreat> retreats;
	private SupplySystem supplySystem;
	
	public RetreatSystem(SupplySystem supplySystem) {
		super();
		this.supplySystem = supplySystem;
		this.retreats = new ArrayList<Retreat>();
	}
	
	public void checkRetreatGeneration(Supply supply, Borrower borrower, int quantity) {
		if (this.supplySystem.suppliesValidations(supply, quantity)) {
			generateRetreat(borrower, supply, quantity);
			this.supplySystem.discountStockSupply(supply, quantity);
		}		
	}
	
	private void generateRetreat(Borrower borrower, Supply supply, int quantity) {
		Retreat retreat = new Retreat(this.retreatNumberCounter, borrower, supply, quantity);
		this.addRetreat(retreat);
		this.notifyAllObservers(retreat);
		this.incrementRetreatNumberCounter();
	}
	
	private void incrementRetreatNumberCounter() {
		++this.retreatNumberCounter;
	}
	
	private void notifyAllObservers(Retreat retreats) {
		setChanged();
        notifyObservers(retreats);
	}
	
	private void addRetreat(Retreat retreat) {
		this.retreats.add(retreat);
	}
	
	public List<Retreat> getRetreats() {
		return retreats;
	}

	
}
