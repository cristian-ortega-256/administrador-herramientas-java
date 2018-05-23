package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import Entities.Alarm;
import Entities.Loan;
import Entities.LoanAlarm;
import Entities.Notification;
import Entities.Supply;
import Entities.SupplyAlarm;

public class NotificationSystem extends Observable {
	
	private List<Notification> notifications;
	
	public NotificationSystem() {
		this.notifications = new ArrayList<Notification>();
	}
	
	private void notifyAllObservers() {
		setChanged();
        notifyObservers(this.notifications);
	}

	public void createNotification(Alarm alarm) {
		if(alarm.getClass().getName().equals("Entities.SupplyAlarm"))
			createSupplyNotification((SupplyAlarm)alarm);
		else {
			createLoanNotification(alarm);
		}
		System.out.println("NOTIFICATIONS AMOUNT " + this.notifications.size());
		System.out.println(this.notifications.get(this.notifications.size()-1).getMessage());
		System.out.println("------------------------------------------");
	}

	private void createLoanNotification(Alarm alarm) {
		if(!hasNotificationAssociated(alarm)) {
			LoanAlarm loanAlarm = (LoanAlarm)alarm;
			this.notifications.add(new Notification("Loan Delayed", this.generateLoanMessage(loanAlarm.getLoan()), alarm));
			this.notifyAllObservers();
		}
	}
	
	private void createSupplyNotification(SupplyAlarm alarm) {
		if(!hasNotificationAssociated(alarm)) {
			SupplyAlarm supplyAlarm = (SupplyAlarm)alarm;
			this.notifications.add(new Notification("Supply Stock Alert", this.generateSupplyMessage(supplyAlarm.getSupply()), alarm));
			this.notifyAllObservers();
		}
	}

	private String generateLoanMessage(Loan loan) {
		String borrowerName = loan.get_borrower().getName();
		String toolName = "The tool " + loan.get_tool().getName();
		return toolName + " lent to " + borrowerName + " is delayed";
	}

	private String generateSupplyMessage(Supply supply) {
		return "The minimun stock of " + supply.getName()
			+ " has been exceeded - Less than " + supply.getMinimumStock();
	}
	
	// TODO --> REFACTOR WITH SUPPLY'S & TOOL'S ID'S USAGE
	private boolean hasNotificationAssociated(Alarm alarm) {
		for(Notification notification: this.notifications) {
			if(notification.getAssociatedAlarm().getId() == alarm.getId())
				return true;
		}
		return false;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

}
