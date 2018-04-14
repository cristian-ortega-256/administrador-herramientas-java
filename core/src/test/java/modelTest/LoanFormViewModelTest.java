package modelTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.BorrowerSystem;
import model.LoanFormViewModel;
import model.ToolSystem;

public class LoanFormViewModelTest {
	
	@Test
	public void testSetBorrowers() {
		LoanFormViewModel vm = new LoanFormViewModel();
		BorrowerSystem ws = new BorrowerSystem();
		vm.setAllBorrowers(ws.getBorrowers());
		assertTrue(vm.getAllBorrowers().size() == 4);
	}
	
	@Test
	public void testSetTools() {
		LoanFormViewModel vm = new LoanFormViewModel();
		ToolSystem ts = new ToolSystem();
		vm.setAllTools(ts.getAllTools());
		assertTrue(vm.getAllTools().size() == 9);
	}

}
