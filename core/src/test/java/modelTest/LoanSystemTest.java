package modelTest;

import static org.junit.Assert.*;

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
import model.LoanSystem;
import model.ToolSystem;

public class LoanSystemTest {
	
	private Borrower borrower;
	private ToolType tt;
	private Tool t;
	private Tool t2;
	private LoanSystem loanSystem;
	private List<Tool> listTools;
	
	@Before
	public void prepareDependencies() {
		this.borrower = new Borrower("Goku");
		this.tt = new ToolType("Martillo");
		this.t = new Tool(2,"Taladro #2",this.tt);
		this.t2 = new Tool(3,"Destornillador #2",this.tt);
		this.loanSystem = new LoanSystem(new ArrayList<Tool>());
		try {
			loanSystem.setLoans(new LoanDAO().GetAll());
			loanSystem.setLastLoanNumber();
		} catch (FilloException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testLoanGenerationSucces() {
		assertEquals(loanSystem.getLoans().size(), 3);
		loanSystem.checkLoanGeneration(t, borrower);
		assertEquals(loanSystem.getLoans().size(), 4);
    }
	
	@Test
	public void testLoanGenerationFailure() {
		
		assertEquals(loanSystem.getLoans().size(), 3);
		
		Tool t = new Tool(2,"Taladro #2",this.tt);
		loanSystem.checkLoanGeneration(t, borrower);
		assertEquals(loanSystem.getLoans().size(), 4);
		
        loanSystem.checkLoanGeneration(t, borrower);
        assertEquals(loanSystem.getLoans().size(), 4);
    }
	
	@Test
	public void testLoanListSetter() {
		ArrayList<Loan> loans = new ArrayList<Loan>();
		loans.add(new Loan(0,t,this.borrower));
		loans.add(new Loan(1,t2,this.borrower));
		this.loanSystem.setLoans(loans);
		assertEquals(loanSystem.getLoans().size(), 2);
	}
	
	@Test
	public void testCloseLoan() {
		loanSystem.checkLoanGeneration(t, borrower);
		assertEquals(loanSystem.getLoans().size(), 4);
		try {
			loanSystem.closeLoan(loanSystem.getLoans().get(loanSystem.getLoans().size()-1));
			assertEquals(loanSystem.getLoans().size(), 3);
			/*
		 */
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
