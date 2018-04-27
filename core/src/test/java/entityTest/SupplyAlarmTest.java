package entityTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Entities.Supply;
import Entities.SupplyAlarm;

public class SupplyAlarmTest {
	
	private Supply supply;
	private SupplyAlarm supplyAlarm;
	
	@Before
	public void prepareDependencies() {
		this.supply =  new Supply("Lampara", 10, 10);
		this.supplyAlarm =  new SupplyAlarm(supply, new Date());
	}
	
	@Test
	public void getterTest() {
		assertEquals(supplyAlarm.getSupply(),supply);
	}
}
