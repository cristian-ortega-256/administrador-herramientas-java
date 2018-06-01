package model;

import java.util.ArrayList;
import java.util.List;

import Entities.ErrorNotification;
import Entities.ErrorType;

public class ErrorSystem {
	
	private List<ErrorNotification> errors;
	private boolean visualErrors;
	
	public ErrorSystem(boolean visualErrors) {
		this.errors = new ArrayList<ErrorNotification>();
		this.visualErrors = visualErrors;
	}
	
	public void manageError(ErrorNotification error) {
		errors.add(error);
		if(visualErrors)
			error.showError();
		checkErrorType(error.getErrorType());
	}
	
	public void checkErrorType(ErrorType type) {
		switch(type) {
			case MissingExcelFile:
				this.closeApp();
			case MissingExcelSheet:
				this.closeApp();
			case MissingExcelColumn:
				this.closeApp();
			default:
				break;
		}
	}

	private void closeApp() {
		System.exit(0);
	}

	public List<ErrorNotification> getErrors() {
		return this.errors;
	}
}
