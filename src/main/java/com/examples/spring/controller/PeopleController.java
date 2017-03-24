package com.examples.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examples.spring.model.Persona;
import com.examples.spring.model.Provincia;
import com.examples.spring.service.PersonService;
import com.examples.spring.service.ProvinciaService;
import com.examples.spring.validator.PersonValidator;

@Controller
@RequestMapping(value = {"/people", "/"})
public class PeopleController {

	

	@Autowired
	PersonService personService;	
		
	@Autowired
	ProvinciaService provinciaService;
	
	@Autowired
	PersonValidator personValidator;
	
	public static final String VIEW_PEOPLE = "people";
	public static final String VIEW_ADD_PERSON = "addPerson";
	public static final String VIEW_EDIT_PERSON = "editPerson";
	public static final String REDIRECT_PEOPLE = "redirect:/" + VIEW_PEOPLE;

	@ModelAttribute("provincias")
	public List<Provincia> getProvincias(){
		List<Provincia> provincias = provinciaService.provinciaFindAll();
		return provincias;
	}
	
//	@InitBinder
//    private void initBinder(WebDataBinder binder) {
//        binder.setValidator(personValidator);
//    }

	/*
	 * GET PEOPLE AND RETURN TO VIEW PEOPLE
	 */
	@GetMapping
	public String getPeople(Model model) {
		model.addAttribute("people", personService.getPeople());
		return VIEW_PEOPLE;
	}

	/*
	 * GET PERSON AND RETURN TO VIEW PERSON
	 */
	@GetMapping("/{username}")
	public String getUser(@PathVariable String username, Model model) {
		Persona persona = personService.getPersonByUsername(username);
		model.addAttribute("person", persona);
		return VIEW_EDIT_PERSON;
	}

	/*
	 * VIEW ADD PERSON
	 */
	@GetMapping("/add")
	public String addPerson(Model model) {
		model.addAttribute("person", new Persona());
		return VIEW_ADD_PERSON;
	}

	/*
	 * ADD PERSON AND PEOPLE REDIRECT
	 */
	@PostMapping("/add")
	public String addPerson(@Valid @ModelAttribute("person") Persona person, BindingResult result, Model model) {
		personValidator.validate(person, result);
		
		if (result.hasErrors()){
			System.out.println(result.getAllErrors());
			return VIEW_ADD_PERSON;
		}
	
		if (personService.userAlreadyExists(person, result)){
			return VIEW_ADD_PERSON;
		}else {
			personService.savePerson(person);
			return REDIRECT_PEOPLE;	
		}
		
	}
	/*
	 * UPDATE PERSON AND PEOPLE REDIRECT
	 */
	@PostMapping("/{username}")
	public String updateUser(@Valid @ModelAttribute("person") Persona person, BindingResult result, @PathVariable String username, Model model) {
		if (result.hasErrors()){
			return VIEW_EDIT_PERSON;
		}
		else {
			personService.savePerson(person);
		}
		return REDIRECT_PEOPLE;
	}

	/*
	 * DELETE PERSON AND PEOPLE REDIRECT
	 */
	@GetMapping("/{username}/delete")
	public String deletePerson(@PathVariable String username, Model model) {		 
		personService.deletePersonByUsername(username);
		return REDIRECT_PEOPLE;
	}

 

}
