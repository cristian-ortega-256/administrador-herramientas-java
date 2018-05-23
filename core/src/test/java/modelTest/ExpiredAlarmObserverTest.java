package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Entities.Alarm;
import Entities.Borrower;
import Entities.Loan;
import Entities.LoanAlarm;
import Entities.Supply;
import Entities.SupplyAlarm;
import Entities.Tool;
import Entities.ToolType;
import model.AlarmStatusVerifier;
import model.ExpiredAlarmObserver;
import model.NotificationSystem;

public class ExpiredAlarmObserverTest {
	
	private Borrower borrower;
	private Tool tool;
	private Loan loan;
	private LoanAlarm loanAlarm;
	private Supply supply;
	private SupplyAlarm supplyAlarm;
	private ArrayList<Alarm> alarms;
	private ExpiredAlarmObserver expiredAlarmObserver;
	private NotificationSystem notificationSystem;
	private AlarmStatusVerifier alarmStatusVerifier;
	
	@Before
	public void prepareDependencies() {
		
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, -1);
		Date dateBefore1Days = cal.getTime();
		
		this.borrower = new Borrower("Pepe");
		this.tool = new Tool("Destornillador 1", new ToolType("Destornillador"));
		this.loan = new Loan(0, this.tool, this.borrower);
		this.loanAlarm = new LoanAlarm(this.loan, dateBefore1Days);
		
		this.supply = new Supply("Bolsa tornillos", 100, 500);
		this.supplyAlarm = new SupplyAlarm(supply, dateBefore1Days);
		
		this.notificationSystem = new NotificationSystem();
		this.expiredAlarmObserver = new ExpiredAlarmObserver(this.notificationSystem);
		
		this.alarmStatusVerifier = new AlarmStatusVerifier();
		this.alarmStatusVerifier.addObserver(expiredAlarmObserver);
		this.alarms = new ArrayList<Alarm>();
		this.alarms.add(this.supplyAlarm);
		this.alarms.add(this.loanAlarm);
		this.alarmStatusVerifier.setActiveAlarms(this.alarms);
	}
	
	@Test
	public void notificationCreatedOnAlarmExpired() {
		this.alarmStatusVerifier.scannAlarms();
		assertEquals(this.notificationSystem.getNotifications().size(),2);
	}

}
