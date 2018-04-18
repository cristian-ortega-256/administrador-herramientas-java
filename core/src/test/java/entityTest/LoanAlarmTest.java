package entityTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import Entities.Borrower;
import Entities.Loan;
import Entities.LoanAlarm;
import Entities.Tool;
import Entities.ToolType;

public class LoanAlarmTest {
	
	@Test
	public void getterTest() {
		Borrower borrower = new Borrower("Pepe");
		Tool tool = new Tool("Martillo-1", ToolType.Martillo);
		Loan loan = new Loan(0, tool, borrower);
		LoanAlarm loanAlarm = new LoanAlarm(loan, new Date());
		assertEquals(loanAlarm.getLoan(),loan);
	}
}
