package modelTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Entities.Borrower;
import Entities.Tool;
import Entities.ToolType;
import model.LoanSystem;
import model.ToolSystem;

public class LoanSystemTest {
	
	private ToolSystem tools;
	private Borrower borrower;
	private Tool tool;
	private LoanSystem loanSystem;
	private List<Tool> listTools;
	
	@Before
	public void prepareDependencies() {
		this.tools = new ToolSystem();
		this.borrower = new Borrower("Pepe");
		this.listTools = new ArrayList<Tool>();
		this.listTools.add(new Tool("Martillo",ToolType.Martillo));
		this.listTools.add(new Tool("Destornilador",ToolType.Destornillador));
		this.listTools.add(new Tool("Taladro",ToolType.Taladro));
		this.tools.setTools(listTools);
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
