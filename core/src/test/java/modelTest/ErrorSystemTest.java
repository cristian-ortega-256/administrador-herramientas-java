package modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
//import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import Entities.ErrorNotification;
import Entities.ErrorType;
import model.ErrorSystem;

public class ErrorSystemTest {
	
	private ErrorSystem errorSystem;
	private ErrorNotification error;
	
	@Before
	public void generateDependencies() {
		this.errorSystem = new ErrorSystem(false);
		this.error = new ErrorNotification("title","message",ErrorType.MissingExcelColumn,1);
	}
	
	@Test
	public void testConstructor() {
		assertEquals(errorSystem.getErrors().size(),0);
	}
}
