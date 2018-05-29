package databaseTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Entities.Borrower;
import database.BorrowerDAO;

public class BorrowerDAOTest {
	
	private BorrowerDAO bDao;
	private List<Borrower> listBorrowers;
	private List<Borrower> listBorrowersDAO;
	private Borrower borrower;

	@Before
	public void prepareDependencies() {
		try {
			this.bDao = new BorrowerDAO();
			this.listBorrowers = new ArrayList<Borrower>();
			this.listBorrowers.add(new Borrower("Goku"));
			this.listBorrowers.add(new Borrower("Vegeta"));
			this.listBorrowersDAO = new ArrayList<Borrower>();
			this.listBorrowersDAO = bDao.GetAll();
			this.borrower = bDao.GetOne("Goku");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAll() {
		assertEquals(this.listBorrowersDAO.size(), this.listBorrowers.size());
	}
	
	@Test
	public void testGetOne() {
		System.out.println(this.borrower.getName());
		System.out.println(this.listBorrowers.get(0).getName());
		assertEquals(this.borrower.getName(), this.listBorrowers.get(0).getName());
	}
	
	
}
