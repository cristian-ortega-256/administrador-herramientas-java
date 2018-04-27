package entityTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Entities.Borrower;
import Entities.Retreat;
import Entities.Supply;

public class RetreatTest {
	
	private Borrower borrower;
	private Supply supply;
	private Retreat retreat;
	
	@Before
	public void prepareDependencies() {
		this.borrower = new Borrower("Goku");
		this.supply = new Supply("Clavos", 100, 40);
		this.retreat = new Retreat(1, borrower, supply, 20);
	}
	
	@Test
	public void testRetreatBorrower() {		
		assertEquals(retreat.getBorrower().getName(), borrower.getName());
	}
	
	@Test
	public void testRetreatSupply() {
		assertEquals(retreat.getSupply().getName(), supply.getName());
	}
	
	@Test
	public void testRetreatQuantity() {
		assertEquals(retreat.getQuantity(), 20);
	}
	
	@Test
	public void testRetreatToString() {
		assertEquals(retreat.toString(), "Id: " + 1 + 
				" - Remover: " + retreat.getBorrower().getName() + 
				" - Supply: " + retreat.getSupply().getName() + 
				" - Quantity: " + retreat.getQuantity());
	}
}
