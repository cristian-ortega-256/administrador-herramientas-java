import java.util.ArrayList;
import java.util.List;

import Entities.Alarm;
import controller.LoanController;
import controller.RetreatController;
import model.LoanFormViewModel;
import model.LoanObserver;
import model.LoanSystem;
import model.NotificationSystem;
import model.RetreatFormViewModel;
import model.RetreatSystem;
import model.SchedulerTaskExecutor;
import model.SupplyObserver;
import model.SupplySystem;
import model.ToolSystem;
import model.AlarmObserver;
import model.AlarmStatusVerifier;
import model.AlarmSystem;
import model.BorrowerSystem;
import model.ExpiredAlarmObserver;
import view.AdapterUI;
import view.RetreatView;
import view.View;

public class App {
	public static void main(String[] args) {
		View view = new View();
		RetreatView rView = new RetreatView();
		
		ToolSystem ts = new ToolSystem();
		BorrowerSystem ws = new BorrowerSystem();
		SupplySystem ss = new SupplySystem();
		
		AlarmSystem alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		
		AdapterUI adapterUI = new AdapterUI();
		
		// LOAN SECTION
		LoanFormViewModel vm = new LoanFormViewModel();
		vm.setAllBorrowers(ws.getBorrowers());
		vm.setAllTools(ts.getAllTools());
		
		LoanSystem loanSystem = new LoanSystem(ts.getAllTools());
		LoanController lController = new LoanController(view,vm,loanSystem,adapterUI);
		loanSystem.addObserver(new LoanObserver(alarmSystem));
		loanSystem.addObserver(adapterUI);
		
		lController.initialize();
		
		// SUPPLY SECTION
		SupplySystem supplySystem = new SupplySystem();
		supplySystem.addObserver(new SupplyObserver(alarmSystem));
		
		// RETREAT SECTION
		RetreatFormViewModel rvm = new RetreatFormViewModel();
		rvm.setAllBorrowers(ws.getBorrowers());
		rvm.setAllSupplies(ss.getAllSupplies());
		
		RetreatSystem retreatSystem = new RetreatSystem(supplySystem);
		retreatSystem.addObserver(adapterUI);
		RetreatController rController = new RetreatController(rView, rvm,retreatSystem);
		rController.initialize();
		
		alarmSystem.addObserver(adapterUI);
		
		// ALarm Status Verifier Section
		
		AlarmStatusVerifier alarmVerifier = new AlarmStatusVerifier();
		
		AlarmObserver alarmObserver = new AlarmObserver(alarmVerifier);
		
		alarmSystem.addObserver(alarmObserver);
		
		NotificationSystem notificationSystem = new NotificationSystem();
		ExpiredAlarmObserver expiredObserver = new ExpiredAlarmObserver(notificationSystem);
		alarmVerifier.addObserver(expiredObserver);
		
		List<Runnable> scheduledTasks = new ArrayList<Runnable>();
		scheduledTasks.add(alarmVerifier);
		
		SchedulerTaskExecutor scheduledExecutor = new SchedulerTaskExecutor(scheduledTasks);
		scheduledExecutor.executeScheduledTasks();

	}
}