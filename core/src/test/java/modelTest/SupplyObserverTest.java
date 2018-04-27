package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Entities.Alarm;
import Entities.Borrower;
import Entities.Supply;
import model.AlarmSystem;
import model.RetreatSystem;
import model.SupplyObserver;
import model.SupplySystem;

public class SupplyObserverTest {
	
	private SupplySystem ss;
	private Supply supply;
	private Borrower borrower;
	private AlarmSystem alarmSystem;
	private RetreatSystem retreatSystem;
	
	@Before
	public void prepareDependencies() {
		this.ss = new SupplySystem();
		this.supply = new Supply("Clavos", 11, 10);
		this.borrower = new Borrower("Goku");
		this.alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		this.retreatSystem = new RetreatSystem(ss);
	}
	
	@Test
	public void hasEnoughStockEventHandlingTest() {
		
		assertEquals(alarmSystem.getActiveAlarms().size(), 0);
		
		ss.addObserver(new SupplyObserver(alarmSystem));
		
		retreatSystem.checkRetreatGeneration(supply, borrower, 10);
		
		assertEquals(alarmSystem.getActiveAlarms().size(), 1);
	}
	
}
