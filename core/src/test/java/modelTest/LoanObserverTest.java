package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Entities.Alarm;
import Entities.Borrower;
import Entities.Tool;
import Entities.ToolType;
import model.AlarmSystem;
import model.LoanObserver;
import model.LoanSystem;
import model.ToolSystem;

public class LoanObserverTest {
	
	private ToolSystem tools;
	private Borrower borrower;
	private Tool tool;
	private LoanSystem loanSystem;
	private AlarmSystem alarmSystem;
	private List<Tool> listTools;
	
	@Before
	public void prepareDependencies() {
		this.tools = new ToolSystem();
		this.listTools = new ArrayList<Tool>();
		this.listTools.add(new Tool("Martillo",ToolType.Martillo));
		this.listTools.add(new Tool("Destornilador",ToolType.Destornillador));
		this.listTools.add(new Tool("Taladro",ToolType.Taladro));
		this.tools.setTools(listTools);
		this.borrower = new Borrower("Pepe");
		this.tool = tools.getAllTools().get(0);
		this.loanSystem = new LoanSystem(tools.getAllTools());
		this.alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
	}
	
	@Test
	public void loanCreatedEventHandlingTest() {
		assertEquals(alarmSystem.getActiveAlarms().size(), 0);
		
		loanSystem.addObserver(new LoanObserver(alarmSystem));
		
		loanSystem.checkLoanGeneration(tool, borrower);
		
		assertEquals(alarmSystem.getActiveAlarms().size(), 1);
	}
}
