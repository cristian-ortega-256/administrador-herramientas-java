package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import Entities.Alarm;
import Entities.Loan;

public class AlarmSystem extends Observable{
	
	private int defaultExpirationTime = 1;
	
	private List<Alarm> activeAlarms;
	private List<Alarm> allAlarms;
	
	public AlarmSystem(ArrayList<Alarm> activeAlarms, ArrayList<Alarm> allAlarms) {
		this.activeAlarms = activeAlarms;
		this.allAlarms = allAlarms;
	}

	public void checkAlarmCreation(Loan loan) {	
		createAlarm(loan);
	}
	
	private void createAlarm(Loan loan) {
		Date expirationDate = generateDefaultExpirationDate(loan.get_creationDate(), this.defaultExpirationTime);
		Alarm alarm = new Alarm(loan, expirationDate);
		activeAlarms.add(alarm);
		this.notifyAllObservers(alarm);
	}
	
	private void notifyAllObservers(Alarm alarm) {
		setChanged();
        notifyObservers(alarm);
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
