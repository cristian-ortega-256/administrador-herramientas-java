package entityTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Entities.Borrower;
import Entities.Retreat;
import Entities.Supply;

public class RetreatTest {

	
	@Test
	public void testRetreatBorrower() {
		Borrower borrower = new Borrower("Goku");
		Supply supply = new Supply("Clavos", 100, 40);
		Retreat retreat = new Retreat(1, borrower, supply, 20);
		
		assertEquals(retreat.getBorrower().getName(), borrower.getName());
	}
	
	@Test
	public void testRetreatSupply() {
		Borrower borrower = new Borrower("Goku");
		Supply supply = new Supply("Clavos", 100, 40);
		Retreat retreat = new Retreat(1, borrower, supply, 20);
		
		assertEquals(retreat.getSupply().getName(), supply.getName());
	}
	
	@Test
	public void testRetreatQuantity() {
		Borrower borrower = new Borrower("Goku");
		Supply supply = new Supply("Clavos", 100, 40);
		Retreat retreat = new Retreat(1, borrower, supply, 20);
		
		assertEquals(retreat.getQuantity(), 20);
	}
	
	@Test
	public void testRetreatToString() {
		Borrower borrower = new Borrower("Goku");
		Supply supply = new Supply("Clavos", 100, 40);
		Retreat retreat = new Retreat(1, borrower, supply, 20);
		
		assertEquals(retreat.toString(), "Id: " + 1 + 
				" - Remover: " + retreat.getBorrower().getName() + 
				" - Supply: " + retreat.getSupply().getName() + 
				" - Quantity: " + retreat.getQuantity());
	}
}
