package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import Entities.Alarm;
import Entities.Borrower;
import Entities.Loan;
import Entities.Supply;
import Entities.Tool;
import Entities.ToolType;
import model.AlarmSystem;

public class AlarmSystemTest {

	@Test
	public void testConstructor() {
		AlarmSystem alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		assertEquals(alarmSystem.getActiveAlarms().size(),0);
		assertEquals(alarmSystem.getAllAlarms().size(),0);
	}
	
	@Test
	public void testLoanAlarmCreation() {
		Borrower borrower = new Borrower("Pepe");
		Tool tool = new Tool("Martillo-1",ToolType.Martillo);
		Loan loan = new Loan(0, tool,borrower);
		
		AlarmSystem alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		assertEquals(alarmSystem.getActiveAlarms().size(),0);
		alarmSystem.checkLoanAlarmCreation(loan);
		assertEquals(alarmSystem.getActiveAlarms().size(),1);
	}
	
	@Test
	public void testExpirationDateAsignation() {
		Borrower borrower = new Borrower("Pepe");
		Tool tool = new Tool("Martillo-1",ToolType.Martillo);
		Loan loan = new Loan(0, tool,borrower);
		
		AlarmSystem alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		alarmSystem.checkLoanAlarmCreation(loan);
		Date date = new Date();
		int expirationDate = alarmSystem.getActiveAlarms().get(0).getExpirationDate().getDay();
		assertEquals(expirationDate,date.getDay()+1);
	}
	
	@Test
	public void testSupplyAlarmCreation() {
		Supply supply = new Supply("Lamparas",10,10);
		AlarmSystem alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		assertEquals(alarmSystem.getActiveAlarms().size(),0);
		alarmSystem.checkSupplyAlarmCreation(supply);
		assertEquals(alarmSystem.getActiveAlarms().size(),1);
	}
}