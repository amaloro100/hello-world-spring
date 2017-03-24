package com.examples.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examples.spring.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {
	
}
