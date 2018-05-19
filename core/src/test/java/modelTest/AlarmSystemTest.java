package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Entities.Alarm;
import Entities.Borrower;
import Entities.Loan;
import Entities.Supply;
import Entities.Tool;
import Entities.ToolType;
import model.AlarmSystem;

public class AlarmSystemTest {
	
	private AlarmSystem alarmSystem;
	private Borrower borrower;
	private Tool tool;
	private Loan loan;
	private Date date;
	private Supply supply;
	
	@Before
	public void prepareDependencies() {
		this.alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		this.borrower = new Borrower("Pepe");
		this.tool = new Tool("Martillo-1",ToolType.Martillo);
		this.loan = new Loan(0, tool,borrower);
		this.supply = new Supply("Lamparas",10,10);
		this.date = new Date();
	}

	@Test
	public void testConstructor() {
		assertEquals(alarmSystem.getActiveAlarms().size(),0);
		assertEquals(alarmSystem.getAllAlarms().size(),0);
	}
	
	@Test
	public void testLoanAlarmCreation() {
		assertEquals(alarmSystem.getActiveAlarms().size(),0);
		alarmSystem.checkLoanAlarmCreation(loan);
		assertEquals(alarmSystem.getActiveAlarms().size(),1);
	}
	
	@Test
	public void testExpirationDateAsignation() {
		alarmSystem.checkLoanAlarmCreation(loan);
		int expirationDate = alarmSystem.getActiveAlarms().get(0).getExpirationDate().getDate();
		assertEquals(expirationDate,date.getDate()+1);
	}
	
	@Test
	public void testSupplyAlarmCreation() {
		assertEquals(alarmSystem.getActiveAlarms().size(),0);
		alarmSystem.checkSupplyAlarmCreation(supply);
		assertEquals(alarmSystem.getActiveAlarms().size(),1);
	}
	
}
