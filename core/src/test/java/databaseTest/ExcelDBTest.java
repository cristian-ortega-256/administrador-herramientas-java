package databaseTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.codoid.products.exception.FilloException;

import database.ExcelDB;

public class ExcelDBTest {
	
	private ExcelDB db;
	private String query;

	@Before
	public void prepareDependencies() throws FilloException {
		this.db = new ExcelDB();
		this.query = "";
	}
	
	@Test
	public void testReadException() {
		assertEquals(null, this.db.Read(this.query));
	}
	
	@Test
	public void testWriteException() {
		try {
			this.db.Write(this.query);
		} catch (Exception e) {
			assertEquals("Invalid Query - ", e.getMessage());
		}
	}
	
}
