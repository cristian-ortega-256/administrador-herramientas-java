package entityTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Entities.ErrorNotification;
import Entities.ErrorType;

public class ErrorNotificationTest {
	
	@Test
	public void testErrorTypeSwitch() {
		ErrorNotification error = new ErrorNotification("Error title","Error message",ErrorType.MissingExcelFile,1);
		ErrorNotification error2 = new ErrorNotification("Error title","Error message",ErrorType.MissingExcelColumn,1);
		ErrorNotification error3 = new ErrorNotification("Error title","Error message",ErrorType.MissingExcelSheet,3);
		ErrorNotification error4 = new ErrorNotification("Error title","Error message",ErrorType.ExtraExcelColumn,2);	
		assertEquals(error.getErrorType(),ErrorType.MissingExcelFile);
		assertEquals(error2.getErrorType(),ErrorType.MissingExcelColumn);
		assertEquals(error3.getErrorType(),ErrorType.MissingExcelSheet);
		assertEquals(error4.getErrorType(),ErrorType.ExtraExcelColumn);
	}

}
