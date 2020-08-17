package com.capgemini.onlinetest.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/******************************************
 * 
 * Controller advice exception handling
 *
 ******************************************/

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = EntityAlreadyExists.class)	
	public ResponseEntity<Object> handleEntityAlreadyExists(EntityAlreadyExists exception) {
		
		 HttpStatus badRequest= HttpStatus.BAD_REQUEST;
		 ApiException exp=new ApiException(
				 		 exception.getMessage(),
						 badRequest,
						 ZonedDateTime.now(ZoneId.of("Z")));
		 return new ResponseEntity<>(exp,badRequest);
	}
	

	@ExceptionHandler(value = EntityNotFoundException.class)	
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {

		 HttpStatus badRequest= HttpStatus.BAD_REQUEST;
		 ApiException exp=new ApiException(
		 		 	exception.getMessage(),
		 		 	badRequest,
		 		 	ZonedDateTime.now(ZoneId.of("Z")));
		 return new ResponseEntity<>(exp,badRequest);

	
		}

}
