package Entities;

import java.util.Date;

public class Alarm {
	private static int nextId = 0;
	private int id;
	private Date expirationDate;
	
	public Alarm(Date expirationDate) {
		this.id = this.nextId;
		this.nextId++;
		this.expirationDate = expirationDate;
	}
	
	public int getId() {
		return this.id;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public String toString() {
		return this.expirationDate.toString();
	}
}
