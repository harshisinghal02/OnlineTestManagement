package com.capgemini.onlinetest.exception;
/**
 * 
 * Entity not found exception
 *
 */

public class EntityNotFoundException extends RuntimeException {

	public EntityNotFoundException(String msg) {
		super(msg);
	}

	public EntityNotFoundException(String msg, Throwable cause) {
		super(msg,cause);
	}
}
