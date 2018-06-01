package databaseTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codoid.products.exception.FilloException;

import Entities.Borrower;
import Entities.Loan;
import Entities.Tool;
import Entities.ToolType;
import database.LoanDAO;
import database.LoanLogDAO;
import model.LoanSystem;

public class LoanLogDAOTest {
	
	private Borrower borrower;
	private ToolType tt;
	private Tool t;
	private LoanSystem loanSystem;
	private List<Tool> listTools;
	
	@Before
	public void prepareDependencies() {
		this.borrower = new Borrower("Goku");
		this.tt = new ToolType("Martillo");
		this.t = new Tool(2,"Taladro #2",this.tt);
		this.loanSystem = new LoanSystem(new ArrayList<Tool>());
		try {
			loanSystem.setLoans(new LoanDAO().GetAll());
			loanSystem.setLastLoanNumber();
		} catch (FilloException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoanLogPopulation() {
		try {
			LoanLogDAO lDao = new LoanLogDAO();
			List<Loan> initialLog = lDao.getAllLogRows();
			this.loanSystem.checkLoanGeneration(t, borrower);
			List<Loan> updatedLog = lDao.getAllLogRows();
			assertEquals(updatedLog.size(),initialLog.size()+1);
		} catch (FilloException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoanCreationLog() {
		try {
			LoanLogDAO lDao = new LoanLogDAO();
			this.loanSystem.checkLoanGeneration(t, borrower);
			List<Loan> updatedLog = lDao.getAllLogRows();
			Loan fromSystem = this.loanSystem.getLoans().get(this.loanSystem.getLoans().size()-1);
			Loan fromLog = updatedLog.get(updatedLog.size()-1);
			List<String> actions = lDao.getOneActions(fromSystem.getLoanNumber());
			assertEquals(fromSystem.getLoanNumber(),fromLog.getLoanNumber());
			assertEquals(fromSystem.get_borrower().getName(),fromLog.get_borrower().getName());
			assertEquals(fromSystem.get_tool().getName(),fromLog.get_tool().getName());
			assertEquals("Apertura",actions.get(0));
		} catch (FilloException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void clearExcel() {
		LoanDAO lDAO = new LoanDAO();
		for(Loan l:this.loanSystem.getLoans()) {
			try {
				if(l.getLoanNumber()>2)
					lDAO.delete(l.getLoanNumber());
			} catch (FilloException e) {
				e.printStackTrace();
			}
		}
	}
}
