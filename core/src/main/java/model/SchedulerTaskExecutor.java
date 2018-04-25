package model;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerTaskExecutor {

	private ScheduledExecutorService schedulerExecutor;
	private List<Runnable> runnables;
	private final int initialDelay = 5;
	private final int schedulerDelay = 5;
	private final TimeUnit timeUnit = TimeUnit.SECONDS;
	
	public SchedulerTaskExecutor(List<Runnable> runnables) {
		this.runnables = runnables;
		this.initializeThreadsPool(runnables.size());
	}
	
	private void initializeThreadsPool(int amount) {
		this.schedulerExecutor = Executors.newScheduledThreadPool(amount);
	}

	public void executeScheduledTasks() {
		for (Runnable runnable: this.runnables) {
			this.executeTask(runnable);
		}
	}
	
	private void executeTask(Runnable runnable) {
		this.schedulerExecutor.scheduleAtFixedRate(runnable, this.initialDelay, this.schedulerDelay, this.timeUnit);
	}

	public List<Runnable> getRunnables() {
		return this.runnables;
	}
	
}
