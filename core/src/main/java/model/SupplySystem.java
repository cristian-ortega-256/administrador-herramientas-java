package model;

import java.util.ArrayList;
import java.util.List;

import Entities.Supply;

public class SupplySystem {
	
	private List<Supply> allSupplies;
	
	public SupplySystem() {
		this.allSupplies = new ArrayList<Supply>();
		this.populateInternalSupplies();
	}
	
	private void populateInternalSupplies() {
		this.allSupplies.add(new Supply("Tornillos", 100, 500));
		this.allSupplies.add(new Supply("Clavos", 80, 40));
		this.allSupplies.add(new Supply("Lamparas", 50, 25));
		this.allSupplies.add(new Supply("Tubos de luz", 20, 10));
	}
	
	public boolean suppliesValidations(Supply supply, int quantity) {
		try {
			this.hasStock(supply);
			this.quantityExceeded(supply, quantity);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public List<Supply> getAllSupplies() {
		return this.allSupplies;
	}
	
	
	public void hasStock(Supply supply) throws Exception {
		if(supply.getStock() <= 0) {
			throw new Exception("Supply hasn't stock");
		}
	}
	
	public void quantityExceeded(Supply supply, int quantity) throws Exception {
		if (supply.getStock() < quantity) {
			throw new Exception("Exceeded quantity");
		}
	}
	
	public void discountStockSupply(Supply supply, int retreatQuantity) {
		int index = this.allSupplies.indexOf(supply);
		supply.setStock(supply.getStock() - retreatQuantity);
		this.allSupplies.set(index, supply);
	}

}
