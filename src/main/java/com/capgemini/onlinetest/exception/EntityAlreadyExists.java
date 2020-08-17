package com.capgemini.onlinetest.exception;

/**
 * 
 * EntityAlreadyExists Exception
 *
 */
public class EntityAlreadyExists extends RuntimeException {


	public EntityAlreadyExists(String msg) {
		super(msg);
	}

	public EntityAlreadyExists(String msg,Throwable cause) {
		super(msg,cause);
	}
	
}
