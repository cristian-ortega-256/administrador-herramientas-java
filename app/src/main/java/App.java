import java.util.ArrayList;
import java.util.List;

import Entities.Alarm;
import controller.LoanController;
import controller.RetreatController;
import model.LoanFormViewModel;
import model.RetreatFormViewModel;
import model.SchedulerTaskExecutor;
import model.SupplySystem;
import model.ToolSystem;
import model.AlarmObserver;
import model.AlarmStatusVerifier;
import model.AlarmSystem;
import model.BorrowerSystem;
import view.RetreatView;
import view.View;

public class App {
	public static void main(String[] args) {
		View view = new View();
		RetreatView rView = new RetreatView();
		
		ToolSystem ts = new ToolSystem();
		BorrowerSystem ws = new BorrowerSystem();
		SupplySystem ss = new SupplySystem();
		
		LoanFormViewModel vm = new LoanFormViewModel();
		vm.setAllBorrowers(ws.getBorrowers());
		vm.setAllTools(ts.getAllTools());
		
		RetreatFormViewModel rvm = new RetreatFormViewModel();
		rvm.setAllBorrowers(ws.getBorrowers());
		rvm.setAllSupplies(ss.getAllSupplies());
		
		AlarmSystem alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		
		LoanController controller = new LoanController(view,vm,alarmSystem);
		controller.initialize();
		
		RetreatController rController = new RetreatController(rView, rvm, controller.getAdapterUI(),alarmSystem);
		rController.initialize();
		
		// -------- NEW ----------
		
		AlarmStatusVerifier alarmVerifier = new AlarmStatusVerifier();
		
		AlarmObserver alarmObserver = new AlarmObserver(alarmVerifier);
		
		alarmSystem.addObserver(alarmObserver);
		
		List<Runnable> scheduledTasks = new ArrayList<Runnable>();
		scheduledTasks.add(alarmVerifier);
		
		SchedulerTaskExecutor scheduledExecutor = new SchedulerTaskExecutor(scheduledTasks);
		scheduledExecutor.executeScheduledTasks();
		
	}
}