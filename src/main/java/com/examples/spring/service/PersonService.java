package com.examples.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.examples.spring.model.Persona;
import com.examples.spring.repository.PersonaRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonaRepository personRepository;
	
	@Transactional
	public List<Persona> getPeople(){
		return personRepository.findAll();
	}
	@Transactional
	public Persona getPersonByUsername(String username){
		return personRepository.findByUsername(username);
	}

	@Transactional
	public Persona savePerson(Persona person){
		return personRepository.save(person);
	}
	
	@Transactional
   public void deletePersonByUsername(String username){
	   Persona persona = personRepository.findByUsername(username);
	   personRepository.delete(persona);
	}
	public boolean userAlreadyExists(Persona person, BindingResult result) {
		if (personRepository.findByUsername(person.getUsername())==null){
			return false;
			
		}else{
			result.rejectValue("username", "userAlreadyExists");
			return true;		}
	}
		
}
