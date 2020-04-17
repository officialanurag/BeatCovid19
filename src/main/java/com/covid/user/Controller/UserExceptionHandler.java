package com.covid.user.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
	
@ExceptionHandler
public ResponseEntity<UserException> handleException(Exception e){
	int random=(int)(Math.random() *1000);
	String request_id= "covid19"+random;
	int status_code=HttpStatus.BAD_REQUEST.value();
	UserException errors=new UserException(status_code,random,e.getMessage(),request_id);
	return new ResponseEntity<UserException>(errors,HttpStatus.BAD_REQUEST);
}
}
