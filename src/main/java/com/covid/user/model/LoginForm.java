package com.covid.user.model;

import org.springframework.stereotype.Component;
@Component
public class LoginForm {
private String password;
private String email;

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "LoginForm [password=" + password + ", email=" + email + "]";
}
}
