package Entities;

import java.util.Date;

public class SupplyAlarm extends Alarm {
	
	private Supply supply;

	public SupplyAlarm(Supply supply, Date expirationDate) {
		super(expirationDate);
		this.supply = supply;
	}
	
	public Supply getSupply() {
		return this.supply;
	}
	
	@Override
	public String toString() {
		return "SUPPLY ALARM: " + this.supply.toString() + "\n" + this.getExpirationDate().toString();
	}

}
