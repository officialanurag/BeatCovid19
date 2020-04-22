package com.covid.Controller;
import com.covid.model.Members;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.model.Family;
import com.covid.service.FamilyService;
@RestController
@RequestMapping("family")
public class FamilyController {
	@Autowired
	FamilyService service;
	@PostMapping("/create")
	public Family create(@RequestBody Family family) {
		return service.create(family);
	  }

}
