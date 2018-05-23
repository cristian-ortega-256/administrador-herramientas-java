package databaseTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Entities.Borrower;
import Entities.Loan;
import Entities.Tool;
import Entities.ToolType;
import database.LoanDAO;

public class LoanDAOTest {

	private Loan loan;
	private LoanDAO lDao;
	private List<Loan> list;
	private List<Loan> listDAO;
	private Recordset rs;
	
	//Exceptions
	private Loan l;
	private List<Loan> ll;
	
	@Before
	public void prepareDependencies() {
		try {
			this.rs = null;
			this.lDao = new LoanDAO();
			this.listDAO = this.lDao.GetAll();
			this.list = new ArrayList<Loan>();
			for (int i = 0; i < this.listDAO.size(); i++) {
				if (i == 1) this.list.add(new Loan(i, new Tool("Destornillador #1", new ToolType("Destornilladores")), new Borrower("Goku")));
				else this.list.add(new Loan(i, new Tool("Taladro #1", new ToolType("Taladros")), new Borrower("Goku"))); 
			}
			this.loan = lDao.GetOne("1");
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
		assertEquals(this.list.get(1).get_tool().getName(), this.loan.get_tool().getName());
	}
	
	@Test
	public void testParseLoansException() {
		try {
			this.ll = lDao.parseLoans(this.rs);
		} catch (Exception e) {
			assertEquals(null, this.ll);	
		}
	}
	
	@Test
	public void testParseLoanException() {
		try {
			this.l = lDao.parseLoan(this.rs);
		} catch (Exception e) {
			assertEquals(null, this.l);
		}
	}
	
	@Test
	public void testGetLastFreeNumberLoan() {
		try {
			assertEquals(this.listDAO.size(), lDao.GetLastFreeLoanNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void testGetLastFreeNumberLoanEmpty() {
//		try {
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
