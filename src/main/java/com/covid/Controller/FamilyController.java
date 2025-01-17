package com.covid.Controller;
import com.covid.model.Members;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.covid.model.Family;
import com.covid.model.FamilyAddress;
import com.covid.service.FamilyService;
@RestController
@RequestMapping("/family")
public class FamilyController {
	@Autowired
	FamilyService service;
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/create")
	public Family create(@RequestBody Family family) {
		return service.create(family);
	  }
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/{family_id}")
	public Family find(@PathVariable("family_id") String family_id ) {
		return service.find(family_id);
	  }
	 @ResponseStatus(HttpStatus.CREATED)
	 @PutMapping("/update/{family_id}/member/{member_id}/user/{user_id}")
	 public Family updateMembers(@RequestBody Members members,@PathVariable("family_id") String family_id,@PathVariable("member_id") String member_id,@PathVariable("user_id") String user_id) {
		 Family family=service.updatemember(members, family_id, member_id, user_id);
		return family;
	 }
	 @ResponseStatus(HttpStatus.CREATED)	
	 @PutMapping("/update/{family_id}/user/{user_id}/address")
	 public Family updateAddress(@RequestBody FamilyAddress address,@PathVariable("family_id") String family_id, @PathVariable("user_id") String user_id) {
		 Family family=service.updateAddress(address, family_id, user_id);
		 return family;
	 }
	 
}
