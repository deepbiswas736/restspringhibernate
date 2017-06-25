package com.revolution.raipur.jerseystart.models;
import javax.persistence.Embeddable;

@Embeddable
public class Rating {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
