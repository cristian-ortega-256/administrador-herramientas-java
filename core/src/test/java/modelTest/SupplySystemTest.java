
package modelTest;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Entities.Alarm;
import Entities.Borrower;
import Entities.Retreat;
import Entities.Supply;
import model.AlarmSystem;
import model.RetreatSystem;
import model.SupplyObserver;
import model.SupplySystem;

public class SupplySystemTest {

	
	@Test
	public void testSupplySystemControler() {
		SupplySystem ss = new SupplySystem();
		assertEquals(ss.getAllSupplies().size(),4);
	}
	
	@Test
	public void testSupplySystemValidation() {
		SupplySystem ss = new SupplySystem();
		Supply supply = new Supply("Clavos", 100, 20);
		Borrower borrower = new Borrower("Goku");
		Retreat retreat = new Retreat(1, borrower, supply, 50);
		assertTrue(ss.suppliesValidations(supply, retreat.getQuantity()));
		
		retreat.setQuantity(101);
		assertFalse(ss.suppliesValidations(supply, retreat.getQuantity()));
		
		supply.setStock(0);
		assertFalse(ss.suppliesValidations(supply, retreat.getQuantity()));
	}
	
	@Test
	public void testSupplySystemDiscountStockSupply(){
		SupplySystem ss = new SupplySystem();
		Supply supply = new Supply("Clavos", 100, 20);
		Borrower borrower = new Borrower("Goku");
		Retreat retreat = new Retreat(1, borrower, supply, 51);
		ss.discountStockSupply(supply, retreat.getQuantity());
		assertEquals(supply.getStock(), 49);
	}
}
