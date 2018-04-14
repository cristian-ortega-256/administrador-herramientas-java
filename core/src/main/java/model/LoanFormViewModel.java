package model;

import java.util.List;

import Entities.Tool;
import Entities.Borrower;

public class LoanFormViewModel {
	
	private List<Tool> allTools;
	private List<Borrower> allBorrowers;
	
	public List<Tool> getAllTools() {
		return allTools;
	}
	public void setAllTools(List<Tool> allTools) {
		this.allTools = allTools;
	}
	public List<Borrower> getAllBorrowers() {
		return allBorrowers;
	}
	public void setAllBorrowers(List<Borrower> allBorrowers) {
		this.allBorrowers = allBorrowers;
	}
	
}
