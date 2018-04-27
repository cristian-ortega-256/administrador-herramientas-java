package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Entities.Alarm;
import Entities.Borrower;
import Entities.Loan;
import Entities.Tool;
import Entities.ToolType;
import model.AlarmObserver;
import model.AlarmStatusVerifier;
import model.AlarmSystem;

public class AlarmObserverTest {
	
	private Borrower borrower;
	private Tool tool;
	private Loan loan;
	private AlarmSystem alarmSystem;
	private AlarmStatusVerifier alarmVerifier;
	private AlarmObserver alarmObserver;
	
	@Before
	public void prepareDependencies() {
		this.borrower = new Borrower("Pepe");
		this.tool = new Tool("Martillo-1",ToolType.Martillo);
		this.loan = new Loan(1,tool,borrower);
		this.alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		this.alarmVerifier = new AlarmStatusVerifier();
		this.alarmObserver = new AlarmObserver(alarmVerifier);
	}
	
	@Test
	public void alarmCreatedEventHandlingTest() {
		assertEquals(alarmVerifier.getActiveAlarms().size(),0);
		alarmSystem.addObserver(alarmObserver);
		alarmSystem.checkLoanAlarmCreation(loan);
		assertEquals(alarmVerifier.getActiveAlarms().size(),1);
	}
}
