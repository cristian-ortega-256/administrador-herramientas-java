package model;

import java.util.Observable;
import java.util.Observer;

import Entities.Loan;

public class LoanObserver implements Observer{
	
	private AlarmSystem alarmSystem;
	
	public LoanObserver(AlarmSystem alarmSystem) {
		this.alarmSystem = alarmSystem;
	}

	@Override
	public void update(Observable o, Object arg) {
		notifyAlarmSystem((Loan)arg);
	}
	
	private void notifyAlarmSystem(Loan l) {
		alarmSystem.checkAlarmCreation(l);
	}

}
