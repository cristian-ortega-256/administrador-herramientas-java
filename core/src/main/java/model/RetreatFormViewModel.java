package model;

import java.util.List;

import Entities.Borrower;
import Entities.Supply;

public class RetreatFormViewModel {
	
	private List<Supply> allSupplies;
	private List<Borrower> allBorrowers;
	
	public List<Supply> getAllSupplies() {
		return allSupplies;
	}
	public void setAllSupplies(List<Supply> allSupplies) {
		this.allSupplies = allSupplies;
	}
	public List<Borrower> getAllBorrowers() {
		return allBorrowers;
	}
	public void setAllBorrowers(List<Borrower> allBorrowers) {
		this.allBorrowers = allBorrowers;
	}

}
