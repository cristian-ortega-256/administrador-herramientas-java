package modelTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Entities.Borrower;
import Entities.Loan;
import Entities.Tool;
import Entities.ToolType;
import model.LoanSystem;
import model.ToolSystem;

public class LoanSystemTest {
	
	private ToolSystem tools;
	private Borrower borrower;
	private Tool tool;
	private ToolType tt;
	private LoanSystem loanSystem;
	private List<Tool> listTools;
	
	@Before
	public void prepareDependencies() {
		this.tools = new ToolSystem();
		this.borrower = new Borrower("Goku");
		this.listTools = new ArrayList<Tool>();
		this.tt = new ToolType("Martillo");
		this.listTools.add(new Tool("Martillo", tt));
		this.listTools.add(new Tool("Destornilador", tt));
		this.listTools.add(new Tool("Taladro", tt));
		this.tools.setTools(listTools);
		this.tool = tools.getAllTools().get(0);
		this.tool.setId(1);
		this.loanSystem = new LoanSystem(tools.getAllTools());
		this.loanSystem.setLoans(new ArrayList<Loan>());
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
