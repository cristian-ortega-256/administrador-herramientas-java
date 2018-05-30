package databaseTest;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import Entities.Borrower;
import Entities.Retreat;
import Entities.Supply;
import database.RetreatLogDAO;

public class RetreatLogDAOTest {

	private RetreatLogDAO rlDao;
	private List<Retreat> listRetreats;
	private Retreat retreat;
	
	@Before
	public void prepareDependencies() {
		try {
			this.rlDao = new RetreatLogDAO();
			this.listRetreats = rlDao.GetAll();
			this.retreat = new Retreat(0, new Borrower("Goku"), new Supply("Tornillos", 100, 500), 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testAddRetreatLogDAO() {
		try {
			this.rlDao.Add(this.retreat);
			assertTrue(this.listRetreats.size() + 1 == rlDao.GetAll().size());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
