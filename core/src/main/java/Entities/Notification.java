package Entities;

public class Notification {

	private String title;
	private String message;
	private Alarm associatedAlarm;
	
	public Notification(String title, String message, Alarm associatedAlarm) {
		this.title = title;
		this.message = message;
		this.associatedAlarm = associatedAlarm;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public Alarm getAssociatedAlarm() {
		return this.associatedAlarm;
	}
}
