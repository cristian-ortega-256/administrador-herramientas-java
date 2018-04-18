package model;

import java.util.Observable;
import java.util.Observer;

import Entities.Loan;
import Entities.Supply;

public class SupplyObserver implements Observer{
	
	private AlarmSystem alarmSystem;
	
	public SupplyObserver(AlarmSystem alarmSystem) {
		this.alarmSystem = alarmSystem;
	}

	@Override
	public void update(Observable o, Object arg) {
		notifyAlarmSystem((Supply)arg);
	}
	
	private void notifyAlarmSystem(Supply s) {
		alarmSystem.checkSupplyAlarmCreation(s);
	}

}
