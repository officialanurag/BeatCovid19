package com.covid.user.Controller;

public class UserException {
private int status;
private int id;
private String message;
private String request_id;
public UserException(int status, int id, String message, String request_id) {
	super();
	this.status = status;
	this.id = id;
	this.message = message;
	this.request_id = request_id;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getRequest_id() {
	return request_id;
}
public void setRequest_id(String request_id) {
	this.request_id = request_id;
}


}
