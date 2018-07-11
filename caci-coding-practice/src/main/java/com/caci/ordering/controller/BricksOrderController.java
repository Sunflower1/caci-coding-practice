package com.caci.ordering.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.caci.ordering.service.BricksOrderService;
import com.caci.ordering.entity.BricksOrder;
import com.caci.ordering.exception.BadRequestException;

/**
 * Created by David Liu
 */
@RestController
@RequestMapping("/orders")
public class BricksOrderController {
	@Autowired
	private BricksOrderService bricksOrderService;
	
	/*
	 * Story 1 : Create an order for purchasing amount of bricks
	 * 
	 * */
	@ResponseBody
	@RequestMapping(path="/{amount}", method=RequestMethod.POST)
	public ResponseEntity<Integer> createOrder(@PathVariable int amount) {
		return ResponseEntity.ok(bricksOrderService.createOrder(amount));
	}
	
	/*
	 * Story 1 : Get an order with reference
	 * 
	 * */
	@ResponseBody
	@RequestMapping(path="/{reference}", method=RequestMethod.GET)
	public ResponseEntity<BricksOrder> getOrder(@PathVariable int reference) {
		return ResponseEntity.ok().body(bricksOrderService.getOrder(reference));
	}
	
	/*
	 * Story 1 : Get all existing orders
	 * 
	 * */
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Set<BricksOrder>> getOrders() {
		return ResponseEntity.ok().body(bricksOrderService.getOrders());
	}
	
	/*
	 * Story 2 : Udate order
	 * 
	 * */
	@ResponseBody
	@RequestMapping(path="/{reference}/{amount}", method=RequestMethod.PUT)
	public ResponseEntity<?> updateOrder(@PathVariable int reference, @PathVariable int amount) {
		try {
			return ResponseEntity.ok(bricksOrderService.updateOrder(reference, amount));
		} catch(BadRequestException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	/*
	 * Story 3 : Fulfil order
	 * 
	 * */
	@ResponseBody
	@RequestMapping(path="/{reference}", method=RequestMethod.PUT)
	public ResponseEntity<?> fulfilOrder(@PathVariable int reference) {
		try {
			bricksOrderService.fulfilOrder(reference);
			return ResponseEntity.ok().build();
		} catch(BadRequestException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
