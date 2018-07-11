package com.caci.ordering.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by David Liu
 */
public class BricksOrder {
	private int reference;
	private int amount;
	@JsonIgnore
	private boolean dispatched;
	
	private BricksOrder(int reference, int amount, boolean dispatched) {
		this.reference = reference;
		this.amount = amount;
		this.dispatched = dispatched;
	}
	
	public static BricksOrder createOrder(int reference, int amount, boolean dispatched) {
		return new BricksOrder(reference, amount, dispatched);
	}
	
	public int getReference() {
		return reference;
	}
	
	public void setReference(int reference) {
		this.reference = reference;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public boolean isDispatched() {
		return dispatched;
	}
	
	public void setDispatched(boolean dispatched) {
		this.dispatched = dispatched;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + (dispatched ? 1231 : 1237);
		result = prime * result + reference;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BricksOrder other = (BricksOrder) obj;
		if (amount != other.amount)
			return false;
		if (dispatched != other.dispatched)
			return false;
		if (reference != other.reference)
			return false;
		return true;
	}
	
	
}
