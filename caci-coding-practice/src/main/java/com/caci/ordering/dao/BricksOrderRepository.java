package com.caci.ordering.dao;

import java.util.Set;

import com.caci.ordering.entity.BricksOrder;;

/**
 * Created by David Liu
 */
public interface BricksOrderRepository {
	
	Integer addOrder(int amount);
	Set<BricksOrder> getOrders();
	BricksOrder getOrder(int ref);
	Integer updateOrder(int ref, int amount);
	boolean fulfilOrder(int ref);
}
