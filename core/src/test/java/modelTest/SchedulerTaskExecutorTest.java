package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.AlarmStatusVerifier;
import model.SchedulerTaskExecutor;

public class SchedulerTaskExecutorTest {
	@Test
	public void tesConstructor() {
		AlarmStatusVerifier alarmStatusVerifier = new AlarmStatusVerifier();
		List<Runnable> runnables = new ArrayList<Runnable>();
		runnables.add(alarmStatusVerifier);
		SchedulerTaskExecutor schedulerTaskExecutor = new SchedulerTaskExecutor(runnables);
		assertEquals(schedulerTaskExecutor.getRunnables().size(),1);
	}
	
	@Test
	public void tesRunnersExecution() {
		AlarmStatusVerifier alarmStatusVerifier = new AlarmStatusVerifier();
		List<Runnable> runnables = new ArrayList<Runnable>();
		runnables.add(alarmStatusVerifier);
		SchedulerTaskExecutor schedulerTaskExecutor = new SchedulerTaskExecutor(runnables);
		schedulerTaskExecutor.executeScheduledTasks();
	}
}
