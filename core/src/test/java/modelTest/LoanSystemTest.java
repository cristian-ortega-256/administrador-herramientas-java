package modelTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Entities.Borrower;
import Entities.Loan;
import Entities.Tool;
import model.LoanSystem;
import model.ToolSystem;

public class LoanSystemTest {
	// TODO --> Check mock library
	@Test 
	public void testLoanGenerationSucces() {
		
		ToolSystem tools = new ToolSystem();
		Borrower borrower = new Borrower("Pepe");
		Tool tool = tools.getAllTools().get(0);
		LoanSystem loanSystem = new LoanSystem(tools.getAllTools());
		
		assertEquals(loanSystem.getLoans().size(), 0);
		loanSystem.checkLoanGeneration(tool, borrower);
        assertEquals(loanSystem.getLoans().size(), 1);
    }
	
	@Test
	public void testLoanGenerationFailure() {
		
		ToolSystem tools = new ToolSystem();
		Borrower borrower = new Borrower("Pepe");
		Tool tool = tools.getAllTools().get(0);
		LoanSystem loanSystem = new LoanSystem(tools.getAllTools());
		
		assertEquals(loanSystem.getLoans().size(), 0);
		
		loanSystem.checkLoanGeneration(tool, borrower);
		assertEquals(loanSystem.getLoans().size(), 1);
		
        loanSystem.checkLoanGeneration(tool, borrower);
        assertEquals(loanSystem.getLoans().size(), 1);
    }
	
}
