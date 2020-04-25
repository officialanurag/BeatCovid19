package com.covid.Controller.Exceptions;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import com.covid.Controller.UserException;
import com.covid.model.Family;


@ControllerAdvice(assignableTypes =com.covid.Controller.FamilyController.class)
public class FamilyExceptionHandler {
String id;

	@ExceptionHandler
	public ResponseEntity<FamilyResponse> handleException(NullPointerException e, WebRequest request){
		String userid=(String)request.getAttribute("user_id",RequestAttributes.SCOPE_SESSION);
		String request_id=userid+"FamilyService"+new Date();
		
		int status_code=HttpStatus.NOT_FOUND.value();
		FamilyResponse errors=new FamilyResponse(status_code,"Resource Not Found",request_id);
		return new ResponseEntity<FamilyResponse>(errors,HttpStatus.NOT_FOUND);
		}
	

@ExceptionHandler
public ResponseEntity<FamilyResponse> DuplicateEntry(DataIntegrityViolationException e,WebRequest request){
	String userid=(String)request.getAttribute("user_id",RequestAttributes.SCOPE_SESSION);

	String request_id= userid+"FamilyService"+new Date();
	
	//System.out.println(family);
	int status_code=HttpStatus.INTERNAL_SERVER_ERROR.value();
	FamilyResponse errors=new FamilyResponse(status_code,"Duplicate Entry",request_id);
	return new ResponseEntity<FamilyResponse>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
}	
	
	@ExceptionHandler
	public ResponseEntity<FamilyResponse> handleException(RuntimeException e, WebRequest request){
		String userid=(String)request.getAttribute("user_id",RequestAttributes.SCOPE_SESSION);

		String request_id= userid+"FamilyService"+new Date();
		
		int status_code=HttpStatus.BAD_REQUEST.value();
		FamilyResponse errors=new FamilyResponse(status_code,e.getLocalizedMessage(),request_id);
		return new ResponseEntity<FamilyResponse>(errors,HttpStatus.BAD_REQUEST);
		}
	
	

	}
	
	
	
	
	
	
	
	
	


