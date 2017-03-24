package com.examples.spring.model;

import java.text.Collator;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROVINCIAS")
public class Provincia implements Comparable<Provincia>{
	
	@Id
	private Integer id;
	private String nombre;
	private static final Collator collator = Collator.getInstance(new Locale("es"));
	
	public Provincia() {
		super();
	}
	
	public Provincia(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public int compareTo(Provincia provincia) {
		collator.setStrength(Collator.PRIMARY);
		return collator.compare(this.getNombre(), provincia.getNombre());
	}

}
