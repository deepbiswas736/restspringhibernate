package com.revolution.raipur.jerseystart.models;
import javax.persistence.Embeddable;

@Embeddable
public class Salary {
	private double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
