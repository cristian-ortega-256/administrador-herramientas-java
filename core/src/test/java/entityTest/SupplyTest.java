package entityTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import Entities.Supply;

public class SupplyTest {

	
	@Test
	public void testSupplyItem() {
		Supply supply = new Supply("", 0 , 0);
		supply.setName("Clavos");
		supply.setStock(100);
		supply.setMinimumStock(20);
		assertEquals(supply, new Supply("Clavos", 100, 20));
		assertFalse(supply.equals(new Supply(null, 100, 20)));
		assertFalse(supply.equals(new Supply("Tornillos", 100, 20)));
		assertEquals(supply.getMinimumStock(), 20);
	}
	
	@Test
	public void testSupplyToString() {
		Supply supply = new Supply("Clavos", 0 , 0);
		assertEquals(supply.toString(), "Clavos");
	}
}
