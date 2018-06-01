package entityTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Entities.LoanLogRow;

public class LoanLogRowTest {
	
	@Test
	public void testConstructor() {
		LoanLogRow lRow = new LoanLogRow("1","Martillo #1","Goku","Apertura","Tue May 29 22:14:27 ART 2018");
		assertEquals(lRow.getNumber(),"1");
		assertEquals(lRow.getTool(),"Martillo #1");
		assertEquals(lRow.getBorrower(),"Goku");
		assertEquals(lRow.getAction(),"Apertura");
		assertEquals(lRow.getDate(),"Tue May 29 22:14:27 ART 2018");
	}

}
