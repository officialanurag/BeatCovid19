package com.covid.user.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.mongodb.MongoWriteException;

@ControllerAdvice
public class UserExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<UserException> NullPointer(NullPointerException e, HttpServletResponse response){
		int status = response.getStatus();
		System.out.println(status);
		int random=(int)(Math.random() *10000);
		String request_id= "covid19"+random;
		
			UserException errors=new UserException(HttpStatus.BAD_REQUEST.value(),random,"User Not Found",request_id);
			return new ResponseEntity<UserException>(errors,HttpStatus.BAD_REQUEST);
			
	}


@ExceptionHandler
public ResponseEntity<UserException> DuplicateEntry(DataIntegrityViolationException  exc){
	int random=(int)(Math.random() *10000);
	String request_id= "covid19"+random;
	int status_code=HttpStatus.INTERNAL_SERVER_ERROR.value();
	UserException errors=new UserException(status_code,random,"Duplicate Entry found",request_id);
	return new ResponseEntity<UserException>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
}	
	
	
	
@ExceptionHandler
public ResponseEntity<UserException> handleException(RuntimeException e, HttpServletResponse response){
	int random=(int)(Math.random() *10000);
	String request_id= "covid19"+random;
	int status_code=HttpStatus.BAD_REQUEST.value();
	UserException errors=new UserException(status_code,random,e.getMessage(),request_id);
	return new ResponseEntity<UserException>(errors,HttpStatus.BAD_REQUEST);
	}

}



