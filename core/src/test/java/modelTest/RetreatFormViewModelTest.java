package modelTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.BorrowerSystem;
import model.RetreatFormViewModel;
import model.SupplySystem;

public class RetreatFormViewModelTest {
	
	private RetreatFormViewModel rvm;
	private BorrowerSystem ws;
	private SupplySystem ss;
	
	@Before
	public void prepareDependencies() {
		this.rvm = new RetreatFormViewModel();
		this.ws = new BorrowerSystem();
		this.ss = new SupplySystem();
	}
	
	@Test
	public void testSetBorrowers() {
		rvm.setAllBorrowers(ws.getBorrowers());
		assertTrue(rvm.getAllBorrowers().size() == 4);
	}
	
	@Test
	public void testSetSupplies() {
		rvm.setAllSupplies(ss.getAllSupplies());
		assertTrue(rvm.getAllSupplies().size() == 4);
	}

}
