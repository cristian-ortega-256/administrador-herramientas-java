package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Entities.Borrower;
import Entities.Retreat;
import Entities.Supply;
import model.RetreatSystem;
import model.SupplySystem;

public class RetreatSystemTest {
	
	private SupplySystem ss;
	private RetreatSystem rs;
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
		this.rs = new RetreatSystem(ss);
		this.supply = new Supply("Clavos", 100, 20);
		this.borrower = new Borrower("Goku");
		this.retreat = new Retreat(1, borrower, supply, 50);
	}
	
	@Test
	public void testCheckRetreatGeneration() {
		rs.checkRetreatGeneration(retreat.getSupply(), retreat.getBorrower(), retreat.getQuantity());
		assertEquals(rs.getRetreats().size(), 1);
		retreat.setQuantity(103);
		rs.checkRetreatGeneration(retreat.getSupply(), retreat.getBorrower(), retreat.getQuantity());
		assertEquals(rs.getRetreats().size(), 1);
	}
}
