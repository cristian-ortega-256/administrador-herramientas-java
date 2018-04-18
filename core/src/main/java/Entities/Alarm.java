package Entities;

import java.util.Date;

public class Alarm {
	
	private Date expirationDate;
	
	public Alarm(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public String toString() {
		return this.expirationDate.toString();
	}
}
