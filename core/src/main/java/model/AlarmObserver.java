package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Entities.Alarm;

public class AlarmObserver implements Observer{
	
	private AlarmStatusVerifier alarmStatusVerifier;
	
	public AlarmObserver(AlarmStatusVerifier alarmStatusVerifier) {
		this.alarmStatusVerifier = alarmStatusVerifier;
	}

	@Override
	public void update(Observable o, Object arg) {
		notifyAll((ArrayList<Alarm>)arg);
	}

	private void notifyAll(ArrayList<Alarm> alarms) {
		alarmStatusVerifier.setActiveAlarms(alarms);
	}

}
