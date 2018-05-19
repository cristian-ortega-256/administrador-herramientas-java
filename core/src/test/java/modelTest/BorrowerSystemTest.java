package modelTest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Entities.Borrower;
import model.BorrowerSystem;

public class BorrowerSystemTest {
	
	private BorrowerSystem bs;
	private List<Borrower> list;
	
	@Before
	public void prepareDependencies() {
		this.bs = new BorrowerSystem(); 
		this.list = new ArrayList<Borrower>();
		list.add(new Borrower("Goku"));
		list.add(new Borrower("Gohan"));
		list.add(new Borrower("Trunks"));
		list.add(new Borrower("Vegeta"));
		this.bs.setWorkers(list);
	}

	@Test 
	public void testBorrowSystem() {
		assertTrue(bs.getBorrowers().size() == 4);
	}
	
}
