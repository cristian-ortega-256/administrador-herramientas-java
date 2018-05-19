package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Entities.Alarm;

public class ExpiredAlarmObserver implements Observer {
	private NotificationSystem notificationSystem;
	
	public ExpiredAlarmObserver(NotificationSystem notificationSystem) {
		this.notificationSystem = notificationSystem;
	}

	@Override
	public void update(Observable o, Object arg) {
		notifyAll((Alarm)arg);
	}

	private void notifyAll(Alarm alarm) {
		notificationSystem.createNotification(alarm);
	}

}
