package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import Entities.Alarm;

public class AlarmStatusVerifier extends Observable implements Runnable{
	
	private List<Alarm> activeAlarms;
	
	public AlarmStatusVerifier() {
		this.activeAlarms = new ArrayList<Alarm>();
	}
	
	public void scannAlarms() {
		System.out.println("Alarms verified: " + this.activeAlarms.size());
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		for (Alarm alarm: this.activeAlarms) {
		    if(this.isAlarmExpirated(alarm)) {
		    	this.notifyAllObservers(alarm); 
		    }
		}
	}
	
	private boolean isAlarmExpirated(Alarm alarm) {
		Date actualDate = new Date();
		if(actualDate.after(alarm.getExpirationDate()))
			return true;
		else
			return false;
	}
	
	private void notifyAllObservers(Alarm alarm) {
		setChanged();
        notifyObservers(alarm);
	}

	public void setActiveAlarms(ArrayList<Alarm> activeAlarms) {
		this.activeAlarms = activeAlarms;	
	}
	
	@Override
	public void run() {
		this.scannAlarms();
	}

	public List<Alarm> getActiveAlarms() {
		return this.activeAlarms;
	}

//	public void setActiveAlarms(List<Alarm> activeAlarms) {
//		this.activeAlarms = activeAlarms;
//	}
	
}
