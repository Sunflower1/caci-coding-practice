package com.caci.ordering.service;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.caci.ordering.dao.BricksOrderRepository;
import com.caci.ordering.entity.BricksOrder;

/**
 * Created by David Liu
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class BricksOrderServiceTest {
	
	@Mock
	private BricksOrderRepository bricksOrderRepository;
	
	@InjectMocks 
	private BricksOrderServiceImpl bricksOrderService;
	
	private BricksOrder order1;
	private BricksOrder order2;
	private BricksOrder order3;
	private HashSet<BricksOrder> orders = new HashSet<BricksOrder>();
	
	@Before
	public void setUp() {
		order1 = BricksOrder.createOrder(1, 999, false);
		order2 = BricksOrder.createOrder(2, 100, false);
		order3 = BricksOrder.createOrder(3, 500, false);
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
	}
	
	@After
	public void tearDown() {
		orders.clear();
	}
	
	@Test
	public void testGetOrder() {
		Mockito.when(bricksOrderRepository.getOrder(1)).thenReturn(order1);
		assertEquals(order1, bricksOrderService.getOrder(1));
	}
	
	@Test
	public void testGetOrders() {
		Mockito.when(bricksOrderRepository.getOrders()).thenReturn(orders);
		assertEquals(orders, bricksOrderService.getOrders());
	}
	
}
