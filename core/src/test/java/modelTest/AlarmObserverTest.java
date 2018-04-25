package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

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
	@Test
	public void alarmCreatedEventHandlingTest() {
		Borrower borrower = new Borrower("Pepe");
		Tool tool = new Tool("Martillo-1",ToolType.Martillo);
		Loan loan = new Loan(1,tool,borrower);
		AlarmSystem alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		
		AlarmStatusVerifier alarmVerifier = new AlarmStatusVerifier();
		AlarmObserver alarmObserver = new AlarmObserver(alarmVerifier);
		assertEquals(alarmVerifier.getActiveAlarms().size(),0);
		alarmSystem.addObserver(alarmObserver);
		alarmSystem.checkLoanAlarmCreation(loan);
		assertEquals(alarmVerifier.getActiveAlarms().size(),1);
	}
}
