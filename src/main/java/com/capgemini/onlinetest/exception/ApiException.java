package com.capgemini.onlinetest.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {
	
	private final String msg;
	private final HttpStatus httpStatus;
	private final ZonedDateTime timestamp;
	
	public String getMsg() {
		return msg;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
	public ApiException(String msg,HttpStatus httpStatus, ZonedDateTime timestamp) {
		super();
		this.msg = msg;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
	}
	
	

}
