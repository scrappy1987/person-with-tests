package com.qa.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.model.Person;
import com.qa.repository.PersonRepository;

@RestController
@RequestMapping("api/v1/")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(value = "persons", method = RequestMethod.GET)
	public List<Person> list() {
		return personRepository.findAll();
	}

	@RequestMapping(value = "persons/{id}", method = RequestMethod.GET)
	public Person get(@PathVariable Long id) {
		return personRepository.findOne(id);
	}
	
}
