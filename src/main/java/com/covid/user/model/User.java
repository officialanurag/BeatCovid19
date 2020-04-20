package com.covid.user.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bol.secure.Encrypted;

@Document
public class User {
@Id
private String user_id;
@NotNull
private String full_name;
@NotNull
@Indexed(unique=true)
private Long phone;
@NotNull
@Indexed(unique=true)
private String email;
@NotNull
@Encrypted
private String password;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@NotNull
private Long adhaar_id;
private Date created_at;
private String current_token;

public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getFull_name() {
	return full_name;
}
public void setFull_name(String full_name) {
	this.full_name = full_name;
}
public Long getPhone() {
	return phone;
}
public void setPhone(Long phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getAdhaar_id() {
	return adhaar_id;
}
public void setAdhaar_id(Long adhaar_id) {
	this.adhaar_id = adhaar_id;
}
public Date getCreated_at() {
	return created_at;
}
public void setCreated_at(Date created_at) {
	this.created_at = created_at;
}
public String getCurrent_token() {
	return current_token;
}
public void setCurrent_token(String current_token) {
	this.current_token = current_token;
}
@Override
public String toString() {
	return "User [user_id=" + user_id + ", full_name=" + full_name + ", phone=" + phone + ", email=" + email
			+ ", password=" + password + ", adhaar_id=" + adhaar_id + ", created_at=" + created_at + ", current_token="
			+ current_token + "]";
}

}
