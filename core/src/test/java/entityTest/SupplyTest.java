package entityTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import Entities.Supply;

public class SupplyTest {
	
	private Supply supply;
	
	@Before
	public void prepareDependencies() {
		this.supply = new Supply("", 0 , 0);
	}

	
	@Test
	public void testSupplyItem() {
		this.supply.setName("Clavos");
		this.supply.setStock(100);
		this.supply.setMinimumStock(20);
		assertEquals(supply, new Supply("Clavos", 100, 20));
		assertFalse(supply.equals(new Supply(null, 100, 20)));
		assertFalse(supply.equals(new Supply("Tornillos", 100, 20)));
		assertEquals(supply.getMinimumStock(), 20);
	}
	
	@Test
	public void testSupplyToString() {
		this.supply.setName("Clavos");
		assertEquals(supply.toString(), "Clavos");
	}
}
