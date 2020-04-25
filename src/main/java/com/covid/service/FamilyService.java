package com.covid.service;

import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.WebRequest;

import com.covid.Autogenerators.Autogenerate;
import com.covid.Repository.FamilyRepository;
import com.covid.model.Family;
import com.covid.model.FamilyAddress;
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

	public Family find(String family_id) {	
		return repos.findById(family_id).orElseThrow(()->new NullPointerException());
	}

	public Family updatemember(Members members,String family_id, String member_id, String user_id) {
		String id=null;
		Family family=repos.findById(family_id).orElseThrow(()->new NullPointerException());
		List<Members> memList  =family.getMembers();
		for(Members i:memList ) {
			id=i.getMember_id();
			if(id.equals(member_id)) {
				i.setMember_id(member_id);
				i.setMember_age(members.getMember_age());
				i.setMember_name(members.getMember_name());
				i.setMember_gender(members.getMember_gender());
				i.setHealth_issues(members.getHealth_issues());
				repos.save(family);
			}
		}
		return family;
	}

	public Family updateAddress(FamilyAddress address,String family_id, String user_id ) {
		Family family=repos.findById(family_id).orElseThrow(null);
		family.setAddress(address);
		repos.save(family);
		return family;
	}
}
