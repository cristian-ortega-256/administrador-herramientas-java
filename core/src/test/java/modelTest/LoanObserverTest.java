package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codoid.products.exception.FilloException;

import Entities.Alarm;
import Entities.Borrower;
import Entities.Loan;
import Entities.Tool;
import Entities.ToolType;
import database.LoanDAO;
import model.AlarmSystem;
import model.LoanObserver;
import model.LoanSystem;
import model.ToolSystem;

public class LoanObserverTest {
	
	private Borrower borrower;
	private ToolType tt;
	private Tool t;
	private LoanSystem loanSystem;
	private List<Tool> listTools;
	private AlarmSystem alarmSystem;
	
	@Before
	public void prepareDependencies() {
		this.borrower = new Borrower("Goku");
		this.tt = new ToolType("Martillo");
		this.t = new Tool(2,"Taladro #2",this.tt);
		this.loanSystem = new LoanSystem(new ArrayList<Tool>());
		this.alarmSystem = new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		try {
			loanSystem.setLoans(new LoanDAO().GetAll());
			loanSystem.setLastLoanNumber();
		} catch (FilloException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void loanCreatedEventHandlingTest() {
		loanSystem.addObserver(new LoanObserver(alarmSystem));
		loanSystem.checkLoanGeneration(t, borrower);
		assertEquals(1,alarmSystem.getActiveAlarms().size());
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
