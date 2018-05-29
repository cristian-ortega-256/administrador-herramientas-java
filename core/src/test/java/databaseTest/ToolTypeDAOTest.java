package databaseTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Entities.ToolType;
import database.ToolTypeDAO;

public class ToolTypeDAOTest {
	
	private Recordset rs;
	private ToolTypeDAO ttDao;
	private ToolType tt;
	
	@Before
	public void prepareDependencies() {
		try {
			this.rs = null;
			this.ttDao = new ToolTypeDAO();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testParseToolType() throws FilloException {
		try {
			this.tt = ttDao.parseToolType(this.rs);
		} catch (Exception e) {
			assertEquals(null, this.tt);
		}
	}
}
