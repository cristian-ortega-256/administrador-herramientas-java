import java.util.ArrayList;
import java.util.List;

import com.codoid.products.exception.FilloException;

import Entities.Alarm;
import controller.LoanController;
import controller.RetreatController;
import database.BorrowerDAO;
import database.SupplyDAO;
import database.ToolDAO;
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
	public static void main(String[] args) throws FilloException{
		View view = new View();
		RetreatView rView = new RetreatView();
		
		ToolSystem ts = new ToolSystem();
		ts.setTools(new ToolDAO().GetAll());
		
		BorrowerSystem ws = new BorrowerSystem();
		ws.setWorkers(new BorrowerDAO().GetAll());
		
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
		SupplySystem ss = new SupplySystem();
		ss.setAllSupplies(new SupplyDAO().GetAll());
		ss.addObserver(new SupplyObserver(alarmSystem));
		
		// RETREAT SECTION
		RetreatFormViewModel rvm = new RetreatFormViewModel();
		rvm.setAllBorrowers(ws.getBorrowers());
		rvm.setAllSupplies(ss.getAllSupplies());
		
		RetreatSystem retreatSystem = new RetreatSystem(ss);
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