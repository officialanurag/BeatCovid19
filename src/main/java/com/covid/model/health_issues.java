package com.covid.model;

import org.springframework.stereotype.Component;

@Component
public class health_issues {

private String fever;
private String cough;
private String cold;
public String getFever() {
	return fever;
}
public void setFever(String fever) {
	this.fever = fever;
}
public String getCough() {
	return cough;
}
public void setCough(String cough) {
	this.cough = cough;
}
public String getCold() {
	return cold;
}
public void setCold(String cold) {
	this.cold = cold;
}
@Override
public String toString() {
	return "health_issues [fever=" + fever + ", cough=" + cough + ", cold=" + cold + "]";
}
}
