package com.covid.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Family {
	@Id
	private String family_id;
	@NotNull
	private String family_name;
	@NotNull
	private FamilyAddress address;
	@NotNull
	private List <Members> members;
	@NotNull
	@Indexed(unique=true)
	private String user_id;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFamily_name() {
		return family_name;
	}
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public FamilyAddress getAddress() {
		return address;
	}
	public void setAddress(FamilyAddress address) {
		this.address = address;
	}

	public String getFamily_id() {
		return family_id;
	}
	public void setFamily_id(String family_id) {
		this.family_id = family_id;
	}
	public List<Members> getMembers() {
		return members;
	}
	public void setMembers(List<Members> members) {
		this.members = members;
	}
	@Override
	public String toString() {
		return "Family [family_id=" + family_id + ", family_name=" + family_name + ", address=" + address + ", members="
				+ members + ", user_id=" + user_id + "]";
	}
	
	
	
	
	
}