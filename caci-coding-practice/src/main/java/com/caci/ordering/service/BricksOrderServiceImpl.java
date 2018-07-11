package com.caci.ordering.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caci.ordering.dao.BricksOrderRepository;
import com.caci.ordering.dao.BricksOrderRepositoryImpl;
import com.caci.ordering.entity.BricksOrder;
import com.caci.ordering.exception.BadRequestException;

/**
 * Created by David Liu
 */
@Service
public class BricksOrderServiceImpl implements BricksOrderService {
	public static final String ERR_MESSAGE = "400 - Bad request";
	@Autowired
	private BricksOrderRepository bricksOrderReposity;
	
	public Integer createOrder(int amount) {
		return bricksOrderReposity.addOrder(amount);
	}
	
	public Set<BricksOrder> getOrders() {
		return bricksOrderReposity.getOrders();
	}
	
	public BricksOrder getOrder(int reference) {
		return bricksOrderReposity.getOrder(reference);
	}

	public Integer updateOrder(int reference, int amount) throws BadRequestException {
		if(bricksOrderReposity.getOrder(reference) == null || bricksOrderReposity.getOrder(reference).isDispatched()) 
			throw new BadRequestException(ERR_MESSAGE);
		return bricksOrderReposity.updateOrder(reference, amount);
	}
	
	public boolean fulfilOrder(int reference) throws BadRequestException {
		if(!bricksOrderReposity.fulfilOrder(reference)) throw new BadRequestException(ERR_MESSAGE);
		return true;
	}
	
}
