package com.covid.Controller.Exceptions;

public class FamilyResponse {
private int status_code;
private String message;
private String request_id;

public int getStatus_code() {
	return status_code;
}
public void setStatus_code(int status_code) {
	this.status_code = status_code;
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
@Override
public String toString() {
	return "FamilyResponse [status_code=" + status_code + ", message=" + message + ", request_id=" + request_id + "]";
}
public FamilyResponse(int status_code, String message, String request_id) {
	super();
	this.status_code = status_code;
	this.message = message;
	this.request_id = request_id;
}
}
