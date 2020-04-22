package com.covid.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Members {
	private String member_id;
    private String member_name;
	private int member_age;
    private String member_gender;
    @Autowired
    private List<health_issues> health_issues;
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public int getMember_age() {
		return member_age;
	}
	public void setMember_age(int member_age) {
		this.member_age = member_age;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	public List<health_issues> getHealth_issues() {
		return health_issues;
	}
	public void setHealth_issues(List<health_issues> health_issues) {
		this.health_issues = health_issues;
	}
	@Override
	public String toString() {
		return "Members [member_id=" + member_id + ", member_name=" + member_name + ", member_age=" + member_age
				+ ", member_gender=" + member_gender + ", health_issues=" + health_issues + "]";
	}

}
