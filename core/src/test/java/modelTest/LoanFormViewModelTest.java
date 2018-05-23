package modelTest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Entities.Borrower;
import Entities.Tool;
import Entities.ToolType;
import model.BorrowerSystem;
import model.LoanFormViewModel;
import model.ToolSystem;

public class LoanFormViewModelTest {
	
	private LoanFormViewModel vm;
	private BorrowerSystem ws;
	private ToolSystem ts;
	private List<Tool> listTools;
	private List<Borrower> list;
	private ToolType tt;
	
	@Before
	public void prepareDependencies() {
		this.vm = new LoanFormViewModel();
		this.ws = new BorrowerSystem();
		this.list = new ArrayList<Borrower>();
		list.add(new Borrower("Goku"));
		list.add(new Borrower("Gohan"));
		list.add(new Borrower("Trunks"));
		list.add(new Borrower("Vegeta"));
		this.ws.setWorkers(list);
		this.ts = new ToolSystem();
		this.listTools = new ArrayList<Tool>();
		this.tt = new ToolType("Martillo");
		this.listTools.add(new Tool("Martillo", tt));
		this.listTools.add(new Tool("Destornilador",tt));
		this.listTools.add(new Tool("Taladro",tt));
		this.ts.setTools(listTools);
	}
	
	@Test
	public void testSetBorrowers() {
		vm.setAllBorrowers(ws.getBorrowers());
		assertTrue(vm.getAllBorrowers().size() == 4);
	}
	
	@Test
	public void testSetTools() {
		vm.setAllTools(ts.getAllTools());
		assertTrue(vm.getAllTools().size() == 3);
	}

}
