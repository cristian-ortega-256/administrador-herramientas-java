package entityTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import Entities.Borrower;
import Entities.Loan;
import Entities.Tool;
import Entities.ToolType;

public class LoanTest {
	
	@Test 
	public void testToolAsignation() {
		Borrower borrower =  new Borrower("Goku");
		Tool tool = new Tool("Martillo-1", ToolType.Martillo);
		Loan loan = new Loan(0, tool, borrower);
		
		assertEquals(loan.get_tool().getName(), tool.getName());
	}
	
	@Test 
	public void testBorrowerAsignation() {
		Borrower borrower =  new Borrower("Goku");
		Tool tool = new Tool("Martillo-1", ToolType.Martillo);
		Loan loan = new Loan(0, tool, borrower);
		        
		assertEquals(loan.get_borrower().getName(), borrower.getName());
	}
		 
	@Test
	public void testCreationDate() {
		Borrower borrower =  new Borrower("Goku");
		Tool tool = new Tool("Martillo-1", ToolType.Martillo);
		Loan loan = new Loan(0, tool, borrower);
		Date d = new Date();
		    
		assertEquals(loan.get_creationDate().getDay(),d.getDay());
		assertEquals(loan.get_creationDate().getYear(),d.getYear());
	}
	
	@Test
	public void testLoanToString() {
		Borrower borrower =  new Borrower("Goku");
		Tool tool = new Tool("Martillo-1", ToolType.Martillo);
		Loan loan = new Loan(0, tool, borrower);
		
		assertEquals(loan.toString(), "Id: " + loan.getLoanNumber() + " - Borrower: " + borrower.getName() + " - Tool: " + tool.getName());
	}
}
