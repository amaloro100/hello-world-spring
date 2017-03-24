package com.examples.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examples.spring.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	
	Persona findByUsername(String username);

}