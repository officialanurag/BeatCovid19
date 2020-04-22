package com.covid.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.Autogenerators.Autogenerate;
import com.covid.Repository.FamilyRepository;
import com.covid.model.Family;
import com.covid.model.Members;
import com.covid.model.User;
@Service
public class FamilyService {
	@Autowired
	FamilyRepository repos;
	@Autowired
	Autogenerate generate;
	public Family create(Family family) {	
		String family_id=generate.getUUId();
		family.setFamily_id(family_id);
		List<Members> members=family.getMembers();
		members.forEach(i->{i.setMember_id(generate.getUUId());});
	    repos.insert(family);
		return family;
	}
	
	
	
	
	
}
