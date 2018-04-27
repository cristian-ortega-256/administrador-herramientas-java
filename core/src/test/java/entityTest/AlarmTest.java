package entityTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Entities.Alarm;

public class AlarmTest {
	
	private Date date;
	private Alarm alarm;
	
	@Before
	public void prepareDependencies() {
		this.date = new Date();
		this.alarm = new Alarm(date);
	}
	
	@Test
	public void testConstructor() {
		assertEquals(alarm.getExpirationDate(),date);
	}
	
	@Test
	public void testToString() {
		assertEquals(alarm.toString(),date.toString());
	}
	
}
