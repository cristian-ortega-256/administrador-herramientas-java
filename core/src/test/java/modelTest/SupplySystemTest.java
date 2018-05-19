
package modelTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Entities.Borrower;
import Entities.Retreat;
import Entities.Supply;
import model.SupplySystem;

public class SupplySystemTest {
	
	private SupplySystem ss;
	private Supply supply;
	private Borrower borrower;
	private Retreat retreat;
	private List<Supply> listSupplies;

	@Before
	public void prepareDependencies() {
		this.ss = new SupplySystem();
		this.listSupplies = new ArrayList<Supply>();
		this.listSupplies.add(new Supply("Tornillos",100,500));
		this.listSupplies.add(new Supply("Clavos",80,40));
		this.listSupplies.add(new Supply("Lamparas", 50,25));
		this.listSupplies.add(new Supply("Tubos de luz",20,10));
		this.ss.setAllSupplies(listSupplies);
		this.supply = new Supply("Clavos", 100, 20);
		this.borrower = new Borrower("Goku");
		this.retreat = new Retreat(1, borrower, supply, 50);
	}
	
	@Test
	public void testSupplySystemControler() {
		assertEquals(ss.getAllSupplies().size(),4);
	}
	
	@Test
	public void testSupplySystemValidation() {
		assertTrue(ss.suppliesValidations(supply, retreat.getQuantity()));
		
		retreat.setQuantity(101);
		assertFalse(ss.suppliesValidations(supply, retreat.getQuantity()));
		
		supply.setStock(0);
		assertFalse(ss.suppliesValidations(supply, retreat.getQuantity()));
	}
	
	@Test
	public void testSupplySystemDiscountStockSupply(){
		ss.discountStockSupply(supply, retreat.getQuantity());
		assertEquals(supply.getStock(), 50);
	}
}
