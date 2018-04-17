package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Entities.Borrower;
import Entities.Retreat;
import Entities.Supply;
import model.RetreatSystem;
import model.SupplySystem;

public class RetreatSystemTest {

	
	@Test
	public void testCheckRetreatGeneration() {
		SupplySystem ss = new SupplySystem();
		RetreatSystem rs = new RetreatSystem(ss);
		
		Supply supply = new Supply("Clavos", 100, 20);
		Borrower borrower = new Borrower("Goku");
		Retreat retreat = new Retreat(1, borrower, supply, 50);
		
		rs.checkRetreatGeneration(retreat.getSupply(), retreat.getBorrower(), retreat.getQuantity());
		assertEquals(rs.getRetreats().size(), 1);
		
		retreat.setQuantity(103);
		rs.checkRetreatGeneration(retreat.getSupply(), retreat.getBorrower(), retreat.getQuantity());
		assertEquals(rs.getRetreats().size(), 1);
	}
}
