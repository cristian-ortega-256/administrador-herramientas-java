package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Entities.Alarm;
import Entities.Borrower;
import Entities.Loan;
import Entities.LoanAlarm;
import Entities.Supply;
import Entities.Tool;
import Entities.ToolType;
import model.AlarmObserver;
import model.AlarmStatusVerifier;
import model.AlarmSystem;
import model.SchedulerTaskExecutor;

public class AlarmStatusVerifierTest {
	
	private Supply supply;
	private Loan loan;
	private Borrower borrower;
	private Tool tool;
	private ToolType tt;
	private AlarmSystem alarmSystem;
	private AlarmStatusVerifier alarmVerifier;
	private AlarmObserver alarmObserver;
	private List<Runnable> runnables;
	private SchedulerTaskExecutor schedulerTaskExecutor;
	
	@Before
	public void prepareDependencies() {
		new Borrower("Goku");
		this.supply = new Supply("Tornillos",100,500);
		this.borrower = new Borrower("Goku");
		this.tt = new ToolType("Martillo");
		this.tool = new Tool("Martillo-1", tt);
		this.tool.setId(1);
		this.loan = new Loan(0, tool,borrower);
		this.alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		this.alarmVerifier = new AlarmStatusVerifier();
		this.alarmObserver = new AlarmObserver(alarmVerifier);
		this.runnables = new ArrayList<Runnable>();
	}
	
	@Test
	public void testAlarmExpiration() {
		assertEquals(alarmVerifier.getActiveAlarms().size(),0);

		assertEquals(alarmVerifier.getActiveAlarms().size(),0);
		alarmSystem.addObserver(alarmObserver);
		
		alarmSystem.checkSupplyAlarmCreation(supply);
		assertEquals(alarmVerifier.getActiveAlarms().size(),1);
		runnables.add(alarmVerifier);
		
		this.schedulerTaskExecutor = new SchedulerTaskExecutor(runnables);
		// TODO --> CHECK THE WAY TO EXECUTE AND TEST ASYNC TASKS
		schedulerTaskExecutor.executeScheduledTasks();
		
		assertEquals(alarmVerifier.getActiveAlarms().size(),1);
	}
	
	@Test
	public void testAlarmsScann() {
		alarmSystem.addObserver(alarmObserver);
		
		alarmSystem.checkSupplyAlarmCreation(supply);
		alarmSystem.checkLoanAlarmCreation(loan);
		assertEquals(alarmVerifier.getActiveAlarms().size(),2);
		
		alarmVerifier.scannAlarms();
	}
	
	@Test
	public void alarmsSetterTest() {
		ArrayList<Alarm> alarms = new ArrayList<Alarm>();
		LoanAlarm loanAlarm = new LoanAlarm(this.loan, new Date());
		alarms.add(loanAlarm);
		this.alarmVerifier.setActiveAlarms(alarms);
		assertEquals(this.alarmVerifier.getActiveAlarms().size(),1);
	}

}
