package modelTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.BorrowerSystem;
import model.LoanFormViewModel;
import model.ToolSystem;

public class LoanFormViewModelTest {
	
	private LoanFormViewModel vm;
	private BorrowerSystem ws;
	private ToolSystem ts;
	
	@Before
	public void prepareDependencies() {
		this.vm = new LoanFormViewModel();
		this.ws = new BorrowerSystem();
		this.ts = new ToolSystem();
	}
	
	@Test
	public void testSetBorrowers() {
		vm.setAllBorrowers(ws.getBorrowers());
		assertTrue(vm.getAllBorrowers().size() == 4);
	}
	
	@Test
	public void testSetTools() {
		vm.setAllTools(ts.getAllTools());
		assertTrue(vm.getAllTools().size() == 9);
	}

}
