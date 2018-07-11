package com.caci.ordering.dao;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.caci.ordering.entity.BricksOrder;

/**
 * Created by David Liu
 */
@Repository
public class BricksOrderRepositoryImpl implements BricksOrderRepository {
	private Set<BricksOrder> orders = new HashSet<BricksOrder>();
	private int reference = 0;
	
	public Integer addOrder(int amount) {
		orders.add(BricksOrder.createOrder(++reference, amount, false));
		return this.reference;
	}
	
	public Set<BricksOrder> getOrders() {
		return orders;
	}
	
	public BricksOrder getOrder(int ref) {
		Optional<BricksOrder> order = orders.stream().filter(ord -> (ord.getReference() == ref)).findAny();
		if(order.isPresent()) return order.get();
		return null;
	}
	
	public Integer updateOrder(int ref, int amount) {
		for(BricksOrder order : orders) {
			if(order.getReference() == ref) {
				order.setAmount(amount);
				return order.getReference();
			}
		}
		return null;
	}
	
	public boolean fulfilOrder(int ref) {
		for(BricksOrder order : orders) {
			if(order.getReference() == ref) {
				order.setDispatched(true);
				return true;
			}
		}
		return false;
	}
}
