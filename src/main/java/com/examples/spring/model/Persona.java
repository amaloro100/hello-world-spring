package com.examples.spring.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the PRODUCTS database table.
 * 
 */
@Entity
@Table(name="PERSONAS")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	@Size(max = 15)
	private String nombre;
	@NotEmpty
	private String apellidos;
	@Size(max = 200)
	private String githubProfile;
	@NotEmpty
	@Size(max = 20)
	private String username;
	@NotNull 
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Past
	private Date fechaNacimiento;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Pattern(regexp="[0-9]{9}")
	private String telefono;
	@NotEmpty
	private String poblacion;
	@ManyToOne
	@JoinColumn(name="provincia")
    private Provincia provincia;
	@NotEmpty
	@Pattern(regexp="[0-9]{8}[A-Z]{1}") // \d{8}[A-Z]{1}
	private String dni;
	
	@NotEmpty
	private String pass;
	
	
	@Transient
	private String repass;

	

	public Persona() {
		// TODO Auto-generated constructor stub
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getGithubProfile() {
		return githubProfile;
	}

	public void setGithubProfile(String githubProfile) {
		this.githubProfile = githubProfile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", githubProfile=" + githubProfile
				+ ", username=" + username + ", fecha_nacimiento=" + fechaNacimiento + ", email=" + email
				+ ", telefono=" + telefono + ", poblacion=" + poblacion + ", dni=" + dni + "]";
	}
	
	public int toID(String nombre)
	{
		int id = 0;
		
		
		
		return id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}

	public Persona(Integer id, String nombre, String apellidos, String githubProfile, String username,
			Date fechaNacimiento, String email, String telefono, String poblacion, Provincia provincia, String dni,
			String pass) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.githubProfile = githubProfile;
		this.username = username;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.telefono = telefono;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.dni = dni;
		this.pass = pass;
	}



	
	}


