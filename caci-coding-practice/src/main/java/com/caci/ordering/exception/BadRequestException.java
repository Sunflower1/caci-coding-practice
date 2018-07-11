package com.caci.ordering.exception;

/**
 * Created by David Liu
 */
public class BadRequestException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public BadRequestException(String ex) {
		super(ex);
	}
}
