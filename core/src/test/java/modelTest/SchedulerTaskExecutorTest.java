package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.AlarmStatusVerifier;
import model.SchedulerTaskExecutor;

public class SchedulerTaskExecutorTest {
	
	private AlarmStatusVerifier alarmStatusVerifier;
	private List<Runnable> runnables;
	private SchedulerTaskExecutor schedulerTaskExecutor;
	
	@Before
	public void prepareDependencies() {
		this.alarmStatusVerifier = new AlarmStatusVerifier();
		this.runnables = new ArrayList<Runnable>();
		runnables.add(alarmStatusVerifier);
		this.schedulerTaskExecutor = new SchedulerTaskExecutor(runnables);
	}
	
	@Test
	public void tesConstructor() {
		assertEquals(schedulerTaskExecutor.getRunnables().size(),1);
	}
	
	@Test
	public void tesRunnersExecution() {
		schedulerTaskExecutor.executeScheduledTasks();
	}
}
