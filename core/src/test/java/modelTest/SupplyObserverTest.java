package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Entities.Alarm;
import Entities.Borrower;
import Entities.Supply;
import model.AlarmSystem;
import model.RetreatSystem;
import model.SupplyObserver;
import model.SupplySystem;

public class SupplyObserverTest {
	
	@Test
	public void hasEnoughStockEventHandlingTest() {
		SupplySystem ss = new SupplySystem();
		Supply supply = new Supply("Clavos", 11, 10);
		Borrower borrower = new Borrower("Goku");
		
		AlarmSystem alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		assertEquals(alarmSystem.getActiveAlarms().size(), 0);
		
		ss.addObserver(new SupplyObserver(alarmSystem));
		
		RetreatSystem retreatSystem = new RetreatSystem(ss);
		retreatSystem.checkRetreatGeneration(supply, borrower, 10);
		
		assertEquals(alarmSystem.getActiveAlarms().size(), 1);
	}
	
}
