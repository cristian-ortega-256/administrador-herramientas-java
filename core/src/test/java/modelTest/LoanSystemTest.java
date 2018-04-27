package modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Entities.Borrower;
import Entities.Tool;
import model.LoanSystem;
import model.ToolSystem;

public class LoanSystemTest {
	
	private ToolSystem tools;
	private Borrower borrower;
	private Tool tool;
	private LoanSystem loanSystem;
	
	@Before
	public void prepareDependencies() {
		this.tools = new ToolSystem();
		this.borrower = new Borrower("Pepe");
		this.tool = tools.getAllTools().get(0);
		this.loanSystem = new LoanSystem(tools.getAllTools());
	}
	
	@Test 
	public void testLoanGenerationSucces() {	
		assertEquals(loanSystem.getLoans().size(), 0);
		loanSystem.checkLoanGeneration(tool, borrower);
        assertEquals(loanSystem.getLoans().size(), 1);
    }
	
	@Test
	public void testLoanGenerationFailure() {
		
		assertEquals(loanSystem.getLoans().size(), 0);
		
		loanSystem.checkLoanGeneration(tool, borrower);
		assertEquals(loanSystem.getLoans().size(), 1);
		
        loanSystem.checkLoanGeneration(tool, borrower);
        assertEquals(loanSystem.getLoans().size(), 1);
    }
	
}
