package com.caci.ordering.service;

import java.util.Set;

import com.caci.ordering.entity.BricksOrder;
import com.caci.ordering.exception.BadRequestException;

/**
 * Created by David Liu
 */
public interface BricksOrderService {
	Integer createOrder(int amount);
	Set<BricksOrder> getOrders();
	BricksOrder getOrder(int reference);
	Integer updateOrder(int reference, int amount) throws BadRequestException;
	boolean fulfilOrder(int reference) throws BadRequestException;
}
