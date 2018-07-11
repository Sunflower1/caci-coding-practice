package com.caci.ordering.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.caci.ordering.dao.BricksOrderRepositoryImpl;
import com.caci.ordering.entity.BricksOrder;
import com.caci.ordering.service.BricksOrderService;

/**
 * Created by David Liu
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BricksOrderController.class)
public class BricksOrderControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private BricksOrderService bricksOrderService;
	@MockBean
	private BricksOrderRepositoryImpl bricksOrderRepository;
	private BricksOrder order;
	
	@Before
	public void setUp() {
		order = BricksOrder.createOrder(1, 999, false);
		bricksOrderRepository.addOrder(999);
		
		Mockito.when(bricksOrderService.getOrder(999)).thenReturn(order);
	}
	
	@Test
	public void testGetOrders() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/orders"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
	
	@Test
	public void testGetOrder() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/orders/1", "reference").accept(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
