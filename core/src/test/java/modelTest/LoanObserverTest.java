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
	private ToolType tt;
	private LoanSystem loanSystem;
	private AlarmSystem alarmSystem;
	private List<Tool> listTools;
	
	@Before
	public void prepareDependencies() {
		this.tools = new ToolSystem();
		this.listTools = new ArrayList<Tool>();
		this.tt = new ToolType("Martillo");
		this.listTools.add(new Tool("Martillo #1", this.tt));
		this.listTools.add(new Tool("Destornilador #1", this.tt));
		this.listTools.add(new Tool("Taladro #3", this.tt));
		this.tools.setTools(listTools);
		this.borrower = new Borrower("Goku");
		this.tool = tools.getAllTools().get(0);
		this.tool.setId(1);
		this.loanSystem = new LoanSystem(tools.getAllTools());
		this.alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
	}
	
	@Test
	public void loanCreatedEventHandlingTest() {
		loanSystem.addObserver(new LoanObserver(alarmSystem));
		loanSystem.checkLoanGeneration(tool, borrower);
		assertEquals(1,alarmSystem.getActiveAlarms().size());
	}
}
