package com.covid.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
@Component
public class FamilyAddress {
private String address_line_1;
private String address_line_2;
private String city;
private String state;
private String pincode;
public String getAddress_line_1() {
	return address_line_1;
}
public void setAddress_line_1(String address_line_1) {
	this.address_line_1 = address_line_1;
}
public String getAddress_line_2() {
	return address_line_2;
}
public void setAddress_line_2(String address_line_2) {
	this.address_line_2 = address_line_2;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
@Override
public String toString() {
	return "FamilyAddress [address_line1=" + address_line_1 + ", address_line2=" + address_line_2 + ", city=" + city
			+ ", state=" + state + ", pincode=" + pincode + "]";
}
	
	
	
}
