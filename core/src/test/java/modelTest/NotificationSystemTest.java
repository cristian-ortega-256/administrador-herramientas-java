package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Entities.Borrower;
import Entities.Loan;
import Entities.LoanAlarm;
import Entities.Supply;
import Entities.SupplyAlarm;
import Entities.Tool;
import Entities.ToolType;
import model.NotificationSystem;

public class NotificationSystemTest {
	private Borrower borrower;
	private Tool tool;
	private Loan loan;
	private LoanAlarm loanAlarm;
	private Supply supply;
	private SupplyAlarm supplyAlarm;
	private NotificationSystem notificationSystem;

	@Before
	public void prepareDependencies() {
		this.borrower = new Borrower("Goku");
		this.tool = new Tool("Destornillador #1", new ToolType("Destornillador"));
		this.tool.setId(4);
		this.loan = new Loan(0, this.tool, this.borrower);
		this.loanAlarm = new LoanAlarm(this.loan, new Date());
		
		this.supply = new Supply("Bolsa tornillos", 100, 500);
		this.supplyAlarm = new SupplyAlarm(supply, new Date());
		
		this.notificationSystem = new NotificationSystem();
	}
	
	@Test
	public void testLoanNotificationCreation() {
		this.notificationSystem.createNotification(this.loanAlarm);
		assertEquals(this.notificationSystem.getNotifications().size(),1);
	}
	
	@Test
	public void testRetreatNotificationCreation() {
		this.notificationSystem.createNotification(this.supplyAlarm);
		assertEquals(this.notificationSystem.getNotifications().size(),1);
	}
	
	@Test
	public void testDuplicatedNotifications() {
		this.notificationSystem.createNotification(this.loanAlarm);
		this.notificationSystem.createNotification(this.loanAlarm);
		this.notificationSystem.createNotification(this.supplyAlarm);
		this.notificationSystem.createNotification(this.supplyAlarm);
		assertEquals(this.notificationSystem.getNotifications().size(),2);
	}
	
	@Test
	public void testNotificationsGetter() {
		assertEquals(this.notificationSystem.getNotifications().size(),0);
	}
	
}
