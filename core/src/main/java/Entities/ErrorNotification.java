package Entities;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ErrorNotification {
	
	private JPanel jPanel;
	private String title;
	private String message;
	private ErrorType errorType;
	private int errorLevel;

	public ErrorNotification(String title, String message, ErrorType type, int errorLevel) {
		this.jPanel = new JPanel();
		this.title = title;
		this.message = message;
		this.errorType = type;
		this.errorLevel = this.switchErrorLevel(errorLevel);
	}
	
	public void showError() {
		JOptionPane.showMessageDialog(jPanel, this.message, this.title, this.errorLevel);		
	}
	
	private int switchErrorLevel(int errorLevel) {
		switch(errorLevel) {
			case 1:
				return JOptionPane.ERROR_MESSAGE;
			case 2:
				return JOptionPane.WARNING_MESSAGE;
			default:
				return JOptionPane.INFORMATION_MESSAGE;
		
		}
	}

	public ErrorType getErrorType() {
		return errorType;
	}
	
}
