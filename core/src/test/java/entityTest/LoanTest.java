package entityTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Entities.Borrower;
import Entities.Loan;
import Entities.Tool;
import Entities.ToolType;

public class LoanTest {
	
	private Borrower borrower;
	private Tool tool;
	private Loan loan;
	private ToolType tt;
	private Date d;
	
	@Before
	public void prepareDependencies() {
		this.borrower =  new Borrower("Goku");
		this.tt = new ToolType("Martillo");
		this.tool = new Tool("Martillo-1", this.tt);
		this.loan = new Loan(0, tool, borrower);
		this.loan.setLoanNumber(0);
		this.d = new Date();
	}
	
	@Test 
	public void testToolAsignation() {
		assertEquals(loan.get_tool().getName(), tool.getName());
	}
	
	@Test 
	public void testBorrowerAsignation() {
		assertEquals(loan.get_borrower().getName(), borrower.getName());
	}
		 
	@Test
	public void testCreationDate() {		    
		assertEquals(loan.get_creationDate().getDay(),d.getDay());
		assertEquals(loan.get_creationDate().getYear(),d.getYear());
	}
	
	@Test
	public void testLoanToString() {
		assertEquals(loan.toString(), "Id: " + loan.getLoanNumber() + " - Borrower: " + borrower.getName() + " - Tool: " + tool.getName());
	}
}
