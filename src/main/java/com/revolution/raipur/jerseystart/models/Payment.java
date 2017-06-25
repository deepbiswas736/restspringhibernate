package com.revolution.raipur.jerseystart.models;



import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Payment {
	private double amount;
	private Date date;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
