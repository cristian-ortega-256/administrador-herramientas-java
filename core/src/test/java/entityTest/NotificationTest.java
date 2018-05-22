package entityTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Entities.Alarm;
import Entities.Notification;

public class NotificationTest {
	
	private Alarm alarm;
	private Notification notification;
	
	@Before
	public void prepareDependencies() {
		this.alarm = new Alarm(new Date());
		this.notification = new Notification("Test","Test message", this.alarm);
	}
	
	@Test
	public void testTitleGetter() {
		assertEquals(this.notification.getTitle(),"Test");
	}
	
	@Test
	public void testMessageGetter() {
		assertEquals(this.notification.getMessage(),"Test message");
	}
	
	@Test
	public void testAssociatedAlarmGetter() {
		assertEquals(this.notification.getAssociatedAlarm(),this.alarm);
	}

}
