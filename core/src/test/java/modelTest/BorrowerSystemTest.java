package modelTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.BorrowerSystem;

public class BorrowerSystemTest {

	@Test 
	public void testBorrowSystem() {
		BorrowerSystem bs = new BorrowerSystem();
		assertTrue(bs.getBorrowers().size() == 4);
	}
	
}
