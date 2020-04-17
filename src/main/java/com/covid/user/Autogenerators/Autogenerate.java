package com.covid.user.Autogenerators;

import org.springframework.stereotype.Component;

import com.covid.user.model.User;
@Component
public class Autogenerate {

	public String getuser_id(User user) {
		String user_id=null;
		user_id="beatCovid19" + user.getAdhaar_id(); 
		return user_id;
	}
	
	
	public String getToken() {
		int random=(int)(Math.random() *1000);
		String token="beatCovid19 " + random; 
		return token;
	}

}
