package model;

import java.util.Observable;
import java.util.Observer;

import Entities.ErrorNotification;

public class ErrorObserver implements Observer{
	
	private ErrorSystem errorSystem;
	
	public ErrorObserver(ErrorSystem errorSystem) {
		this.errorSystem = errorSystem;
	}

	@Override
	public void update(Observable o, Object arg) {
		ErrorNotification error = (ErrorNotification) arg;
		errorSystem.manageError(error);
	}

}
