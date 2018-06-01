package databaseTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Entities.Supply;
import database.SupplyDAO;

public class SupplyDAOTest {

	private SupplyDAO sDao;
	private Supply supply;
	private List<Supply> list;
	private List<Supply> listDAO;
	
	@Before
	public void prepareDependencies() {
		try {
			this.sDao = new SupplyDAO();
			this.listDAO = this.sDao.GetAll();	
			this.list = new ArrayList<Supply>();
			this.list.add(new Supply("Tornillos", 100, 50));
			this.list.add(new Supply("Clavos", 100, 50));
			this.supply = this.sDao.GetOne("Tornillos");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testGetAll() {
		assertEquals(this.list.size(), this.listDAO.size());
	}
	
	@Test
	public void testGetOne() {
		assertEquals(this.list.get(0).getName(), this.supply.getName());
	}
	
}
