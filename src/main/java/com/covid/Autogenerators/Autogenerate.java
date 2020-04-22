package com.covid.Autogenerators;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.covid.model.Family;
import com.covid.model.User;
@Component
public class Autogenerate {

	public String getuser_id(User user) {
		String user_id=null;
		user_id="beatCovid19" + user.getAdhaar_id(); 
		return user_id;
	}
	
	public String getToken() {
		UUID uuid=UUID.randomUUID();
		String current_token=uuid.toString();
		return current_token;
	}
	
	public String getUUId() {
		UUID uuid=UUID.randomUUID();
		String unique_id=uuid.toString();
		return unique_id;
	}
}
