package entityTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import Entities.Supply;
import Entities.SupplyAlarm;

public class SupplyAlarmTest {

	@Test
	public void getterTest() {
		Supply supply =  new Supply("Lampara", 10, 10);
		SupplyAlarm supplyAlarm =  new SupplyAlarm(supply, new Date());
		assertEquals(supplyAlarm.getSupply(),supply);
	}
}
