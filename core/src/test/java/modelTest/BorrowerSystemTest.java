package modelTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.BorrowerSystem;

public class BorrowerSystemTest {
	
	private BorrowerSystem bs;
	
	@Before
	public void prepareDependencies() {
		this.bs = new BorrowerSystem();
	}

	@Test 
	public void testBorrowSystem() {
		assertTrue(bs.getBorrowers().size() == 4);
	}
	
}
