package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Entities.Alarm;
import Entities.Borrower;
import Entities.Tool;
import model.AlarmSystem;
import model.LoanObserver;
import model.LoanSystem;
import model.ToolSystem;

public class LoanObserverTest {
	@Test
	public void loanCreatedEventHandlingTest() {
		ToolSystem tools = new ToolSystem();
		Borrower borrower = new Borrower("Pepe");
		Tool tool = tools.getAllTools().get(0);
		LoanSystem loanSystem = new LoanSystem(tools.getAllTools());
		
		AlarmSystem alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		assertEquals(alarmSystem.getActiveAlarms().size(), 0);
		
		loanSystem.addObserver(new LoanObserver(alarmSystem));
		
		loanSystem.checkLoanGeneration(tool, borrower);
		
		assertEquals(alarmSystem.getActiveAlarms().size(), 1);
	}
}
