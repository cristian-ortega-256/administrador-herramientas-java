package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import Entities.Alarm;
import Entities.Loan;
import Entities.LoanAlarm;
import Entities.Supply;
import Entities.SupplyAlarm;

public class AlarmSystem extends Observable{
	
	private int defaultExpirationTime = 1;
	
	private List<Alarm> activeAlarms;
	private List<Alarm> allAlarms;
	
	public AlarmSystem(ArrayList<Alarm> activeAlarms, ArrayList<Alarm> allAlarms) {
		this.activeAlarms = activeAlarms;
		this.allAlarms = allAlarms;
	}

	public void checkLoanAlarmCreation(Loan loan) {
		// Add future validations for alarm creation
		createLoanAlarm(loan);
	}
	
	public void checkSupplyAlarmCreation(Supply s) {
		// Add future validations for alarm creation
		createSupplyAlarm(s);
	}
	
	private void createSupplyAlarm(Supply s) {
		Alarm alarm = new SupplyAlarm(s, new Date());
		activeAlarms.add(alarm);
		this.notifyAllObservers(alarm);
	}

	private void createLoanAlarm(Loan loan) {
		Date expirationDate = generateDefaultExpirationDate(loan.get_creationDate(), this.defaultExpirationTime);
		Alarm alarm = new LoanAlarm(loan, expirationDate);
		activeAlarms.add(alarm);
		this.notifyAllObservers(alarm);
	}
	
	private void notifyAllObservers(Alarm alarm) {
		setChanged();
        notifyObservers(this.activeAlarms);
        System.out.println("\nNew alarm: " + alarm.getClass().getName() + "\n" + alarm.toString());
        System.out.println("-------------------------------------------------------------");
        System.out.println("Notifing active alarms: " + this.activeAlarms.size());
        System.out.println("-------------------------------------------------------------");
	}
	
	private Date generateDefaultExpirationDate(Date dt,int daysToAdd) {
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, daysToAdd);
		return c.getTime();
	}

	public List<Alarm> getActiveAlarms() {
		return activeAlarms;
	}

	public List<Alarm> getAllAlarms() {
		return allAlarms;
	}
	
}
