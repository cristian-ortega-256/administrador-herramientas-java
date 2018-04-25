package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Entities.Alarm;
import Entities.Borrower;
import Entities.Supply;
import model.AlarmObserver;
import model.AlarmStatusVerifier;
import model.AlarmSystem;
import model.SchedulerTaskExecutor;

public class AlarmStatusVerifierTest {
	
	@Test
	public void testAlarmExpiration() {
		Borrower borrower = new Borrower("Pepe");
		Supply supply = new Supply("Tornillos",100,500);
		AlarmSystem alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		
		AlarmStatusVerifier alarmVerifier = new AlarmStatusVerifier();
		assertEquals(alarmVerifier.getActiveAlarms().size(),0);
		
		AlarmObserver alarmObserver = new AlarmObserver(alarmVerifier);
		assertEquals(alarmVerifier.getActiveAlarms().size(),0);
		alarmSystem.addObserver(alarmObserver);
		
		alarmSystem.checkSupplyAlarmCreation(supply);
		assertEquals(alarmVerifier.getActiveAlarms().size(),1);
		
		List<Runnable> runnables = new ArrayList<Runnable>();
		runnables.add(alarmVerifier);
		
		// TODO --> CHECK THE WAY TO EXECUTE AND TEST ASYNC TASKS
		SchedulerTaskExecutor schedulerTaskExecutor = new SchedulerTaskExecutor(runnables);
		schedulerTaskExecutor.executeScheduledTasks();
		
		assertEquals(alarmVerifier.getActiveAlarms().size(),1);
	}

}
