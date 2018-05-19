package modelTest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Entities.Borrower;
import Entities.Supply;
import model.BorrowerSystem;
import model.RetreatFormViewModel;
import model.SupplySystem;

public class RetreatFormViewModelTest {
	
	private RetreatFormViewModel rvm;
	private BorrowerSystem ws;
	private SupplySystem ss;
	private List<Supply> listSupplies;
	private List<Borrower> list;
	
	@Before
	public void prepareDependencies() {
		this.rvm = new RetreatFormViewModel();
		this.ws = new BorrowerSystem();
		this.list = new ArrayList<Borrower>();
		list.add(new Borrower("Goku"));
		list.add(new Borrower("Gohan"));
		list.add(new Borrower("Trunks"));
		list.add(new Borrower("Vegeta"));
		this.ws.setWorkers(list);
		this.ss = new SupplySystem();
		this.listSupplies = new ArrayList<Supply>();
		this.listSupplies.add(new Supply("Tornillos",100,500));
		this.listSupplies.add(new Supply("Clavos",80,40));
		this.listSupplies.add(new Supply("Lamparas", 50,25));
		this.listSupplies.add(new Supply("Tubos de luz",20,10));
		this.ss.setAllSupplies(listSupplies);
	}
	
	@Test
	public void testSetBorrowers() {
		rvm.setAllBorrowers(ws.getBorrowers());
		assertTrue(rvm.getAllBorrowers().size() == 4);
	}
	
	@Test
	public void testSetSupplies() {
		rvm.setAllSupplies(ss.getAllSupplies());
		assertTrue(rvm.getAllSupplies().size() == 4);
	}

}
