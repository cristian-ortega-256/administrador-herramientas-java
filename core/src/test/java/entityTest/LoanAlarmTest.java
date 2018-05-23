package entityTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Entities.Borrower;
import Entities.Loan;
import Entities.LoanAlarm;
import Entities.Tool;
import Entities.ToolType;

public class LoanAlarmTest {
	
	private Borrower borrower;
	private Tool tool;
	private ToolType tt;
	private Loan loan;
	private LoanAlarm loanAlarm;
	
	@Before
	public void prepareDependencies() {
		this.borrower = new Borrower("Pepe");
		this.tt = new ToolType("Martillo");
		this.tool = new Tool("Martillo-1", this.tt);
		this.loan = new Loan(0, tool, borrower);
		this.loanAlarm = new LoanAlarm(loan, new Date());
	}
	
	@Test
	public void getterTest() {
		assertEquals(loanAlarm.getLoan(),loan);
	}
	
	@Test
	public void testToString() {
		assertEquals(loanAlarm.toString(),"LOAN ALARM: " + this.loan.toString() + "\n" + loanAlarm.getExpirationDate().toString());
	}
}
