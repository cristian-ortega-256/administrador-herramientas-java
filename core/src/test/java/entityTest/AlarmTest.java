package entityTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import Entities.Alarm;
import Entities.Borrower;
import Entities.Loan;
import Entities.Tool;
import Entities.ToolType;

public class AlarmTest {
	@Test
	public void testConstructor() {
		Borrower borrower = new Borrower("Pepe");
		Tool tool = new Tool("Martillo - 1", ToolType.Martillo);
		Loan loan = new Loan(0, tool, borrower);
		Date date = new Date();
		Alarm alarm = new Alarm(loan, date);
		
		assertEquals(alarm.getLoan(),loan);
		assertEquals(alarm.getExpirationDate(),date);
	}
	
	@Test
	public void testToString() {
		Borrower borrower = new Borrower("Pepe");
		Tool tool = new Tool("Martillo - 1", ToolType.Martillo);
		Loan loan = new Loan(0, tool, borrower);
		Date date = new Date();
		Alarm alarm = new Alarm(loan, date);
		
		assertEquals(alarm.toString(),"Loan: " + loan.toString() +
				"\n CreationDate: " + loan.get_creationDate().toString() + "\n" +
				" ExpirationDate: " + date.toString() + "\n");
	}
	
}
